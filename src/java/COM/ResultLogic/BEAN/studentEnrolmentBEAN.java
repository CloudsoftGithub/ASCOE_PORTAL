package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import COM.ResultLogic.DAO.studentEnrollmentDAO;
import COM.ResultLogic.MODEL.studentEnrollment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
//@SessionScoped
@ApplicationScoped
public class studentEnrolmentBEAN extends DAO {

    int rowCount = 0;
    String programCode = "";
    String matricNo = "";
    String generatedMatricNoTableName = "";

    private String selectedValue;

    private List<String> States_TitleList = new ArrayList<>();
    private List<String> LGAs_TitleList = new ArrayList<>();
    private int stateId;

    private int id;
    private String firstname;
    private String middlename;
    private String lastaname;
    private Date DOB;
    private String phone;
    private String gender;
    private String nationality;
    private String state;
    private String lga;

    private String username;
    private String password;
    private String confirmpassword;

    private String pinno;
    private String serialno;
    private String status;
    private String matricno;

    private String email;
    private String houseAddress;

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public List<String> getStates_TitleList() {
        return States_TitleList;
    }

    public void setStates_TitleList(List<String> States_TitleList) {
        this.States_TitleList = States_TitleList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastaname() {
        return lastaname;
    }

    public void setLastaname(String lastaname) {
        this.lastaname = lastaname;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getPinno() {
        return pinno;
    }

    public void setPinno(String pinno) {
        this.pinno = pinno;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatricno() {
        return matricno;
    }

    public void setMatricno(String matricno) {
        this.matricno = matricno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public List<String> getLGAs_TitleList() {
        return LGAs_TitleList;
    }

    public void setLGAs_TitleList(List<String> LGAs_TitleList) {
        this.LGAs_TitleList = LGAs_TitleList;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    ///Creating a List method That retrieves the data from Db and display on the selectOneItem (Combobox) for the STATES
    public List<String> get_statesMthd() throws Exception {
        get_SelectedStateId();
        this.Connector();

        States_TitleList.removeAll(States_TitleList);//

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT state FROM states");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (nationality.equalsIgnoreCase("Nigerian")) {
                    States_TitleList.add(rs.getString("state"));//retrieves all the registered States
                } else {
                    //Do not enlist the Nigerian States
                }
            }//end of while-block
        } catch (Exception e) {
            //FacesMessage messag = new FacesMessage(FacesMessage.SEVERITY_FATAL, "State Retrieval Error. ", e.getMessage() + " . Pls, try again");
            //RequestContext.getCurrentInstance().showMessageInDialog(messag);
        } finally {
            //this.Close();
        }

        return States_TitleList;

    }//end of method

    //pulling the stateId for the selected state
    public int get_SelectedStateId() throws Exception {

        this.Connector();

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT id FROM states WHERE state=? ");
            ps.setString(1, state);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stateId = rs.getInt("id");
            }//end of while-block
        } catch (Exception e) {
            FacesMessage messag = new FacesMessage(FacesMessage.SEVERITY_FATAL, "LGAs Retrieval Error. ", e.getMessage() + " . Pls, try again");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "LGAs Retrieval Error. ", e.getMessage() + " . Pls, try again"));
        }

        return stateId;
    }//end of the method

    ///Creating a List method That retrieves the data from Db and display on the selectOneItem (Combobox) for the LGAs
    public List<String> get_LGAsMthd() throws Exception {

        this.Connector();

        LGAs_TitleList.removeAll(LGAs_TitleList);//

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT lga FROM lgas WHERE statesid=? ");
            ps.setInt(1, stateId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LGAs_TitleList.add(rs.getString("lga"));//retrieves all the registered LGAs
            }//end of while-block
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "LGAs Retrieval Error. ", e.getMessage() + " . Pls, try again"));

        } finally {
            //this.Close();
        }

        return LGAs_TitleList;

    }//end of method

    public void studentEnrollmentMethod() throws Exception {
        this.Connector();//

        PreparedStatement st1 = getCn().prepareStatement("select username from studentreg where username=?");
        st1.setString(1, username);

        ResultSet rs = st1.executeQuery();

        PreparedStatement st2 = getCn().prepareStatement("select serialNo,PinNo from studentreg where serialno=? AND pinno=?");
        st2.setString(1, serialno);
        st2.setString(2, pinno);

        ResultSet rs2 = st2.executeQuery();

        if (rs2.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Signup Error. ", "invalid scratch card detail, this card has been used"));

            st1.close();
        } else if (rs.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Signup Error. ", "This username has been signed up, pls use a different username"));
            this.Close();
            st1.close();

        } else {

            /////////CONFIRMING that the scratch card pins and serial exist 
            String PreEnrollmentMyflag = "preUsed";
            String PostEnrollmentMyflag = "used";
            String myStatus = "active";
            programCode = "";//clears the content of the variable before it gets updated 

            //CHECKS THE AUTHENTHICITY OF THE SCRATCH CARD
            PreparedStatement st3 = getCn().prepareStatement("select serialno,pinno from student_signup_scratchcard where serialno=? AND pinno=?");
            st3.setString(1, serialno);
            st3.setString(2, pinno);
            ResultSet rs3 = st3.executeQuery();

            /////////////Confirm that the MATRIC NO exist in the db
            //////STEP1: REMOVE the program code from the given matric no e.g: ER/21/HASO/0001
            programCode = matricno.substring(6, 10);
            System.out.println("Testing Program Code: " + programCode);

            generatedMatricNoTableName = "generatedmatricno_" + programCode.toLowerCase();
            System.out.println("Testing Matric No Generation Table: " + generatedMatricNoTableName);

            /////STEP 2: append the program code to the original table 'generatedMatricno', so you can COMPARE with the appropriate table 
            PreparedStatement st5 = getCn().prepareStatement("select generatedMatricno from " + generatedMatricNoTableName + " WHERE generatedMatricno=? ");
            //st5.setString(1, GeneratedMatricNoTableName);
            st5.setString(1, matricno);

            ResultSet rs5 = st5.executeQuery();

            //CHECKS & PREVENTS DOUBLE ENTRY OF MATRIC NUMBER IN THE 'studentreg' table i.e mit should not allow morethan one person to use same matric no
            PreparedStatement st4 = getCn().prepareStatement("select * from studentreg where matricno=? ");
            st4.setString(1, matricno);
            ResultSet rs4 = st4.executeQuery();

            if (!rs5.next()) { //NOT FOUND, i.e the matric no exist

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Signup Error. ", "Matric no NOT found. Pls, obtain your matric number from the ICT unit!"));

            } else if (rs4.next()) {// Invalid Matric no. IT has been used
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Signup Error. ", "Invalid Matric no. This matriC no. has been used!"));
            } else if (rs3.next()) {

                try {

                    PreparedStatement ps = getCn().prepareStatement("INSERT INTO studentreg VALUES(?, ?, ?,?,? ,?,?,?, ?,?,?,?,?, now(), ?,?, ?,?, ?,?)");
                    ps.setString(1, null);
                    ps.setString(2, matricno);
                    ps.setString(3, firstname);
                    ps.setString(4, middlename);
                    ps.setString(5, lastaname);

                    //Converting the Start Date from Java.util.Date to Java.Sql.Date
                    java.util.Date utilDOBDateQuery = DOB;
                    java.sql.Date sqlDOBDatequery = new java.sql.Date(utilDOBDateQuery.getTime());

                    ps.setDate(6, sqlDOBDatequery);

                    ps.setString(7, phone);
                    ps.setString(8, gender);

                    ps.setString(9, nationality);
                    ps.setString(10, state);
                    ps.setString(11, lga);

                    ps.setString(12, email);
                    ps.setString(13, houseAddress);

                    ps.setString(14, username);
                    ps.setString(15, password);

                    ps.setString(16, serialno);
                    ps.setString(17, pinno);

                    ps.setString(18, myStatus);
                    ps.setString(19, PreEnrollmentMyflag);

                    ps.executeUpdate();
                    rowCount = rowCount + 1;

                    if (rowCount > 0) {

                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You succcessfully signup thank you! ", "you will be redirected!"));
                        ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();

                        PreparedStatement ps1 = getCn().prepareStatement(" UPDATE studentreg SET flag= ? WHERE username=? ");
                        ps1.setString(1, PostEnrollmentMyflag);
                        ps1.setString(2, username);
                        ps1.executeUpdate();

                        redcontext.redirect("successfulStudentSignup.xhtml");
                    }//end of the if-block

                    //clears the variables
                    firstname = "";
                    middlename = "";
                    lastaname = "";
                    state = "";
                    lga = "";
                    nationality = "";
                    phone = "";
                    matricno = "";
                    password = "";
                    pinno = "";
                    serialno = "";
                    email = "";
                    houseAddress = "";

                } catch (Exception e) {
                    throw e;
                } finally {
                    this.Close();//
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Signup Error. ", "invalid scratch card detail. Pls, obtain your card from the sch."));

                st1.close();
                this.Close();
            }//END OF THE ELSE-BLOCK 
        }

    }//end of the method

}//end of the class
