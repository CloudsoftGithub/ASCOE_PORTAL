package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.catalina.manager.util.SessionUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

@ManagedBean
@SessionScoped
public class ApplicantLoginBEAN extends DAO implements Serializable {

    private String appNo;
    private String password;

    private String surname;
    private String orthernames;

    private String theRetrievedSurname;
    private String theRetrievedOrthername;
    private String theRetrievedAppNo;

    private String theApplicantPaymentStatus;
    private String theApplicantPaymentStatusString;

    private String theApplicantBioDataStatus;
    private String theApplicantBioDataStatusString;

    private String theApplicantSchAttendedStatus;
    private String theApplicantSchAttendedStatusString;

    private String theApplicantOlevelResultStatus;
    private String theApplicantOlevelResultString;

    private String theRetrievedApplicationType;
    private String theRetrievedApplicationSession;

    private String the_retreived_Course_Choice;
    private String the_retreived_Surname;
    private String the_retreived_Orthername;
    private String the_retreived_email;
    private String the_retreived_session;
    private String the_retreived_phoneno;
    private String the_retreived_regDate;

    private String the_retreived_DOB;
    private String the_retreived_PlaceOfBirth;
    private String the_retreived_State_of_Origin;
    private String the_retreived_Gender;
    private String the_retreived_lga;

    private String applicant_exam_no_of_sitting;
    private String applicant_exam_type;
    private String applicant_exam_year;
    private String applicant_exam_center_no;
    private String applicant_exam_no;
    private String applicant_subject1;
    private String applicant_subject1_grade;

    private String applicant_subject2;
    private String applicant_subject2_grade;

    private String applicant_subject3;
    private String applicant_subject3_grade;

    private String applicant_subject4;
    private String applicant_subject4_grade;

    private String applicant_subject5;
    private String applicant_subject5_grade;

    private String applicant_subject6;
    private String applicant_subject6_grade;

    private String applicant_subject7;
    private String applicant_subject7_grade;

    private String applicant_subject8;
    private String applicant_subject8_grade;

    private String applicant_subject9;
    private String applicant_subject9_grade;

    private UploadedFile applicant_OLevel_certificate_photo;

    private byte[] applicant_photo_Image;
    private StreamedContent applicant_photo_Image_streamedContentVar;

    int rowCount = 0;
    PreparedStatement ps;
    ResultSet rs;

    private int id;

    private String schoolAttendedName;
    private String uploadDate;
    private String from;
    private String to;
    private String certTitle;

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOrthernames() {
        return orthernames;
    }

    public void setOrthernames(String orthernames) {
        this.orthernames = orthernames;
    }

    public String getTheRetrievedSurname() {
        return theRetrievedSurname;
    }

    public void setTheRetrievedSurname(String theRetrievedSurname) {
        this.theRetrievedSurname = theRetrievedSurname;
    }

    public String getTheRetrievedOrthername() {
        return theRetrievedOrthername;
    }

    public void setTheRetrievedOrthername(String theRetrievedOrthername) {
        this.theRetrievedOrthername = theRetrievedOrthername;
    }

    public String getTheRetrievedAppNo() {
        return theRetrievedAppNo;
    }

    public void setTheRetrievedAppNo(String theRetrievedAppNo) {
        this.theRetrievedAppNo = theRetrievedAppNo;
    }

    public String getTheApplicantPaymentStatus() {
        return theApplicantPaymentStatus;
    }

    public void setTheApplicantPaymentStatus(String theApplicantPaymentStatus) {
        this.theApplicantPaymentStatus = theApplicantPaymentStatus;
    }

    public String getTheApplicantPaymentStatusString() {
        return theApplicantPaymentStatusString;
    }

    public void setTheApplicantPaymentStatusString(String theApplicantPaymentStatusString) {
        this.theApplicantPaymentStatusString = theApplicantPaymentStatusString;
    }

    public String getTheApplicantBioDataStatus() {
        return theApplicantBioDataStatus;
    }

    public void setTheApplicantBioDataStatus(String theApplicantBioDataStatus) {
        this.theApplicantBioDataStatus = theApplicantBioDataStatus;
    }

    public String getTheApplicantBioDataStatusString() {
        return theApplicantBioDataStatusString;
    }

    public void setTheApplicantBioDataStatusString(String theApplicantBioDataStatusString) {
        this.theApplicantBioDataStatusString = theApplicantBioDataStatusString;
    }

    public String getTheApplicantSchAttendedStatus() {
        return theApplicantSchAttendedStatus;
    }

    public void setTheApplicantSchAttendedStatus(String theApplicantSchAttendedStatus) {
        this.theApplicantSchAttendedStatus = theApplicantSchAttendedStatus;
    }

    public String getTheApplicantSchAttendedStatusString() {
        return theApplicantSchAttendedStatusString;
    }

    public void setTheApplicantSchAttendedStatusString(String theApplicantSchAttendedStatusString) {
        this.theApplicantSchAttendedStatusString = theApplicantSchAttendedStatusString;
    }

    public String getTheApplicantOlevelResultStatus() {
        return theApplicantOlevelResultStatus;
    }

    public void setTheApplicantOlevelResultStatus(String theApplicantOlevelResultStatus) {
        this.theApplicantOlevelResultStatus = theApplicantOlevelResultStatus;
    }

    public String getTheApplicantOlevelResultString() {
        return theApplicantOlevelResultString;
    }

    public void setTheApplicantOlevelResultString(String theApplicantOlevelResultString) {
        this.theApplicantOlevelResultString = theApplicantOlevelResultString;
    }

    public String getTheRetrievedApplicationType() {
        return theRetrievedApplicationType;
    }

    public void setTheRetrievedApplicationType(String theRetrievedApplicationType) {
        this.theRetrievedApplicationType = theRetrievedApplicationType;
    }

    public String getTheRetrievedApplicationSession() {
        return theRetrievedApplicationSession;
    }

    public void setTheRetrievedApplicationSession(String theRetrievedApplicationSession) {
        this.theRetrievedApplicationSession = theRetrievedApplicationSession;
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

    public String getThe_retreived_DOB() {
        return the_retreived_DOB;
    }

    public void setThe_retreived_DOB(String the_retreived_DOB) {
        this.the_retreived_DOB = the_retreived_DOB;
    }

    public String getThe_retreived_PlaceOfBirth() {
        return the_retreived_PlaceOfBirth;
    }

    public void setThe_retreived_PlaceOfBirth(String the_retreived_PlaceOfBirth) {
        this.the_retreived_PlaceOfBirth = the_retreived_PlaceOfBirth;
    }

    public String getThe_retreived_State_of_Origin() {
        return the_retreived_State_of_Origin;
    }

    public void setThe_retreived_State_of_Origin(String the_retreived_State_of_Origin) {
        this.the_retreived_State_of_Origin = the_retreived_State_of_Origin;
    }

    public String getThe_retreived_Gender() {
        return the_retreived_Gender;
    }

    public void setThe_retreived_Gender(String the_retreived_Gender) {
        this.the_retreived_Gender = the_retreived_Gender;
    }

    public String getThe_retreived_lga() {
        return the_retreived_lga;
    }

    public void setThe_retreived_lga(String the_retreived_lga) {
        this.the_retreived_lga = the_retreived_lga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolAttendedName() {
        return schoolAttendedName;
    }

    public void setSchoolAttendedName(String schoolAttendedName) {
        this.schoolAttendedName = schoolAttendedName;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCertTitle() {
        return certTitle;
    }

    public void setCertTitle(String certTitle) {
        this.certTitle = certTitle;
    }

    public String getApplicant_exam_no_of_sitting() {
        return applicant_exam_no_of_sitting;
    }

    public void setApplicant_exam_no_of_sitting(String applicant_exam_no_of_sitting) {
        this.applicant_exam_no_of_sitting = applicant_exam_no_of_sitting;
    }

    public String getApplicant_exam_type() {
        return applicant_exam_type;
    }

    public void setApplicant_exam_type(String applicant_exam_type) {
        this.applicant_exam_type = applicant_exam_type;
    }

    public String getApplicant_exam_year() {
        return applicant_exam_year;
    }

    public void setApplicant_exam_year(String applicant_exam_year) {
        this.applicant_exam_year = applicant_exam_year;
    }

    public String getApplicant_exam_center_no() {
        return applicant_exam_center_no;
    }

    public void setApplicant_exam_center_no(String applicant_exam_center_no) {
        this.applicant_exam_center_no = applicant_exam_center_no;
    }

    public String getApplicant_exam_no() {
        return applicant_exam_no;
    }

    public void setApplicant_exam_no(String applicant_exam_no) {
        this.applicant_exam_no = applicant_exam_no;
    }

    public String getApplicant_subject1() {
        return applicant_subject1;
    }

    public void setApplicant_subject1(String applicant_subject1) {
        this.applicant_subject1 = applicant_subject1;
    }

    public String getApplicant_subject1_grade() {
        return applicant_subject1_grade;
    }

    public void setApplicant_subject1_grade(String applicant_subject1_grade) {
        this.applicant_subject1_grade = applicant_subject1_grade;
    }

    public String getApplicant_subject2() {
        return applicant_subject2;
    }

    public void setApplicant_subject2(String applicant_subject2) {
        this.applicant_subject2 = applicant_subject2;
    }

    public String getApplicant_subject2_grade() {
        return applicant_subject2_grade;
    }

    public void setApplicant_subject2_grade(String applicant_subject2_grade) {
        this.applicant_subject2_grade = applicant_subject2_grade;
    }

    public String getApplicant_subject3() {
        return applicant_subject3;
    }

    public void setApplicant_subject3(String applicant_subject3) {
        this.applicant_subject3 = applicant_subject3;
    }

    public String getApplicant_subject3_grade() {
        return applicant_subject3_grade;
    }

    public void setApplicant_subject3_grade(String applicant_subject3_grade) {
        this.applicant_subject3_grade = applicant_subject3_grade;
    }

    public String getApplicant_subject4() {
        return applicant_subject4;
    }

    public void setApplicant_subject4(String applicant_subject4) {
        this.applicant_subject4 = applicant_subject4;
    }

    public String getApplicant_subject4_grade() {
        return applicant_subject4_grade;
    }

    public void setApplicant_subject4_grade(String applicant_subject4_grade) {
        this.applicant_subject4_grade = applicant_subject4_grade;
    }

    public String getApplicant_subject5() {
        return applicant_subject5;
    }

    public void setApplicant_subject5(String applicant_subject5) {
        this.applicant_subject5 = applicant_subject5;
    }

    public String getApplicant_subject5_grade() {
        return applicant_subject5_grade;
    }

    public void setApplicant_subject5_grade(String applicant_subject5_grade) {
        this.applicant_subject5_grade = applicant_subject5_grade;
    }

    public String getApplicant_subject6() {
        return applicant_subject6;
    }

    public void setApplicant_subject6(String applicant_subject6) {
        this.applicant_subject6 = applicant_subject6;
    }

    public String getApplicant_subject6_grade() {
        return applicant_subject6_grade;
    }

    public void setApplicant_subject6_grade(String applicant_subject6_grade) {
        this.applicant_subject6_grade = applicant_subject6_grade;
    }

    public String getApplicant_subject7() {
        return applicant_subject7;
    }

    public void setApplicant_subject7(String applicant_subject7) {
        this.applicant_subject7 = applicant_subject7;
    }

    public String getApplicant_subject7_grade() {
        return applicant_subject7_grade;
    }

    public void setApplicant_subject7_grade(String applicant_subject7_grade) {
        this.applicant_subject7_grade = applicant_subject7_grade;
    }

    public String getApplicant_subject8() {
        return applicant_subject8;
    }

    public void setApplicant_subject8(String applicant_subject8) {
        this.applicant_subject8 = applicant_subject8;
    }

    public String getApplicant_subject8_grade() {
        return applicant_subject8_grade;
    }

    public void setApplicant_subject8_grade(String applicant_subject8_grade) {
        this.applicant_subject8_grade = applicant_subject8_grade;
    }

    public String getApplicant_subject9() {
        return applicant_subject9;
    }

    public void setApplicant_subject9(String applicant_subject9) {
        this.applicant_subject9 = applicant_subject9;
    }

    public String getApplicant_subject9_grade() {
        return applicant_subject9_grade;
    }

    public void setApplicant_subject9_grade(String applicant_subject9_grade) {
        this.applicant_subject9_grade = applicant_subject9_grade;
    }

    public UploadedFile getApplicant_OLevel_certificate_photo() {
        return applicant_OLevel_certificate_photo;
    }

    public void setApplicant_OLevel_certificate_photo(UploadedFile applicant_OLevel_certificate_photo) {
        this.applicant_OLevel_certificate_photo = applicant_OLevel_certificate_photo;
    }

    public byte[] getApplicant_photo_Image() {
        return applicant_photo_Image;
    }

    public void setApplicant_photo_Image(byte[] applicant_photo_Image) {
        this.applicant_photo_Image = applicant_photo_Image;
    }

    public StreamedContent getApplicant_photo_Image_streamedContentVar() {
        return applicant_photo_Image_streamedContentVar;
    }

    public void setApplicant_photo_Image_streamedContentVar(StreamedContent applicant_photo_Image_streamedContentVar) {
        this.applicant_photo_Image_streamedContentVar = applicant_photo_Image_streamedContentVar;
    }

    //RETRIEVING VALUES for 'Matric no' FROM THE UI
    public void retriveAppNoFromUI() {//get the current 'AppNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        appNo = ec.getRequestParameterMap().get("studentPrinApplicationForm:applicant_app_no_from_UI");
    }//end of method

    public void applicantLoginMthd() throws Exception {
        this.Connector();//Db connection 
        //retrieveAPPNO_usingEmail();//
        String Applicant_Navigation_Page = "";

        if (appNo.contains("@")) {

            //QUERY TO CHECK FOR APPLICATION 'PAYMENT STATUS'  (i.e BEFORE PROCEEDING TO BIO DATA AND OTHER DETAILS) 
            PreparedStatement psr1 = this.getCn().prepareStatement("SELECT paymentDate FROM application_for_admission WHERE email=?  ");//OR email=?
            psr1.setString(1, appNo);// FOR PARA1
            // psr.setString(2, the_retreived_email);//FOR PARA2
            ResultSet rs_for_application_payment1 = psr1.executeQuery();

            try {

                PreparedStatement st = this.getCn().prepareStatement(" SELECT appno, generated_password FROM application_signup WHERE  email=? AND phoneno=? ");//appno=? AND generated_password= ? OR
                st.setString(1, appNo);
                st.setString(2, password);
                // st.setString(3, appNo);
                //st.setString(4, password);
                ResultSet rs = st.executeQuery();
                if (rs.next()) // found
                {
                    appNo = rs.getString("appno");

                    // HttpSession session = SessionManagement_util.getSession();//SESSION MANAGEMENT 
                    // session.setAttribute("appNo", appNo);
                   
                    //APPLICATANT NAVIGATION DECISION BASED ON PAYMENT
                    if (rs_for_application_payment1.next()) {
                        Applicant_Navigation_Page = "applicantDashboard.xhtml";
                    } else {
                        Applicant_Navigation_Page = "applicantDashboard_prior_payment.xhtml";
                    }

                    ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                    redcontext.redirect(Applicant_Navigation_Page);   /// redirecting to  the 

                    //CLEAR THE VARIABLES USED AFTER LOGGING
                    password = "";
                    System.err.println("Email@ Man: " + appNo);

                } else {
                    FacesContext.getCurrentInstance().addMessage(
                            null,
                            new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                    "Wrong Login Credentials! " + "  'USERNAME' or 'PASSWORD' NOT correct!",
                                    ".Pls, Supply the correct credentials and try again"));

                }//end of the while-block 

                //RETRIEVE THE NAMES & APP No. OF THE APPLICANT, AFTER A SUCCESSFUL LOGIN 
                reteiveTheNamesOfTheApplicants();//invoked 

                //RETRIEVE THE Applicant  INFO, AFTER A SUCCESSFUL LOGIN 
                reteiveInfoForApplicantionPrintout();//invoked 

                //RETRIVE THE PAYMENT STATUS 
                reteiveTheCompletionStatusForTheApplicants();

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                "Wrong Login Credentials! " + "  'USERNAME' or 'PASSWORD' NOT correct!",
                                ".Pls, Supply the correct credentials and try again"));
            }

        } else {//USER lOGS IN WITH "APP NO"

            //QUERY TO CHECK FOR APPLICATION 'PAYMENT STATUS'  (i.e BEFORE PROCEEDING TO BIO DATA AND OTHER DETAILS) 
            PreparedStatement psr1 = this.getCn().prepareStatement("SELECT paymentDate FROM application_for_admission WHERE appno=?  ");//OR email=?
            psr1.setString(1, appNo);// FOR PARA1
            // psr.setString(2, the_retreived_email);//FOR PARA2
            ResultSet rs_for_application_payment1 = psr1.executeQuery();

            try {
                PreparedStatement st = this.getCn().prepareStatement(" SELECT appno, generated_password FROM application_signup WHERE appno=? AND generated_password= ? ");
                st.setString(1, appNo);
                st.setString(2, password);

                ResultSet rs = st.executeQuery();
                if (rs.next()) // found
                {
                    appNo = rs.getString("appno");

                    // HttpSession session = SessionManagement_util.getSession();//SESSION MANAGEMENT 
                    // session.setAttribute("appNo", appNo);
                    //APPLICATANT NAVIGATION DECISION BASED ON PAYMENT
                    if (rs_for_application_payment1.next()) {
                        Applicant_Navigation_Page = "applicantDashboard.xhtml";
                    } else {
                        Applicant_Navigation_Page = "applicantDashboard_prior_payment.xhtml";
                    }

                    ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                    redcontext.redirect(Applicant_Navigation_Page);   /// redirecting to  the 

                    //CLEAR THE VARIABLES USED AFTER LOGGING
                    password = "";
                    System.err.println("APP NO @ Man: " + appNo);

                } else {
                    FacesContext.getCurrentInstance().addMessage(
                            null,
                            new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                    "Wrong Login Credentials! " + "  'USERNAME' or 'PASSWORD' NOT correct!",
                                    ".Pls, Supply the correct credentials and try again"));
                }//end of the while-block 

                //RETRIEVE THE NAMES & APP No. OF THE APPLICANT, AFTER A SUCCESSFUL LOGIN 
                reteiveTheNamesOfTheApplicants();//invoked 

                //RETRIEVE THE Applicant  INFO, AFTER A SUCCESSFUL LOGIN 
                reteiveInfoForApplicantionPrintout();//invoked 

                //RETRIVE THE PAYMENT STATUS 
                reteiveTheCompletionStatusForTheApplicants();

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                "Wrong Login Credentials! " + "  'USERNAME' or 'PASSWORD' NOT correct!",
                                ".Pls, Supply the correct credentials and try again"));
            }
        }//end of the else-block 

    }//end of the method

    public void reteiveTheNamesOfTheApplicants() throws Exception {
        this.Connector();//invoked the db connection instance 

        try {
            PreparedStatement psr = this.getCn().prepareStatement("SELECT * FROM application_signup WHERE appno=? ");
            psr.setString(1, appNo);// for para1

            ResultSet rs = psr.executeQuery();
            while (rs.next()) {
                theRetrievedSurname = rs.getString("surname");
                theRetrievedOrthername = rs.getString("orther");
                theRetrievedAppNo = rs.getString("appno");
                theRetrievedApplicationType = rs.getString("app_type");
                theRetrievedApplicationSession = rs.getString("session");
                the_retreived_Course_Choice = rs.getString("course_choice");

            }//end of while-block

        } catch (Exception e) {
            throw e;
        }

    }//end of the method 

    public void reteiveTheCompletionStatusForTheApplicants() throws Exception {
        this.Connector();//invoked the db connection instance 

        //QUERY TO CHECK FOR SCHOOL 'PAYMENT STATUS' & 'BIO DATA INFO'
        try {
            PreparedStatement psr = this.getCn().prepareStatement("SELECT paymentDate,gender FROM application_for_admission WHERE appno=?  ");//OR email=?
            psr.setString(1, appNo);// FOR PARA1
            // psr.setString(2, the_retreived_email);//FOR PARA2
            ResultSet rs = psr.executeQuery();
            while (rs.next()) {
                theApplicantPaymentStatus = rs.getString("paymentDate");//Checking the 'paymentDate' column from the 'application_for_admission' table 
                if (!theApplicantPaymentStatus.equalsIgnoreCase("")) {//if the payment column if not empty i.e payment is done
                    theApplicantPaymentStatusString = "PAID ON " + theApplicantPaymentStatus;
                } else {
                    theApplicantPaymentStatusString = "NOT YET PAID" + theApplicantPaymentStatus;
                }

                theApplicantBioDataStatus = rs.getString("gender");//Checking the 'gender' column from the 'application_for_admission' table 
                if (!theApplicantBioDataStatus.equalsIgnoreCase("")) {//if the payment column if not empty i.e payment is done
                    theApplicantBioDataStatusString = " 'BIO-DATA' IS COMPLETED";
                } else {
                    theApplicantBioDataStatusString = " 'BIO-DATA' IS NOT YET COMPLETED!";
                }
            }//end of while-block

            //QUERY TO CHECK FOR SCHOOL 'SCHOOL ATTENDED UPLOAD'
            PreparedStatement ps = this.getCn().prepareStatement("SELECT sch_name FROM applicant_upload_sch_attended WHERE appno=?   ");
            ps.setString(1, appNo);  //FOR PARA2
            // ps.setString(2, the_retreived_email);//FOR PARA2

            System.err.println("Thanks Asheer: " + the_retreived_email);

            ResultSet rs2 = ps.executeQuery();
            while (rs2.next()) {
                theApplicantSchAttendedStatus = rs2.getString("sch_name");//Checking the 'sch_name' column from the 'application_for_admission' table 
                if (!theApplicantSchAttendedStatus.equalsIgnoreCase("")) {//if the sch_name column if not empty i.e payment is done
                    theApplicantSchAttendedStatusString = "COMPLETED ";
                } else {
                    theApplicantSchAttendedStatusString = "NOT COMPLETED";
                }
            }//end of while-block

            //QUERY TO CHECK FOR  applicant 'OLevel Result Upload' 
            PreparedStatement ps3 = this.getCn().prepareStatement("SELECT exam_type FROM applicant_upload_olevel_result WHERE appno=?  ");
            ps3.setString(1, appNo);//FOR PARA1
            //  ps3.setString(2, appNo);//FOR PARA2
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                theApplicantOlevelResultStatus = rs3.getString("exam_type");//Checking the 'exam_type' column from the 'applicant_upload_olevel_result' table 
                if (!theApplicantOlevelResultStatus.equalsIgnoreCase("")) {//if the exam_type column if not empty i.e payment is done
                    theApplicantOlevelResultString = "O'LEVEL RESULT UPLOADED";
                } else {
                    theApplicantOlevelResultString = "NOT UPLOADED";
                }
            }//end of while-block

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

    }//end of the method 

    public void reteiveInfoForApplicantionPrintout() throws Exception {
        this.Connector();//invoked the db connection instance 

        try {
            PreparedStatement psr = this.getCn().prepareStatement("SELECT * FROM application_for_admission WHERE appno=?   ");//OR email=?
            psr.setString(1, appNo);//for para1
            // psr.setString(2, appNo);//for para2

            ResultSet rs = psr.executeQuery();
            while (rs.next()) {
                theRetrievedAppNo = rs.getString("appno");
                theRetrievedApplicationType = rs.getString("app_type");
                the_retreived_Course_Choice = rs.getString("course_choice");

                the_retreived_Gender = rs.getString("gender");
                the_retreived_DOB = rs.getString("DOB");
                the_retreived_PlaceOfBirth = rs.getString("place_of_birth");
                the_retreived_State_of_Origin = rs.getString("state");
                the_retreived_lga = rs.getString("lga");

                the_retreived_email = rs.getString("email");
                the_retreived_phoneno = rs.getString("phoneno");
                applicant_photo_Image = rs.getBytes("photo");
                //  InputStream stream;
                //tream = this.rs.ByteArrayInputStream("");
                //byte[] imageInByteArray = rs.getBytes("photo");
                //DefaultStreamedContent(new ByteArrayInputStream(imageInByteArray), "image/png");
                //applicant_photo_Image_streamedContentVar = (StreamedContent) new DefaultStreamedContent(stream, "application/jpg
                // applicant_photo_Image_streamedContentVar =  DefaultStreamedContent(stream, "image/jpeg/png");

            }//end of while-block

        } catch (Exception e) {
            throw e;
        }

    }//end of the method 

    public List<ApplicantLoginBEAN> getApplicantSchAttendedInfo() throws Exception {
        retriveAppNoFromUI();//invokes the AppNo method

        this.Connector();

        List<ApplicantLoginBEAN> app_sch_attended_info = new ArrayList<ApplicantLoginBEAN>();

        try {

            ps = this.getCn().prepareStatement("select * from applicant_upload_sch_attended WHERE appno=?  order by id ");//AND session=?
            ps.setString(1, theRetrievedAppNo);

            rs = ps.executeQuery();

            while (rs.next()) {
                ApplicantLoginBEAN tbl = new ApplicantLoginBEAN();

                tbl.setId(rs.getInt("id"));
                tbl.setAppNo(rs.getString("appno"));
                tbl.setUploadDate(rs.getString("uploadDate"));
                tbl.setSchoolAttendedName(rs.getString("sch_name"));
                tbl.setFrom(rs.getString("from"));
                tbl.setTo(rs.getString("to"));
                tbl.setCertTitle(rs.getString("cert_title"));
                //tbl.setAppNo(rs.getString("appno"));
                //InputStream stream = this.rs.getBinaryStream("cert_upload");
                // Cert_file = (StreamedContent) new DefaultStreamedContent();

                app_sch_attended_info.add(tbl);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return app_sch_attended_info;

    }//end of the 

    public List<ApplicantLoginBEAN> getApplicant_OLevel_reulst_Info() throws Exception {
        retriveAppNoFromUI();//invokes the AppNo method

        this.Connector();

        List<ApplicantLoginBEAN> applicant_OLevel_result_info = new ArrayList<ApplicantLoginBEAN>();

        try {

            ps = this.getCn().prepareStatement("select * from applicant_upload_olevel_result WHERE appno=?  order by id ");//OR email=?
            ps.setString(1, theRetrievedAppNo);
            //ps.setString(2, the_retreived_email);

            rs = ps.executeQuery();

            while (rs.next()) {
                ApplicantLoginBEAN tbl = new ApplicantLoginBEAN();

                tbl.setId(rs.getInt("id"));
                tbl.setAppNo(rs.getString("appno"));

                tbl.setApplicant_exam_no_of_sitting(rs.getString("no_of_sitting"));
                tbl.setApplicant_exam_type(rs.getString("exam_type"));
                tbl.setApplicant_exam_year(rs.getString("exam_year"));
                tbl.setApplicant_exam_center_no(rs.getString("center_no"));
                tbl.setApplicant_exam_no(rs.getString("exam_no"));

                tbl.setApplicant_subject1(rs.getString("subject1"));
                tbl.setApplicant_subject1_grade(rs.getString("subject1_grade"));

                tbl.setApplicant_subject2(rs.getString("subject2"));
                tbl.setApplicant_subject2_grade(rs.getString("subject2_grade"));

                tbl.setApplicant_subject3(rs.getString("subject3"));
                tbl.setApplicant_subject3_grade(rs.getString("subject3_grade"));

                tbl.setApplicant_subject4(rs.getString("subject4"));
                tbl.setApplicant_subject4_grade(rs.getString("subject4_grade"));
                tbl.setApplicant_subject5(rs.getString("subject5"));
                tbl.setApplicant_subject5_grade(rs.getString("subject5_grade"));

                tbl.setApplicant_subject6(rs.getString("subject6"));
                tbl.setApplicant_subject6_grade(rs.getString("subject6_grade"));

                tbl.setApplicant_subject7(rs.getString("subject7"));
                tbl.setApplicant_subject7_grade(rs.getString("subject7_grade"));

                tbl.setApplicant_subject8(rs.getString("subject8"));
                tbl.setApplicant_subject8_grade(rs.getString("subject8_grade"));

                tbl.setApplicant_subject9(rs.getString("subject9"));
                tbl.setApplicant_subject9_grade(rs.getString("subject9_grade"));

                applicant_OLevel_result_info.add(tbl);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return applicant_OLevel_result_info;

    }//end of the 
}//end of the class 
