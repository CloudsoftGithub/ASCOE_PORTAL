package COM.ResultLogic.DAO;

import COM.ResultLogic.MODEL.studentEnrollment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class studentEnrollmentDAO extends DAO {

    int rowCount = 0;
    String programCode = "";
    String matricNo = "";
    String generatedMatricNoTableName = "";

    private List<String> States_TitleList = new ArrayList<>();

    public List<String> getStates_TitleList() {
        return States_TitleList;
    }

    public void setStates_TitleList(List<String> States_TitleList) {
        this.States_TitleList = States_TitleList;
    }

    public void studentEnrollmentMethod(studentEnrollment stdEnrllmnt) throws Exception {
        this.Connector();//

        PreparedStatement st1 = getCn().prepareStatement("select username from studentreg where username=?");
        st1.setString(1, stdEnrllmnt.getUsername());

        ResultSet rs = st1.executeQuery();

        PreparedStatement st2 = getCn().prepareStatement("select serialNo,PinNo from studentreg where serialno=? AND pinno=?");
        st2.setString(1, stdEnrllmnt.getSerialno());
        st2.setString(2, stdEnrllmnt.getPinno());

        ResultSet rs2 = st2.executeQuery();

        if (rs2.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Signup Error " + "  Pls, try ", " again"));

            st1.close();
        } else if (rs.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Signup Error. " + "  This username has been signed up, pls use a different username. Pls, try ", " again"));

            this.Close();
            st1.close();

        } else {

            /////////CONFIRMING that the scratch card pins and serial exist 
            String myflag = "used";
            String myStatus = "active";
            programCode = "";//clears the content of the variable before it gets updated 

            //CHECKS THE AUTHENTHICITY OF THE SCRATCH CARD
            PreparedStatement st3 = getCn().prepareStatement("select serialno,pinno from student_signup_scratchcard where serialno=? AND pinno=?");
            st3.setString(1, stdEnrllmnt.getSerialno());
            st3.setString(2, stdEnrllmnt.getPinno());
            ResultSet rs3 = st3.executeQuery();

            /////////////Confirm that the MATRIC NO exist in the db
            //////STEP1: REMOVE the program code from the given matric no e.g: ER/2021/HASO/0001
            programCode = stdEnrllmnt.getMatricno().substring(8, 12);
            System.out.println("Testing Program Code: " + programCode);

            generatedMatricNoTableName = "generatedmatricno_" + programCode.toLowerCase();
            System.out.println("Testing Matric No Generation Table: " + generatedMatricNoTableName);

            /////STEP 2: append the program code to the original table 'generatedMatricno', so you can COMPARE with the appropriate table 
            PreparedStatement st5 = getCn().prepareStatement("select generatedMatricno from " + generatedMatricNoTableName + " WHERE generatedMatricno=? ");
            //st5.setString(1, GeneratedMatricNoTableName);
            st5.setString(1, stdEnrllmnt.getMatricno());

            ResultSet rs5 = st5.executeQuery();

            //CHECKS & PREVENTS DOUBLE ENTRY OF MATRIC NUMBER IN THE 'studentreg' table i.e mit should not allow morethan one person to use same matric no
            PreparedStatement st4 = getCn().prepareStatement("select * from studentreg where matricno=? ");
            st4.setString(1, stdEnrllmnt.getMatricno());
            ResultSet rs4 = st4.executeQuery();

            if (!rs5.next()) { //NOT FOUND, i.e the matric no exist

                FacesMessage messag = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Signup Error", "Matric no NOT found. Pls, obtain your matric number from the ICT unit!");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Signup Error. " + "  Matric no NOT found. Pls, obtain your matric number from the ICT unit!,  ", " and try again"));

            } else //FOUND i.e the matric do not exist
            if (rs4.next()) {// Invalid Matric no. IT has been used
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Signup Error. " + "  Invalid Matric no. This matriC no. has been used!", " Pls, check and try again"));

            } else if (rs3.next()) {

                try {

                    PreparedStatement ps = getCn().prepareStatement("INSERT INTO studentreg VALUES(?, ?, ?,?,? ,?,?,?, ?,?,?,?,?, now(), ?,?, ?,?, ?,?)");
                    ps.setString(1, null);
                    ps.setString(2, stdEnrllmnt.getMatricno());
                    ps.setString(3, stdEnrllmnt.getFirstname());
                    ps.setString(4, stdEnrllmnt.getMiddlename());
                    ps.setString(5, stdEnrllmnt.getLastaname());

                    //Converting the Start Date from Java.util.Date to Java.Sql.Date
                    java.util.Date utilDOBDateQuery = stdEnrllmnt.getDOB();
                    java.sql.Date sqlDOBDatequery = new java.sql.Date(utilDOBDateQuery.getTime());

                    ps.setDate(6, sqlDOBDatequery);

                    ps.setString(7, stdEnrllmnt.getPhone());
                    ps.setString(8, stdEnrllmnt.getGender());

                    ps.setString(9, stdEnrllmnt.getNationality());
                    ps.setString(10, stdEnrllmnt.getState());
                    ps.setString(11, stdEnrllmnt.getLga());

                    ps.setString(12, stdEnrllmnt.getEmail());
                    ps.setString(13, stdEnrllmnt.getHouseAddress());

                    ps.setString(14, stdEnrllmnt.getUsername());
                    ps.setString(15, stdEnrllmnt.getPassword());

                    ps.setString(16, stdEnrllmnt.getSerialno());
                    ps.setString(17, stdEnrllmnt.getPinno());

                    ps.setString(18, myStatus);
                    ps.setString(19, myflag);

                    rowCount = ps.executeUpdate();

                    if (rowCount > 0) {

                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You succcessfully signup thank you! ", "you will be redirected!"));
                        ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();

                        redcontext.redirect("successfulStudentSignup.xhtml");
                    }//end of the if-block

                    //clears the variables
                    stdEnrllmnt.setFirstname("");
                    stdEnrllmnt.setMiddlename("");
                    stdEnrllmnt.setLastaname("");
                    stdEnrllmnt.setState("");
                    stdEnrllmnt.setLga("");
                    stdEnrllmnt.setNationality("");
                    stdEnrllmnt.setPhone("");
                    stdEnrllmnt.setMatricno("");
                    stdEnrllmnt.setUsername("");
                    stdEnrllmnt.setPassword("");
                    stdEnrllmnt.setPinno("");
                    stdEnrllmnt.setSerialno("");

                    stdEnrllmnt.setEmail("");
                    stdEnrllmnt.setHouseAddress("");

                } catch (Exception e) {
                    throw e;
                } finally {
                    this.Close();//
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Signup Error. " + "  invalid scratch card detail. Pls, obtain your card from our vendors. ", "  and try again"));
                st1.close();
                this.Close();
            }//END OF THE ELSE-BLOCK 
        }

    }//end of the method

    ///Creating a List method That retrieves the data from Db and display on the selectOneItem (Combobox)
    public List<String> get_statesMthd() throws Exception {
        this.Connector();

        States_TitleList.removeAll(States_TitleList);//

        try {
            //con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/esimbarcode?user=root&password=ash123");

            PreparedStatement ps = this.getCn().prepareStatement("SELECT state FROM states");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                States_TitleList.add(rs.getString("state"));//retrieves all the registered products and ADD into the produ_Title
            }//end of while-block

        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "State Retrieval Error.  " + " . Pls, try again ", "  "));

        } finally {
            this.Close();
        }

        return States_TitleList;

    }//end of method
}//end of the class
