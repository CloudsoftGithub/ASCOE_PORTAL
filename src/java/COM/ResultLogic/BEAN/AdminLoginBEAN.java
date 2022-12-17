package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

@ManagedBean
@SessionScoped
public class AdminLoginBEAN extends DAO {

    int rowCount = 0;
    PreparedStatement ps;
    ResultSet rs;

    private int id;
    private String username;
    private String appNo;

    private String password;
    private String userType;

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

    private String schoolAttendedName;
    private String uploadDate;
    private String from;
    private String to;
    private String certTitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String adminuserLogin() throws Exception {

        this.Connector();

        try {

            Connection con = null;
            PreparedStatement ps = null;
            String myusername = username.toString();
            String mypassword = password.toString();

            PreparedStatement st = this.getCn().prepareStatement("select username, password from adminusers where  username= ? and  password= ? ");
            st.setString(1, myusername);
            st.setString(2, mypassword);

            ResultSet rs = st.executeQuery();
            if (rs.next()) // found
            {
                HttpSession hs = SessionManagement_util.getSession();
                hs.setAttribute(username, username);

                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("headerAdminDashboard.xhtml");   /// redirecting to  the 
 
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                "Invalid username or password! " + "  Pls, use correct credentials",
                                "and try again"));
            }//end of else block

            return "";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Invalid Login! " + "  Pls, make sure you are an Admin User",
                            "Please, Try Again"));

            return "";
        } finally {
            this.Close();
        }

    }//end of method

    public List<AdminLoginBEAN> getApplicant_OLevel_reulst_Info() throws Exception {
        //retriveAppNoFromUI();//invokes the AppNo method

        this.Connector();

        List<AdminLoginBEAN> applicant_OLevel_result_info = new ArrayList<AdminLoginBEAN>();

        try {

            ps = this.getCn().prepareStatement("select * from applicant_upload_olevel_result  ");//WHERE appno=? order by id
            //ps.setString(1, theRetrievedAppNo);

            rs = ps.executeQuery();

            while (rs.next()) {
                AdminLoginBEAN tbl = new AdminLoginBEAN();

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

    public List<AdminLoginBEAN> getApplicantSchAttendedInfo() throws Exception {
        // retriveAppNoFromUI();//invokes the AppNo method

        this.Connector();

        List<AdminLoginBEAN> app_sch_attended_info = new ArrayList<AdminLoginBEAN>();

        try {

            ps = this.getCn().prepareStatement("select * from applicant_upload_sch_attended ");//WHERE appno=? order by id 
            // ps.setString(1, theRetrievedAppNo);

            rs = ps.executeQuery();

            while (rs.next()) {
                AdminLoginBEAN tbl = new AdminLoginBEAN();

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
    
    
    public String signoutMethod() throws IOException {
        HttpSession hs = SessionManagement_util.getSession();
        hs.invalidate();
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("adminUsersLogin.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.username = "";
        this.password = "";
        return "adminUsersLogin.xhtml";
    }

}//end of class
