package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.model.file.UploadedFile;

@ManagedBean
@SessionScoped
public class applicationPaymentBEAN extends DAO {

    int rowCount = 0;
    private String appNo;
    private String pinno;
    private String serialno;
    private String status;
    private String flag;
    private String appType;

    private String the_retreived_ApplicationNumber;
    private String the_retreived_ApplicationType;
    private String the_retreived_Course_Choice;
    private String the_retreived_Surname;
    private String the_retreived_Orthername;
    private String the_retreived_email;
    private String the_retreived_session;
    private String the_retreived_phoneno;
    private String the_retreived_regDate;

    private String the_ApplicationNumber;
    

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    private Date ApplicantPaymentDate;

    public Date getApplicantPaymentDate() {
        return ApplicantPaymentDate;
    }

    public void setApplicantPaymentDate(Date ApplicantPaymentDate) {
        this.ApplicantPaymentDate = ApplicantPaymentDate;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getThe_retreived_ApplicationNumber() {
        return the_retreived_ApplicationNumber;
    }

    public void setThe_retreived_ApplicationNumber(String the_retreived_ApplicationNumber) {
        this.the_retreived_ApplicationNumber = the_retreived_ApplicationNumber;
    }

    public String getThe_retreived_ApplicationType() {
        return the_retreived_ApplicationType;
    }

    public void setThe_retreived_ApplicationType(String the_retreived_ApplicationType) {
        this.the_retreived_ApplicationType = the_retreived_ApplicationType;
    }

    public String getThe_retreived_Course_Choice() {
        return the_retreived_Course_Choice;
    }

    public void setThe_retreived_Course_Choice(String the_retreived_Course_Choice) {
        this.the_retreived_Course_Choice = the_retreived_Course_Choice;
    }

    public String getThe_retreived_Surname() {
        return the_retreived_Surname;
    }

    public void setThe_retreived_Surname(String the_retreived_Surname) {
        this.the_retreived_Surname = the_retreived_Surname;
    }

    public String getThe_retreived_Orthername() {
        return the_retreived_Orthername;
    }

    public void setThe_retreived_Orthername(String the_retreived_Orthername) {
        this.the_retreived_Orthername = the_retreived_Orthername;
    }

    public String getThe_retreived_email() {
        return the_retreived_email;
    }

    public void setThe_retreived_email(String the_retreived_email) {
        this.the_retreived_email = the_retreived_email;
    }

    public String getThe_retreived_session() {
        return the_retreived_session;
    }

    public void setThe_retreived_session(String the_retreived_session) {
        this.the_retreived_session = the_retreived_session;
    }

    public String getThe_retreived_phoneno() {
        return the_retreived_phoneno;
    }

    public void setThe_retreived_phoneno(String the_retreived_phoneno) {
        this.the_retreived_phoneno = the_retreived_phoneno;
    }

    public String getThe_retreived_regDate() {
        return the_retreived_regDate;
    }

    public void setThe_retreived_regDate(String the_retreived_regDate) {
        this.the_retreived_regDate = the_retreived_regDate;
    }

    public String getThe_ApplicationNumber() {
        return the_ApplicationNumber;
    }

    public void setThe_ApplicationNumber(String the_ApplicationNumber) {
        this.the_ApplicationNumber = the_ApplicationNumber;
    }

    //RETRIEVING VALUES for 'Payment' FROM THE UI
    public void retriveAppNoFor_OLevel_ResultFromUI() {//get the current 'AppNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        the_ApplicationNumber = ec.getRequestParameterMap().get("applicantPaymentForm:applicant_app_no_from_UI");
    }//end of method

    public void processApplicantionPayment() throws ClassNotFoundException, Exception {
        retriveAppNoFor_OLevel_ResultFromUI();//invoked
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");
        this.Connector();//invoked the mysql connection instance 

        String PreEnrollmentMyflag = "preUsed";
        String PostEnrollmentMyflag = "used";
        String myStatus = "active";
       // appNo = the_ApplicationNumber;
       
       
System.out.println("checks: "+ the_ApplicationNumber);

        /////////CONFIRMING that the scratch card pins and serial exist 
        PreparedStatement st = getCn().prepareStatement("SELECT PinNo,SerialNo FROM admission_scratchcard WHERE SerialNo=? AND PinNo=?");
        st.setString(1, serialno);
        st.setString(2, pinno);
        ResultSet rs = st.executeQuery();

        try {

            //This App No. does not EXIST
            PreparedStatement st1 = getCn().prepareStatement("select appno from application_signup where appno=?");
            st1.setString(1, the_ApplicationNumber);
            ResultSet rs2 = st1.executeQuery();

            if (!rs2.next()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "AppNo. Error.  This App No. does not EXIST. Please, enter a correct AppNo. ", ""));
                this.Close();
                st1.close();
            } else if (!rs.next()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Scratch Card Error. Invalid scratch card detail. Pls, supply correct card details (ensure that you obtain your card from the Sch/Bank). ", " "));
                this.Close();
                st1.close();
            } else {

                //PULLING APPLICANT INFORMATION BEFORE NAVIGATING 
                retrieveAppNoAndCourseChoice();//invoked 

                //Navigate to the 'confirmPamentPage'
                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("confirm_payment_for_application.xhtml");   /// redirecting to  the 'confirm_payment_for_application' page
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();//
        }

    }//end of the method 

    public void retrieveAppNoAndCourseChoice() throws ClassNotFoundException, Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");
        this.Connector();//invoked the mysql connection instance

        //RETRIEVING THE SIGNUP DETAILS I.E APPNO AND PASSWORD (generated)
        PreparedStatement psr = this.getCn().prepareStatement("SELECT app_type,appno,course_choice,surname,orther,email,session,phoneno,regDate FROM application_signup WHERE appno=? ");
        psr.setString(1, the_ApplicationNumber);
        ResultSet rs = psr.executeQuery();
        while (rs.next()) {
            the_retreived_ApplicationType = rs.getString("app_type");
            the_retreived_ApplicationNumber = rs.getString("appno");
            the_retreived_Course_Choice = rs.getString("course_choice");
            the_retreived_Surname = rs.getString("surname");
            the_retreived_Orthername = rs.getString("orther");
            the_retreived_email = rs.getString("email");
            the_retreived_session = rs.getString("session");
            the_retreived_phoneno = rs.getString("phoneno");
            the_retreived_regDate = rs.getString("regDate");
        }//end of while-block

    }//end of the method 

    public void confirmApplicantionPayment() throws ClassNotFoundException, Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");

        this.Connector();//invoked the mysql connection instance 

        /////////CONFIRMING that the scratch card pins and serial exist 
        String PreEnrollmentMyflag = "preUsed";
        String PostEnrollmentMyflag = "used";
        String myStatus = "active";
        String course_admitted = "Not Yet Admitted";

        PreparedStatement st2 = getCn().prepareStatement("SELECT PinNo,SerialNo FROM application_for_admission WHERE SerialNo=? AND PinNo=? AND flag='used' ");
        st2.setString(1, serialno);
        st2.setString(2, pinno);
        ResultSet rs2 = st2.executeQuery();

        PreparedStatement st = getCn().prepareStatement("SELECT PinNo,SerialNo FROM application_for_admission WHERE appno =? AND session=? ");
        st.setString(1, the_retreived_ApplicationNumber);
        st.setString(2, the_retreived_session);

        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Payment Error. You are already DONE with PAYMENT. Please, log into your dashboard and proceeed to STEP 3 - The 'Bio Data' Form. ", " "));
            this.Close();
            st.close();
        } else if (rs2.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Scratch Card Error. This card has been USED. Please, supply correct card details.", ""));
            this.Close();
            st2.close();
        } else {

            try {
                PreparedStatement ps = getCn().prepareStatement(" INSERT INTO application_for_admission VALUES(?, ?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,  ?,?, ?,?,?,?, ?, ?, now(), ?)");
                ps.setString(1, null);
                ps.setString(2, the_retreived_ApplicationNumber);
                ps.setString(3, the_retreived_ApplicationType);
                ps.setString(4, the_retreived_session);
                ps.setString(5, the_retreived_Course_Choice);
                ps.setString(6, course_admitted);//null

                ps.setString(7, the_retreived_Surname);
                ps.setString(8, the_retreived_Orthername);

                ps.setString(9, null);///gender
                ps.setString(10, null);///DOB
                ps.setString(11, null);///PlaceOfBirth
                ps.setString(12, null);///Nationallity
                ps.setString(13, null);///State
                ps.setString(14, null);///lga
                ps.setString(15, null);///HouseAddress
                ps.setString(16, null);///PermanentHomeAddress

                ps.setString(17, the_retreived_phoneno);
                ps.setString(18, the_retreived_email);

                ps.setString(19, null);///Occupation
                ps.setString(20, null);///nextOfKin
                ps.setString(21, null);///Relationship
                ps.setString(22, null);///Relationship

                ps.setString(23, the_retreived_regDate);
                ps.setString(24, serialno);
                ps.setString(25, pinno);
                ps.setString(26, myStatus);//Status
                ps.setString(27, PreEnrollmentMyflag);//Flag
                //ps.setString(27, "now()");//PaymentDate
                ps.setString(28, null);//photo

                ps.executeUpdate();
                rowCount = rowCount + 1;

                if (rowCount > 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Payment  is succeful for: " + the_retreived_ApplicationType.toUpperCase() + " " + the_retreived_Course_Choice.toUpperCase(), ". Please, log into your dashboard and complete STEP 3 - The 'Bio Data Form'. "));
                    ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();

                    //UPDATING THE 'FLAG' from 'PreEnrollment' to 'PostEnrollment'
                    PreparedStatement ps1 = getCn().prepareStatement(" UPDATE application_for_admission SET flag= ? WHERE appno=? ");
                    ps1.setString(1, PostEnrollmentMyflag);
                    ps1.setString(2, appNo);
                    ps1.executeUpdate();

                    // redcontext.redirect("successful_application_for_addmission.xhtml");
                }//end of the if-block

                //clears the variables
            } catch (Exception e) {
                throw e;
            } finally {
                this.Close();//
            }
        }//end of the else block
    }//end of the method 

    public void clearVariablesAfterPayment() {

    }//end of the method

}//end of the 
