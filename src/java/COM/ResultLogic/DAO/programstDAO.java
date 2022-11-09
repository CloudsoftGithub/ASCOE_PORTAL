package COM.ResultLogic.DAO;

import COM.ResultLogic.MODEL.department;
import COM.ResultLogic.MODEL.programms;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class programstDAO extends DAO {

    int rowCount = 0;
    String progrmCode = "";

    public void programmsEnrollmentMethod(programms progrm) throws Exception {
        this.Connector(); //invoked 
        String dommyDoneBy = "Admin";

        String TheRetrivedDepartmenentTitle = "";

        //checking for duplicate entries 
        PreparedStatement st1 = getCn().prepareStatement("select * from programs where title=? OR code=? ");
        st1.setString(1, progrm.getTitle());
        st1.setString(2, progrm.getCode());
        ResultSet rs = st1.executeQuery();

        if (rs.next()) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "The supplied 'Program' Name OR Code has been used. Pls, check your entries!", "thank you!"));

        } else {
            /////

            ///Check if the Department written has been populated into the 'department' table
            PreparedStatement st2 = getCn().prepareStatement("select title from department where title=? ");
            st2.setString(1, progrm.getDepartment());
            System.out.println("Deparment Title:" + progrm.getDepartment());

            ResultSet rs2 = st2.executeQuery();

            //Step1: Check if the Department title was enrolled
            if (rs2.next()) {

                TheRetrivedDepartmenentTitle = rs2.getString(1);

                //Step2: if yes. Do insertion into the concrete table first
                try {
                    PreparedStatement ps = getCn().prepareStatement("INSERT INTO programs VALUES(?,?,?,?, now(), ?)");

                    ps.setString(1, null);
                    ps.setString(2, progrm.getTitle());
                    ps.setString(3, progrm.getCode());
                    ps.setString(4, progrm.getDuration());
                    ps.setString(5, dommyDoneBy);
                    rowCount = ps.executeUpdate();

                    ///////////////////////////////
                    System.out.println("TESTING JUST AFTER INSERTION Deparment title: " + progrm.getTitle());

                    /////////////////////// INSERTING INTO THE RELATIONSHIP TABLE
                    //Step3: INSERTING INTO THE RELATIONSHIP TABLE
                    ///////////////
                    if (rowCount > 0) {
                        this.Connector();
                        PreparedStatement ps2 = getCn().prepareStatement("INSERT INTO programs_has_department SELECT  programs.id,department.id FROM department INNER JOIN programs ON department.title=? AND programs.title=? ");
                        ps2.setString(1, progrm.getDepartment());
                        ps2.setString(2, progrm.getTitle());
                        ps2.executeUpdate();

                    }//end of the if-block 

                    if (rowCount > 0) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Programms ' " + progrm.getTitle() + " has been enrolled successfully. Thank you.", ""));

                    }//end of the if-block

                    /////////////CREATING THE CORRESPONDING registration TABLES FOR THE VARIOUS PROGRAMS 
                    ////////////////////
                    progrmCode = progrm.getCode();
                    
                    /*
                    
                    
                                   String mytablename = "studentreg_" + progrmCode;

                    if (rowCount > 0) {
                        PreparedStatement ps2 = getCn().prepareStatement(" CREATE TABLE IF NOT EXISTS " + mytablename + " LIKE studentreg ");
                        ps2.executeUpdate();

                    }//end of the if-block
                    
                     */

                    /////////////CREATING THE  matricNo Generation 'generatedmatricno' TABLES FOR THE VARIOUS PROGRAMS 
                    ////////////////////
                    progrmCode = progrm.getCode();
                    String myMatricNoGentablename = "generatedmatricno_" + progrmCode;

                    if (rowCount > 0) {
                        PreparedStatement ps2 = getCn().prepareStatement(" CREATE TABLE IF NOT EXISTS " + myMatricNoGentablename + " LIKE generatedmatricno ");
                        ps2.executeUpdate();

                    }//end of the if-block

                    //Clearing variables after insertion is done
                    progrm.setDepartment("");
                    progrm.setCode("");
                    progrm.setDuration("");
                    progrm.setTitle("");

                } catch (Exception e) {
                    throw e;
                } finally {
                    this.Close(); // this is been commented in order allow the below quesry to get executed
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                "This department title IS NOT enrolled before. " + "  Pls, enroll the department first, ",
                                "and try again"));

            }

        }

    }//end of the method 

}//end of the class
