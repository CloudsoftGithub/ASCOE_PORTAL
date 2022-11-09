/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
  
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import net.bootsfaces.component.message.Message;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

@ManagedBean
@ViewScoped
public class view_list_of_applicants extends DAO implements Serializable {
  private static final long serialVersionUID = 1L;
    private boolean edit = false;

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    private Applicant applicant = new Applicant();//Applicant Instance 
    private ApplicantEditDAO applicantDAO = new ApplicantEditDAO();

    public ApplicantEditDAO getApplicantDAO() {
        return applicantDAO;
    }

    public void setApplicantDAO(ApplicantEditDAO applicantDAO) {
        this.applicantDAO = applicantDAO;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    PreparedStatement ps;
    ResultSet rs;

    private String app_Type;

    private int Id;
    private String appNo;
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
    private String the_retreived_nationality;
    private String the_retreived_PaymentDate;
    private String intakeSession;
    private String course_choise;

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

    private List<String> intakeSessionList = new ArrayList<>();
    private List<String> couse_choiseList = new ArrayList<>();

    private String schoolAttendedName;
    private String uploadDate;
    private String from;
    private String to;
    private String certTitle;

    private String the_ApplicationNumber;

    public String getApp_Type() {
        return app_Type;
    }

    public void setApp_Type(String app_Type) {
        this.app_Type = app_Type;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
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

    public String getThe_retreived_nationality() {
        return the_retreived_nationality;
    }

    public void setThe_retreived_nationality(String the_retreived_nationality) {
        this.the_retreived_nationality = the_retreived_nationality;
    }

    public String getThe_retreived_PaymentDate() {
        return the_retreived_PaymentDate;
    }

    public void setThe_retreived_PaymentDate(String the_retreived_PaymentDate) {
        this.the_retreived_PaymentDate = the_retreived_PaymentDate;
    }

    public String getIntakeSession() {
        return intakeSession;
    }

    public void setIntakeSession(String intakeSession) {
        this.intakeSession = intakeSession;
    }

    public List<String> getIntakeSessionList() {
        return intakeSessionList;
    }

    public void setIntakeSessionList(List<String> intakeSessionList) {
        this.intakeSessionList = intakeSessionList;
    }

    public List<String> getCouse_choiseList() {
        return couse_choiseList;
    }

    public void setCouse_choiseList(List<String> couse_choiseList) {
        this.couse_choiseList = couse_choiseList;
    }

    public String getCourse_choise() {
        return course_choise;
    }

    public void setCourse_choise(String course_choise) {
        this.course_choise = course_choise;
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

    public String getThe_ApplicationNumber() {
        return the_ApplicationNumber;
    }

    public void setThe_ApplicationNumber(String the_ApplicationNumber) {
        this.the_ApplicationNumber = the_ApplicationNumber;
    }


    /*
     //RETRIEVING VALUES for  FROM THE UI
    public void retriveAppNoFromUI() {//get the current 'AppNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        the_ApplicationNumber = ec.getRequestParameterMap().get("form_for_editable_datatable:InputAppNo");
    }//end of method

     */
    public List<view_list_of_applicants> getListsOfTheApplicants() throws Exception {
        this.Connector();

        List<view_list_of_applicants> appliant_info = new ArrayList<view_list_of_applicants>();

        try {

            ps = this.getCn().prepareStatement("select * from application_for_admission WHERE session=?  ");
            ps.setString(1, intakeSession);//select specific session

            rs = ps.executeQuery();

            while (rs.next()) {
                view_list_of_applicants tbl = new view_list_of_applicants();
                tbl.setId(rs.getInt("id"));
                tbl.setAppNo(rs.getString("appno"));
                tbl.setApp_Type(rs.getString("app_type"));
                tbl.setThe_retreived_session(rs.getString("session"));
                tbl.setThe_retreived_Course_Choice(rs.getString("course_choice"));
                tbl.setThe_retreived_Surname(rs.getString("surname"));
                tbl.setThe_retreived_Orthername(rs.getString("orther"));
                tbl.setThe_retreived_Gender(rs.getString("gender"));
                tbl.setThe_retreived_DOB(rs.getString("DOB"));
                tbl.setThe_retreived_PlaceOfBirth(rs.getString("place_of_birth"));
                tbl.setThe_retreived_nationality(rs.getString("nationality"));
                tbl.setThe_retreived_State_of_Origin(rs.getString("state"));
                tbl.setThe_retreived_lga(rs.getString("lga"));
                tbl.setThe_retreived_regDate(rs.getString("regDate"));
                tbl.setThe_retreived_PaymentDate(rs.getString("paymentDate"));

                appliant_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return appliant_info;

    }//end of the method

    public List<view_list_of_applicants> getListsOfTheApplicantsByCourse() throws Exception {
        this.Connector();

        List<view_list_of_applicants> appliant_info = new ArrayList<view_list_of_applicants>();

        try {

            ps = this.getCn().prepareStatement("select * from application_for_admission WHERE session=? AND course_choice=? ");
            ps.setString(1, intakeSession);//select specific session
            ps.setString(2, course_choise);

            rs = ps.executeQuery();

            while (rs.next()) {
                view_list_of_applicants tbl = new view_list_of_applicants();
                tbl.setId(rs.getInt("id"));
                tbl.setAppNo(rs.getString("appno"));
                tbl.setApp_Type(rs.getString("app_type"));
                tbl.setThe_retreived_session(rs.getString("session"));
                tbl.setThe_retreived_Course_Choice(rs.getString("course_choice"));
                tbl.setThe_retreived_Surname(rs.getString("surname"));
                tbl.setThe_retreived_Orthername(rs.getString("orther"));
                tbl.setThe_retreived_Gender(rs.getString("gender"));
                tbl.setThe_retreived_DOB(rs.getString("DOB"));
                tbl.setThe_retreived_PlaceOfBirth(rs.getString("place_of_birth"));
                tbl.setThe_retreived_nationality(rs.getString("nationality"));
                tbl.setThe_retreived_State_of_Origin(rs.getString("state"));
                tbl.setThe_retreived_lga(rs.getString("lga"));
                tbl.setThe_retreived_regDate(rs.getString("regDate"));
                tbl.setThe_retreived_PaymentDate(rs.getString("paymentDate"));

                appliant_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return appliant_info;

    }//end of the method

    public List<String> getintakeSessionInfoMthd() throws Exception {
        //retriveDepartmentNameFromUI();//invoked
        intakeSessionList.removeAll(intakeSessionList);

        this.Connector();

        try {

            ps = this.getCn().prepareStatement("SELECT session FROM intakesessioninfo ");
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

    public List<String> get_Course_ChoiceMthd() throws Exception {

        this.Connector();
        couse_choiseList.removeAll(couse_choiseList);//

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT title FROM programs ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                couse_choiseList.add(rs.getString("title"));//retrieves all the registered LGAs

            }//end of while-block
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "LGAs Retrieval Error. ", e.getMessage() + " . Pls, try again"));

        } finally {
            //this.Close();
        }

        return couse_choiseList;

    }//end of method

    public List<view_list_of_applicants> getadmissionDecisionForApplicants() throws Exception {
        this.Connector();

        List<view_list_of_applicants> appliant_info = new ArrayList<view_list_of_applicants>();

        try {

            ps = this.getCn().prepareStatement("select * from application_for_admission WHERE session=? ");//AND course_choice=?

            ps.setString(1, intakeSession);//select specific session
            //ps.setString(2, the_retreived_Course_Choice);

            rs = ps.executeQuery();

            while (rs.next()) {
                view_list_of_applicants tbl = new view_list_of_applicants();
                tbl.setId(rs.getInt("id"));
                tbl.setAppNo(rs.getString("appno"));
                tbl.setApp_Type(rs.getString("app_type"));
                tbl.setThe_retreived_session(rs.getString("session"));
                tbl.setThe_retreived_Course_Choice(rs.getString("course_choice"));
                tbl.setThe_retreived_Surname(rs.getString("surname"));
                tbl.setThe_retreived_Orthername(rs.getString("orther"));
                tbl.setThe_retreived_State_of_Origin(rs.getString("state"));
                tbl.setThe_retreived_lga(rs.getString("lga"));

                appliant_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return appliant_info;

    }//end of the method

    public void onRowSelect(SelectEvent<Item> event) {
        FacesMessage msg = new FacesMessage("Item Selected", event.getObject().getItem());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //View Applicants Info
    public List<view_list_of_applicants> getapplicant_OLevel_reulst_Info() throws Exception {

        this.Connector();

        List<view_list_of_applicants> applicant_OLevel_result_info = new ArrayList<view_list_of_applicants>();

        try {

            ps = this.getCn().prepareStatement("select * from applicant_upload_olevel_result");//WHERE appno=? order by id //AND session=?
            //ps.setString(1, intakeSession);
            // ps.setString(2, applicationNo);

            rs = ps.executeQuery();

            while (rs.next()) {
                view_list_of_applicants tbl = new view_list_of_applicants();

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

    //View the applicant School Attended
    public List<view_list_of_applicants> getapplicantSchAttendedInfo() throws Exception {
        //retriveAppNoFromUI();//invokes the AppNo method

        this.Connector();

        List<view_list_of_applicants> app_sch_attended_info = new ArrayList<view_list_of_applicants>();

        try {

            ps = this.getCn().prepareStatement("select * from applicant_upload_sch_attended ");//WHERE appno=? order by id  //AND session=?
            // ps.setString(1, theRetrievedAppNo);

            rs = ps.executeQuery();

            while (rs.next()) {
                view_list_of_applicants tbl = new view_list_of_applicants();

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

    ////fetch the selected Row FROM THE Applicant LIST (order to decide on the selected Applicant)
    public List<view_list_of_applicants> decideAdmissionForApplicantWithCommandLink(String myApplicationNo) throws Exception {

        this.Connector();

        List<view_list_of_applicants> applicant_OLevel_result_info = new ArrayList<view_list_of_applicants>();

        try {
            ps = this.getCn().prepareStatement("select * from applicant_upload_olevel_result WHERE appno=? ");//WHERE appno=? order by id //AND session=?
            ps.setString(1, myApplicationNo);
            System.out.println("Sample App No:" + myApplicationNo);
            rs = ps.executeQuery();

            while (rs.next()) {
                view_list_of_applicants tbl = new view_list_of_applicants();

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

    public void sendForm() {

        System.out.println("Testing the Application No:" + appNo);

    }//end of the method

    public void editApplicantRow(Applicant a, int id) {

    }//end of the method

    public void onRowEdit(RowEditEvent<Applicant> event) throws Exception {
         applicant.setAppNo(String.valueOf(event.getObject().getAppNo()));
        applicant.setThe_Course_Choice(String.valueOf(event.getObject().getThe_Course_Choice()));
        applicant.setThe_email(String.valueOf(event.getObject().getThe_email()));
        applicant.setThe_Surname(String.valueOf(event.getObject().getThe_Orthername()));
        applicant.setThe_Orthername(String.valueOf(event.getObject().getThe_Surname()));

        try {
            applicantDAO.editRow(applicant, String.valueOf(event.getObject().getAppNo()));

            System.out.println("Tesitng OnRowEdit: " + "AppNo:" + applicant.getAppNo() + "Capture Course-Choice:" + applicant.getThe_Course_Choice());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Row Edited for: " + "AppNo: " + applicant.getAppNo() + "Course given: " + applicant.getThe_Course_Choice(), " . Thank you"));

        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Row Edited has Failed: " + e.getMessage(), " .Pls, try again. "));

        } finally {
            this.Close();
        }
    }//end of the method 

    public void onRowCancel(RowEditEvent<Applicant> event) {//RowEditEvent<myap> event

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "\n \n Row Edit Canceled! ", " . Thank you" + "\n \n Please Check."));

    }//end of the method 

    public String decideOnAdmission(String coursechoice, String applicatioNo) throws Exception {

        this.Connector();//invoked 

        try {
            PreparedStatement ps = getCn().prepareStatement(" UPDATE application_for_admission SET course_choice=?  WHERE appno=? ");
            ps.setString(1, coursechoice);
            ps.setString(2, applicatioNo);

            ps.executeUpdate();

            System.out.println("Tesitng OnRowEdit: " + "AppNo:" + the_ApplicationNumber + "Capture Course-Choice:" + course_choise);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.Close();
        }

        return "view_applicant_list?faces-redirect=true";
    }//end of the method

    public String decideOnAdmission() throws Exception {

        this.Connector();//invoked 

        try {
            PreparedStatement ps = getCn().prepareStatement(" UPDATE application_for_admission SET course_choice=?  WHERE appno=? ");
            ps.setString(1, course_choise);
            ps.setString(2, the_ApplicationNumber);

            ps.executeUpdate();

            System.out.println("Tesitng OnRowEdit: " + "AppNo:" + the_ApplicationNumber + "Capture Course-Choice:" + course_choise);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.Close();
        }

        return "view_applicant_list?faces-redirect=true";
    }//end of the method

}//end of the class 
