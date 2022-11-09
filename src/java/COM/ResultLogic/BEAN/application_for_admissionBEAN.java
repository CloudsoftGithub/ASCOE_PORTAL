package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import java.io.IOException;
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
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

@ManagedBean
@SessionScoped
public class application_for_admissionBEAN extends DAO {

    PreparedStatement ps;
    ResultSet rs;
    int rowCount = 0;
    private String appNo;
    private String applicationTpe;
    private String course_choise;
    private String surname;
    private String othername;
    private String gender;
    private Date DOB;
    private String placeOfBirth;
    private String houseAddress;
    private String permanentAddress;
    private String phoneno;
    private String email;
    private String nationality;
    private String occupation;
    private String nextofkin;
    private String relationship;
    private String sponsorship;
    private String regdate;
    private String username;
    private String password;
    private String confirmpassword;
    private String serialno;
    private String pinno;
    private String status;
    private String flag;
    private String the_ApplicationNumber;
    private String my_GeneratedPassword;
    private String the_Retrieved_Generatedpassword;
    private String the_Retrieved_course_choice;
    private String session;
    private List<String> intakeSessionList = new ArrayList<>();

    private String applicant_sch_attended_name;
    private UploadedFile applicant_certificate_photo;
    private String applicant_sch_attended_Date_From;
    private String applicant_sch_attended_Date_To;
    private String applicant_sch_attended_TitileofCert;

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
    private String the_retrieved_applicant_gender;

    public String getThe_retrieved_applicant_gender() {
        return the_retrieved_applicant_gender;
    }

    public void setThe_retrieved_applicant_gender(String the_retrieved_applicant_gender) {
        this.the_retrieved_applicant_gender = the_retrieved_applicant_gender;
    }

    public List<String> getIntakeSessionList() {
        return intakeSessionList;
    }

    public void setIntakeSessionList(List<String> intakeSessionList) {
        this.intakeSessionList = intakeSessionList;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getThe_Retrieved_course_choice() {
        return the_Retrieved_course_choice;
    }

    public void setThe_Retrieved_course_choice(String the_Retrieved_course_choice) {
        this.the_Retrieved_course_choice = the_Retrieved_course_choice;
    }

    public String getThe_Retrieved_Generatedpassword() {
        return the_Retrieved_Generatedpassword;
    }

    public void setThe_Retrieved_Generatedpassword(String the_Retrieved_Generatedpassword) {
        this.the_Retrieved_Generatedpassword = the_Retrieved_Generatedpassword;
    }

    public String getMy_GeneratedPassword() {
        return my_GeneratedPassword;
    }

    public void setMy_GeneratedPassword(String my_GeneratedPassword) {
        this.my_GeneratedPassword = my_GeneratedPassword;
    }

    public String getThe_ApplicationNumber() {
        return the_ApplicationNumber;
    }

    public void setThe_ApplicationNumber(String the_ApplicationNumber) {
        this.the_ApplicationNumber = the_ApplicationNumber;
    }

    public String getApplicant_sch_attended_name() {
        return applicant_sch_attended_name;
    }

    public void setApplicant_sch_attended_name(String applicant_sch_attended_name) {
        this.applicant_sch_attended_name = applicant_sch_attended_name;
    }

    public UploadedFile getApplicant_certificate_photo() {
        return applicant_certificate_photo;
    }

    public void setApplicant_certificate_photo(UploadedFile applicant_certificate_photo) {
        this.applicant_certificate_photo = applicant_certificate_photo;
    }

    public String getApplicant_sch_attended_Date_From() {
        return applicant_sch_attended_Date_From;
    }

    public void setApplicant_sch_attended_Date_From(String applicant_sch_attended_Date_From) {
        this.applicant_sch_attended_Date_From = applicant_sch_attended_Date_From;
    }

    public String getApplicant_sch_attended_Date_To() {
        return applicant_sch_attended_Date_To;
    }

    public void setApplicant_sch_attended_Date_To(String applicant_sch_attended_Date_To) {
        this.applicant_sch_attended_Date_To = applicant_sch_attended_Date_To;
    }

    public String getApplicant_sch_attended_TitileofCert() {
        return applicant_sch_attended_TitileofCert;
    }

    public void setApplicant_sch_attended_TitileofCert(String applicant_sch_attended_TitileofCert) {
        this.applicant_sch_attended_TitileofCert = applicant_sch_attended_TitileofCert;
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

    private List<String> States_TitleList = new ArrayList<>();
    private List<String> LGAs_TitleList = new ArrayList<>();
    private int stateId;

    private String state;
    private String lga;

    private UploadedFile applicantPhoto;

    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getApplicationTpe() {
        return applicationTpe;
    }

    public void setApplicationTpe(String applicationTpe) {
        this.applicationTpe = applicationTpe;
    }

    public String getCourse_choise() {
        return course_choise;
    }

    public void setCourse_choise(String course_choise) {
        this.course_choise = course_choise;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNextofkin() {
        return nextofkin;
    }

    public void setNextofkin(String nextofkin) {
        this.nextofkin = nextofkin;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(String sponsorship) {
        this.sponsorship = sponsorship;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
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

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getPinno() {
        return pinno;
    }

    public void setPinno(String pinno) {
        this.pinno = pinno;
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

    public UploadedFile getApplicantPhoto() {
        return applicantPhoto;
    }

    public void setApplicantPhoto(UploadedFile applicantPhoto) {
        this.applicantPhoto = applicantPhoto;
    }

    public List<String> getCouse_choiseList() {
        return couse_choiseList;
    }

    public void setCouse_choiseList(List<String> couse_choiseList) {
        this.couse_choiseList = couse_choiseList;
    }

    private List<String> couse_choiseList = new ArrayList<>();

    public List<String> getStates_TitleList() {
        return States_TitleList;
    }

    public void setStates_TitleList(List<String> States_TitleList) {
        this.States_TitleList = States_TitleList;
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

    //RETRIEVING VALUES for 'Student Level' FROM THE UI
    public void retriveApplicationNoFromUI() {//get the current 'ApplicationNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        the_ApplicationNumber = ec.getRequestParameterMap().get("studentRegForm:applicant_app_no_from_UI");
    }//end of method

    //RETRIEVING VALUES for 'retriveAppNoFor_OLevel_Result' FROM THE UI
    public void retriveAppNoFor_OLevel_ResultFromUI() {//get the current 'AppNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        the_ApplicationNumber = ec.getRequestParameterMap().get("studentOLevelUploadForm:applicant_app_no_from_UI");
    }//end of method

    //RETRIEVING VALUES for 'Session' FROM THE UI
    public void retriveSessionFromUI() {//get the current 'Session' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("studentRegForm:mysession");
    }//end of method

    public List<String> get_Course_ChoiceMthd() throws Exception {

        this.Connector();
        couse_choiseList.removeAll(couse_choiseList);//

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT title FROM programs ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (applicationTpe.equalsIgnoreCase("NCE")) {
                    couse_choiseList.add(rs.getString("title"));//retrieves all the registered LGAs
                } else {
                    //Do not enlist the Nigerian States
                }
            }//end of while-block
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "LGAs Retrieval Error. ", e.getMessage() + " . Pls, try again"));

        } finally {
            //this.Close();
        }

        return couse_choiseList;

    }//end of method

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

    public void applicant_Sch_attended_upload() throws Exception {
        retriveApplicationNoFromUI();//invoked 

        Class.forName("com.mysql.cj.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");
        this.Connector();//invoked the mysql connection instance 
        /////////CONFIRMING that the scratch card pins and serial exist 

        PreparedStatement st = getCn().prepareStatement("SELECT cert_title FROM applicant_upload_sch_attended WHERE appno=? AND cert_title=? AND sch_name=? ");
        st.setString(1, the_ApplicationNumber);
        st.setString(2, applicant_sch_attended_TitileofCert);
        st.setString(3, applicant_sch_attended_name);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {//record found
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "School Attended Upload Error", " This Certificate has been uploaded . Please, upload others (if any) OR log in and proceed with STEP 5 - ' Proceed to upload O'Level Result' "));
        } else {

            try {
                UploadedFile uploadAppCertPhoto = getApplicant_certificate_photo();

                PreparedStatement ps = getCn().prepareStatement(" INSERT INTO applicant_upload_sch_attended VALUES(?,?,now(),?,?,?,?,? )");
                ps.setString(1, null);
                ps.setString(2, the_ApplicationNumber);
                ps.setString(3, applicant_sch_attended_name);
                ps.setString(4, applicant_sch_attended_Date_To);
                ps.setString(5, applicant_sch_attended_Date_From);
                ps.setString(6, applicant_sch_attended_TitileofCert);
                ps.setBinaryStream(7, uploadAppCertPhoto.getInputStream());//Photo

                ps.executeUpdate();

                rowCount = rowCount + 1;

                if (rowCount > 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Applicant School Attended Uploaded Succcessfully for: " + applicant_sch_attended_TitileofCert.toUpperCase(), ". Pls, upload other cert(s) if any. Thank you."));
                    //ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                }
                //clears the variables
                applicant_sch_attended_name = "";
                applicant_sch_attended_Date_To = "";
                applicant_sch_attended_Date_From = "";
                applicant_sch_attended_TitileofCert = "";
            } catch (Exception e) {
                throw e;
            } finally {
                this.Close();//
            }
        }
    }//end of the method 

    public void applicant_OLevel_upload() throws Exception {
        retriveAppNoFor_OLevel_ResultFromUI();//invoked  

        Class.forName("com.mysql.cj.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");
        this.Connector();//invoked the mysql connection instance 

        int noOfSitting_counter = 0;

        

        //THIS EXAM TYPE HAS BEEN ADDED ALREADY 
        PreparedStatement st2 = getCn().prepareStatement("SELECT exam_type,exam_year,center_no,exam_no FROM applicant_upload_olevel_result WHERE appno=? AND exam_type=? AND exam_year=? AND center_no=? AND exam_no=? ");
        st2.setString(1, the_ApplicationNumber);
        st2.setString(2, applicant_exam_type);
        st2.setString(3, applicant_exam_year);
        st2.setString(4, applicant_exam_center_no);
        st2.setString(5, applicant_exam_no);
        ResultSet r2s = st2.executeQuery();

        //THIS EXAM 'sitting' TYPE HAS BEEN ADDED ALREADY. Pls, select a different type 
        PreparedStatement st = getCn().prepareStatement("SELECT no_of_sitting FROM applicant_upload_olevel_result WHERE appno=? AND no_of_sitting=? ");
        st.setString(1, the_ApplicationNumber);
        st.setString(2, applicant_exam_no_of_sitting);
        ResultSet rs = st.executeQuery();

        
        if (r2s.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "O'Level Result Upload Error.", " THIS 'EXAM TYPE' "+ applicant_exam_type+ "HAS BEEN ADDED ALREADY. Please, select a different 'Exam Type' "));
        } else if (rs.next()) {//record found
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "O'Level Result Upload Error.", " THIS EXAM 'sitting' TYPE HAS BEEN ADDED ALREADY. Pls, select a different 'Exam Sitting Type'  "));
        } else {

            try {
                UploadedFile uploadApp_OLevel_CertPhoto = getApplicant_OLevel_certificate_photo();

                PreparedStatement ps = getCn().prepareStatement(" INSERT INTO applicant_upload_olevel_result VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?, now(),? )");
                ps.setString(1, null);
                ps.setString(2, the_ApplicationNumber);
                ps.setString(3, applicant_exam_no_of_sitting);

                ps.setString(4, applicant_exam_type);
                ps.setString(5, applicant_exam_year);
                ps.setString(6, applicant_exam_center_no);
                ps.setString(7, applicant_exam_no);

                ps.setString(8, applicant_subject1);
                ps.setString(9, applicant_subject1_grade);
                ps.setString(10, applicant_subject2);
                ps.setString(11, applicant_subject2_grade);

                ps.setString(12, applicant_subject3);
                ps.setString(13, applicant_subject3_grade);
                ps.setString(14, applicant_subject4);
                ps.setString(15, applicant_subject4_grade);
                ps.setString(16, applicant_subject5);
                ps.setString(17, applicant_subject5_grade);
                ps.setString(18, applicant_subject6);
                ps.setString(19, applicant_subject6_grade);
                ps.setString(20, applicant_subject7);
                ps.setString(21, applicant_subject7_grade);
                ps.setString(22, applicant_subject8);
                ps.setString(23, applicant_subject8_grade);
                ps.setString(24, applicant_subject9);
                ps.setString(25, applicant_subject9_grade);
                ps.setBinaryStream(26, uploadApp_OLevel_CertPhoto.getInputStream());//Photo

                ps.executeUpdate();

                rowCount = rowCount + 1;

                if (rowCount > 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Applicant 'O Level Result' Uploaded Succcessfully for: " + applicant_exam_type.toUpperCase() + " For: " + applicant_exam_no_of_sitting, ". Thank you."));
                    //  ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                }
                //clears the variables
                applicant_exam_no_of_sitting = "";
                applicant_exam_center_no = "";
                applicant_exam_type = "";
                applicant_exam_year = "";
                applicant_exam_no = "";

            } catch (Exception e) {
                throw e;
            } finally {
                this.Close();//
            }
        }
    }//end of the method 

    public void applicant_SubmitBioData() throws Exception {
        retriveApplicationNoFromUI();//invoked
        int biodata_counter = 0;
        Object BioData_flag = null;
        Object Payment_flag = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");
        this.Connector();//invoked the mysql connection instance 

        /////////CONFIRMING that the payment is done before preceeding to upload 'BIO DATA' info
        PreparedStatement st2 = getCn().prepareStatement("SELECT paymentDate FROM application_for_admission WHERE appno=? ");
        st2.setString(1, the_ApplicationNumber);
        ResultSet rs2 = st2.executeQuery();
        while (!rs2.next()) {
            Payment_flag = rs.getObject("paymentDate");//this is the  paymentDate column for the 'Payment', so if completed, its assumed that PAYMENT IS DONE, ELSE NOT ...

        }//end of while-block

        if (Payment_flag != null) {//Payment NOT DONE, since the column is set null

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Bio Data Upload Error. ", " YOU HAVE NOT PAID FOR THIS APPLICATION. Please, go back to STEP2 before proceeding with this step (i.e STEP 3) "));

        } else if (Payment_flag == null) {//payment is DONE, then proceed to upload 'BIO Data'

            //The Bio Data for this applicant WAS ALREDY UPLOADED. Please, log in and proceed with STEP 4 - ' upload school(s) attended info'
            PreparedStatement st = getCn().prepareStatement("SELECT gender FROM application_for_admission WHERE appno=? ");
            st.setString(1, the_ApplicationNumber);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                BioData_flag = rs.getObject("gender");//this is the first column for the 'Bio Data Upload', so its assumed that if  its populated then all other bio data info are also populated            
            }//end of while-block

            if (BioData_flag == null) {
                //this means nothing was populated (since the column is null by defaul). and therefore, we are going to update the column now 

                try {
                    UploadedFile uploadAssignment = getApplicantPhoto();

                    PreparedStatement ps = getCn().prepareStatement(" UPDATE application_for_admission SET gender = ?, DOB=?, place_of_birth=?, nationality=?, state=?, lga=?, houseAddress=?, permanent_home_address=?, occupation=?, next_of_kin=?, relationship=?, sponsorship=?, photo=?  WHERE appno=? ");
                    ps.setString(1, gender);///gender

                    //Converting the Start Date from Java.util.Date to Java.Sql.Date
                    java.util.Date utilDOBDateQuery = DOB;
                    java.sql.Date sqlDOBDatequery = new java.sql.Date(utilDOBDateQuery.getTime());
                    ps.setDate(2, sqlDOBDatequery);///DOB

                    ps.setString(3, placeOfBirth);///PlaceOfBirth
                    ps.setString(4, nationality);///Nationallity
                    ps.setString(5, state);///State
                    ps.setString(6, lga);///lga
                    ps.setString(7, houseAddress);///HouseAddress
                    ps.setString(8, permanentAddress);///PermanentHomeAddress

                    ps.setString(9, occupation);///Occupation
                    ps.setString(10, nextofkin);///nextOfKin
                    ps.setString(11, relationship);///Relationship
                    ps.setString(12, sponsorship);///Relationship
                    ps.setBinaryStream(13, uploadAssignment.getInputStream());//Photo
                    ps.setString(14, the_ApplicationNumber);///Retrieve from UI  "the_ApplicationNumber"

                    ps.executeUpdate();

                    rowCount = rowCount + 1;

                    if (rowCount > 0) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Applicant Bio Data Updated Succcessfully. Please, log in again and proceed with STEP 4 - (upload school(s) attended info)  ", ". Thank you."));
                        // ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                    }
                    //clears the variables
                    gender = "";
                    nationality = "";
                    houseAddress = "";
                    occupation = "";
                    permanentAddress = "";
                    nextofkin = "";
                } catch (Exception e) {
                    throw e;
                } finally {
                    this.Close();//
                }

            } else if (BioData_flag != null) {//here, the column is not null i.e it has been populated 
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Bio Data Upload Error. ", " The Bio Data for this applicant WAS ALREDY UPLOADED. Please, log in and proceed with STEP 4 - ' upload school(s) attended info' "));

            }//end of the else-block for the 'BioData_flag'

        }//end of the else block for the 'Payment_flag'
    }//end of the method 

    public void applicationSignupMthd() throws ClassNotFoundException, Exception {
       Class.forName("com.mysql.cj.jdbc.Driver");
       // Class.forName("com.mysql.jdbc.Driver");
        
        this.Connector();//invoked the mysql connection instance 
        /////////CONFIRMING that the scratch card pins and serial exist 
        String PreEnrollmentMyflag = "preUsed";
        String PostEnrollmentMyflag = "used";
        String myStatus = "active";

        //String AppNo_Initials = "APP" ;
        String AppNo_Initials = applicationTpe;
        String VerificationInitial_Flag = "Not_verified";
        emailAddress = email;
        my_GeneratedPassword = generateRandomNumber();//invoked the 'generateRandomNumber' method

        PreparedStatement st1 = getCn().prepareStatement("select email from application_signup where email=?");
        st1.setString(1, email);
        ResultSet rs = st1.executeQuery();
        if (rs.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Signup Error. This email address has been used. Pls, use a different email", ""));
            this.Close();
            st1.close();
        } else {

            try {

                PreparedStatement ps = getCn().prepareStatement(" INSERT INTO application_signup VALUES( ?,?,?,?,?, ?,?,?,?, now(),? )");
                ps.setString(1, null);
                ps.setString(2, AppNo_Initials);
                ps.setString(3, applicationTpe);
                ps.setString(4, session);
                ps.setString(5, course_choise);
                ps.setString(6, surname);
                ps.setString(7, othername);

                ps.setString(8, phoneno);
                ps.setString(9, email);
                ps.setString(10, my_GeneratedPassword);
                ps.executeUpdate();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You have succcessfully signed up for - " + course_choise.toUpperCase(), ". Pls, check your email to proceed with the application!"));
                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();

                rowCount = rowCount + 1;

                if (rowCount > 0) {

                    //UPDATING THE 'APPNO' from just 'APP' to 'APP'+ID i.e APP001
                    PreparedStatement ps2 = getCn().prepareStatement(" UPDATE application_signup SET appno= concat(appno,id) WHERE email=? ");
                    ps2.setString(1, email);
                    ps2.executeUpdate();

                    // redcontext.redirect("successful_application_for_addmission.xhtml");
                }//end of the if-block

                //RETRIEVING THE SIGNUP DETAILS I.E APPNO AND PASSWORD (generated)
                retrieveAppNoAndGenPassword();

                //SENDING E-MAIL TO VERIFY THE SUPPLY 'email address' for the applicant 
                sendCertApplicationMail();//invoked 

            } catch (Exception e) {
                throw e;
            }
        }

    }//end of the method 

    public void retrieveAppNoAndGenPassword() throws ClassNotFoundException, Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");
        this.Connector();//invoked the mysql connection instance

        //RETRIEVING THE SIGNUP DETAILS I.E APPNO AND PASSWORD (generated)
        PreparedStatement psr = this.getCn().prepareStatement("SELECT appno,generated_password,course_choice FROM application_signup WHERE email=? ");
        psr.setString(1, emailAddress);
        ResultSet rs = psr.executeQuery();
        while (rs.next()) {
            the_ApplicationNumber = rs.getString("appno");
            the_Retrieved_Generatedpassword = rs.getString("generated_password");
            the_Retrieved_course_choice = rs.getString("course_choice");
            System.out.println("Testing appno/Gen. Password: " + the_ApplicationNumber + the_Retrieved_Generatedpassword);
        }//end of while-block

    }//end of the method 

    public void sendCertApplicationMail() throws IOException, Exception {
        System.out.println("Im sending to: " + emailAddress);

        Email from = new Email("cloudsoftconsultingltd@gmail.com");
        String subject = "AHLUS-SUFFAH COLLEGE OF EDUCATION (ASCOE) - Online Application Signup (Confirmation Email)";
        Email toRecipient = new Email(emailAddress);
        Content content = new Content("text/html", " <br/> <div style=\"background: lightgray\" >" + "<h5>" + "<br/> Dear  " + surname + " " + othername + ", " + "<br/>" + "<br/> Thank you for your application.  <br/> Copy the generated information below to log (Applicant Login) into your dashboard and continue with your application; "
                + "<br/> <br/>  " + " <strong> " + "Session: " + session + "<br />" + "Course_choice: " + the_Retrieved_course_choice + "<br/>" + " Application Number: " + the_ApplicationNumber + " <br/> Password: " + the_Retrieved_Generatedpassword + "<strong/>" + " <br/> " + "<br/> " + "Thank you." + " <br/> " + "<strong>" + "Signed:" + "<br/> " + "  Online Application System, <br /> Ahlussuffah College of Education (ACOE), <br/> Kaduna Nigeria. " + "</strong>" + "</h5>" + "</div>");
        Mail mail = new Mail(from, subject, toRecipient, content);

        SendGrid sg = new SendGrid(APIKeyClass.apiKey);

        Request request = new Request();

        System.out.println("Testing before sending the mail");

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());

            //Clear Variables 
            clearVariables();//invoked 
        } catch (Exception e) {
            throw e;
        }

    }//end of the sendMail method    

    public String generateRandomNumber() {
        StringBuilder sb = new StringBuilder(9);
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        for (int i = 0; i < 9; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }//end of the method 

    public void clearVariables() {
        
        session = "";
        applicationTpe ="";
        course_choise ="";
        surname = "";
        othername = "";
        phoneno = "";
        email = "";
    }//end of the method 

    public List<String> getSessionInfoForStudentRegMthd() throws Exception {
        retriveSessionFromUI();//

        //retriveDepartmentNameFromUI();//invoked
        intakeSessionList.removeAll(intakeSessionList);

        this.Connector();

        try {

            ps = this.getCn().prepareStatement("SELECT session FROM intakesessioninfo order by session Desc limit 1");
            rs = ps.executeQuery();

            while (rs.next()) {
                intakeSessionList.add(rs.getString("session"));//retrieves all the sessions  and ADD into the intakeSessionList
            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Intake Session Error", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return intakeSessionList;

    }//end of method
}//end of the class
