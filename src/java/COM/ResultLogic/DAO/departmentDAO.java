package COM.ResultLogic.DAO;

import COM.ResultLogic.MODEL.department;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class departmentDAO extends DAO implements Serializable {

    int rowCount = 0;

    public void departmentEnrollmentMthd(department deprtmnt) throws Exception {
        this.Connector(); //invoked 
        String dommyDoneBy = "Admin";

        String TheRetrivedFacultyTitle = "";

        //checking for duplicate entries 
        PreparedStatement st1 = getCn().prepareStatement("select * from department where title=? OR code=? ");
        st1.setString(1, deprtmnt.getTitle());
        st1.setString(2, deprtmnt.getCode());
        ResultSet rs = st1.executeQuery();

        if (rs.next()) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "The supplied 'Department' Name OR Code has been used. Pls, check your entries!", "thank you!"));

        } else {
            /////

            ///Check if the faculty/School written has been populated into the 'faculty/school' table
            PreparedStatement st2 = getCn().prepareStatement("select title from faculty where title=? ");
            st2.setString(1, deprtmnt.getFaculty());
            System.out.println("Faculty Title:" + deprtmnt.getFaculty());

            ResultSet rs2 = st2.executeQuery();

            //Step1: Check if the Faculty title was enrolled
            if (rs2.next()) {

                TheRetrivedFacultyTitle = rs2.getString(1);

                //Step2: if yes. Do insertion into the concrete table first
                try {
                    PreparedStatement ps = getCn().prepareStatement("INSERT INTO department VALUES(?,?,?, now(), ?)");

                    ps.setString(1, null);
                    ps.setString(2, deprtmnt.getTitle());
                    ps.setString(3, deprtmnt.getCode());
                    ps.setString(4, dommyDoneBy);
                    rowCount = ps.executeUpdate();

                    ///////////////////////////////
                    System.out.println("TESTING JUST AFTER INSERTION Deparment title: " + deprtmnt.getTitle());

                    /////////////////////// INSERTING INTO THE RELATIONSHIP TABLE
                    //Step3: INSERTING INTO THE RELATIONSHIP TABLE
                    ///////////////
                    if (rowCount > 0) {
                        this.Connector();
                        PreparedStatement ps2 = getCn().prepareStatement("INSERT INTO faculty_has_department SELECT  faculty.id,department.id FROM faculty INNER JOIN department ON faculty.title=? AND department.title=? ");
                        ps2.setString(1, deprtmnt.getFaculty());
                        ps2.setString(2, deprtmnt.getTitle());
                        ps2.executeUpdate();
 
                    }//end of the if-block 

                    if (rowCount > 0) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Department ' " + deprtmnt.getTitle() + " has been enrolled successfully. Thank you.", ""));

                    }//end of the if-block

                    //Clearing variables after insertion is done
                    deprtmnt.setInstituition("");
                    deprtmnt.setCode("");

                } catch (Exception e) {
                    throw e;
                } finally {
                    this.Close(); // this is been commented in order allow the below quesry to get executed
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                "This faculty title IS NOT enrolled before. " + "  Pls, enroll the faculty first, ",
                                "and try again"));

            }

        }

    }//end of the method 

}//end of the class
