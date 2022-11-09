package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class verify_course_registration extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    int verifyCounter = 0;
    int resetCounter = 0;
    private int id;
    private String status;
    private String verifyAction;

    private String comment;
    private String name;
    private String semester;
    private String level;
    private String coursecode;
    private String coursecode_for_list;
    private String coursetitle;
    private int creditunit;
    String part1;
    String part2;
    private List<String> coursesCodeList = new ArrayList<>();
    private List<String> intakeSessionList = new ArrayList<>();

    private String dateregistered;

    private String matricno;
    private String studentLevel;
    private String session;
    private String session_for_studList;

    public String getVerifyAction() {
        return verifyAction;
    }

    public void setVerifyAction(String verifyAction) {
        this.verifyAction = verifyAction;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getIntakeSessionList() {
        return intakeSessionList;
    }

    public void setIntakeSessionList(List<String> intakeSessionList) {
        this.intakeSessionList = intakeSessionList;
    }

    public List<String> getCoursesCodeList() {
        return coursesCodeList;
    }

    public void setCoursesCodeList(List<String> coursesCodeList) {
        this.coursesCodeList = coursesCodeList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursecode_for_list() {
        return coursecode_for_list;
    }

    public void setCoursecode_for_list(String coursecode_for_list) {
        this.coursecode_for_list = coursecode_for_list;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

    public int getCreditunit() {
        return creditunit;
    }

    public void setCreditunit(int creditunit) {
        this.creditunit = creditunit;
    }

    public String getDateregistered() {
        return dateregistered;
    }

    public void setDateregistered(String dateregistered) {
        this.dateregistered = dateregistered;
    }

    public String getMatricno() {
        return matricno;
    }

    public void setMatricno(String matricno) {
        this.matricno = matricno;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getSession_for_studList() {
        return session_for_studList;
    }

    public void setSession_for_studList(String session_for_studList) {
        this.session_for_studList = session_for_studList;
    }

    //RETRIEVING VALUES for 'Session' FROM THE UI
    public void retriveSessionFromUI() {//get the current 'Session' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("StudentCourseRegVerificationForm:mysession");
    }//end of method

    //RETRIEVING VALUES for 'Matric no' FROM THE UI
    public void retriveMatricNoFromUI() {//get the current 'Matric no' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        matricno = ec.getRequestParameterMap().get("StudentCourseRegVerificationForm:mymatricNo");
    }//end of method

    //RETRIEVING VALUES for 'comment' FROM THE UI
    public void retriveCommentFromUI() {//get the current 'comment' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        comment = ec.getRequestParameterMap().get("StudentCourseRegVerificationForm:commentArea");
    }//end of method

    //RETRIEVING VALUES for 'Action' FROM THE UI
    public void retriveActionFromUI() {//get the current 'Action' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        verifyAction = ec.getRequestParameterMap().get("StudentCourseRegVerificationForm:actionForCourseReg");
    }//end of method

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

    public List<String> getcoursesCodeMthd() throws Exception {
        this.Connector();

        coursesCodeList.removeAll(coursesCodeList);

        try {

            ps = this.getCn().prepareStatement("SELECT course_code FROM student_course_reg WHERE session=? ");//AND course_code=?
            ps.setString(1, session);
            //  ps.setString(2, coursecode);

            rs = ps.executeQuery();

            while (rs.next()) {
                coursesCodeList.add(rs.getString("course_code"));//retrieves all the courses  and ADD into the 'coursesList'
                coursecode_for_list = rs.getString("course_code");// set the current course code on the variable

            }//end of while-block

        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Courses Retrieval Error. ", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return coursesCodeList;
    }//end of the method 

    public void resetCourseRegMthd() throws Exception {
        this.Connector();

        //editing the 'status' field to NOT-VERIFIED
        try {

            PreparedStatement st = getCn().prepareStatement("UPDATE student_course_reg  SET status= 'NOT-Verified' WHERE matricno=? AND session=? AND semester=? ");
            st.setString(1, matricno);
            st.setString(2, session);
            st.setString(3, semester);

            st.executeUpdate();
            resetCounter++;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'student's course registration with matric no; ' " + matricno + " has been RESET. Thank you.", ""));

        } catch (Exception e) {
            e.getMessage();
        }

        //INSERTING TUPPLES INTO THE 'student_course_reg_comment' table
        if (resetCounter > 0) {
            //retriveCommentFromUI();//invoked

            try {
                ps = getCn().prepareStatement("INSERT INTO student_course_reg_comment values(null,?,?,?,?,'NOT Approved', Date(Now()))");
                ps.setString(1, matricno);
                ps.setString(2, name);
                ps.setString(3, session);
                ps.setString(4, semester);
                // ps.setString(5, comment);

                ps.executeUpdate();

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Course_Reg Comment Error " + e.getMessage() + "  Pls, try ", " again"));

            } finally {
                this.Close();
            }
        }//end of the if-block

    }//end of the method

    public void verifyCourseRegMthd() throws Exception {
        this.Connector();

        //editing the 'status' field to VERIFIED
        try {

            PreparedStatement st = getCn().prepareStatement("UPDATE student_course_reg  SET status= 'Verified' WHERE matricno=? AND session=? AND semester=? ");
            st.setString(1, matricno);
            st.setString(2, session);
            st.setString(3, semester);

            st.executeUpdate();
            verifyCounter++;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'student's course registration with matric no; ' " + matricno + " has been VERIFIED. Thank you.", ""));

        } catch (Exception e) {
            e.getMessage();
        }

        //INSERTING TUPPLES INTO THE 'student_course_reg_comment' table
        if (verifyCounter > 0) {
            //retriveCommentFromUI();//invoked

            try {
                ps = getCn().prepareStatement("INSERT INTO student_course_reg_comment values(null,?,?,?,?,'Approved', Date(Now()))");
                ps.setString(1, matricno);
                ps.setString(2, name);
                ps.setString(3, session);
                ps.setString(4, semester);
                // ps.setString(5, comment);

                ps.executeUpdate();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'student's course registration with matric no; ' " + matricno + " has been AAPROVED. Thank you.", ""));

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Course_Reg Comment Error " + e.getMessage() + "  Pls, try ", " again"));

            } finally {
                this.Close();
            }
        }//end of the if-block

    }//end of the method

    public List<verify_course_registration> getListofRegisteredStudentCoursesForVerification() throws Exception {

        // retriveMatricNoFromUI();//
        this.Connector();

        List<verify_course_registration> coursereg_info = new ArrayList<verify_course_registration>();

        try {

            ps = this.getCn().prepareStatement("SELECT * FROM student_course_reg WHERE semester=? AND session=? AND matricno=? order by matricno ");//AND session=?
            ps.setString(1, semester);
            ps.setString(2, session);
            ps.setString(3, matricno);

            rs = ps.executeQuery();

            while (rs.next()) {
                verify_course_registration tbl = new verify_course_registration();

                tbl.setId(rs.getInt("id"));
                tbl.setName(rs.getString("name"));
                tbl.setMatricno(rs.getString("matricno"));
                tbl.setSession(rs.getString("session"));
                tbl.setSemester(rs.getString("semester"));

                tbl.setLevel(rs.getString("student_level"));
                tbl.setCoursecode(rs.getString("course_code"));
                tbl.setCoursetitle(rs.getString("course_title"));
                tbl.setCreditunit(rs.getInt("credit_unit"));

                tbl.setDateregistered(rs.getString("dateregistered"));
                tbl.setStatus(rs.getString("status"));

                ///
                name = rs.getString("name");//setting the student name for the the variable
                coursereg_info.add(tbl);

            }
            //name ="";

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return coursereg_info;

    }//end of the method

    public List<verify_course_registration> getStudentList() throws Exception {

        this.Connector();//establishes connection

        List<verify_course_registration> coursereg_info = new ArrayList<verify_course_registration>();

        try {

            ps = this.getCn().prepareStatement("select * from student_course_reg WHERE  session=? AND course_code=? ");//AND session=?
            ps.setString(1, session);
            ps.setString(2, coursecode);//represents the 'course code'

            rs = ps.executeQuery();

            while (rs.next()) {
                verify_course_registration tbl = new verify_course_registration();

                tbl.setId(rs.getInt("id"));
                tbl.setName(rs.getString("name"));
                tbl.setMatricno(rs.getString("matricno"));
                tbl.setSession(rs.getString("session"));
                tbl.setSemester(rs.getString("semester"));

                tbl.setLevel(rs.getString("student_level"));
                tbl.setCoursecode(rs.getString("course_code"));
                tbl.setCoursetitle(rs.getString("course_title"));
                tbl.setCreditunit(rs.getInt("credit_unit"));

                tbl.setDateregistered(rs.getString("dateregistered"));

                coursereg_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return coursereg_info;

    }//end of the method

    public List<verify_course_registration> getListOfStudentRegisteredPerACourses() throws Exception {
        retriveSessionFromUI();//

        // SPLITTING THE COURSE CODE & THE COURSE TITLE FROM THE LIST OF COURSES I.E 'ARB 122-ARABIC GRAMMAR I' is splitted into 'ARB 122' and 'ARABIC GRAMMAR I'
        String[] parts = coursetitle.split("-");
        part1 = parts[0];//course code
        part2 = parts[1];//course title
        this.Connector();

        List<verify_course_registration> list_of_student_per_course_info = new ArrayList<verify_course_registration>();

        try {

            ps = this.getCn().prepareStatement("select * from student_course_reg  ");//AND session=? //WHERE course_code=? AND session=?
            //ps.setString(1, part1.toString());//this repesents the course code
            // ps.setString(2, session);//session 

            rs = ps.executeQuery();

            while (rs.next()) {
                verify_course_registration tbl = new verify_course_registration();

                tbl.setId(rs.getInt("id"));
                tbl.setMatricno(rs.getString("matricno"));
                tbl.setSession(rs.getString("session"));
                tbl.setSemester(rs.getString("semester"));

                tbl.setLevel(rs.getString("student_level"));
                tbl.setCoursecode(rs.getString("course_code"));
                tbl.setCoursetitle(rs.getString("course_title"));
                tbl.setCreditunit(rs.getInt("credit_unit"));

                tbl.setDateregistered(rs.getString("dateregistered"));

                list_of_student_per_course_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return list_of_student_per_course_info;

    }//end of the method

    public void enableGoButton() {
        /*
        
        retriveSessionFromUI();//invoked
        retriveSemesterFromUI();//invoked

        if (matricno.equalsIgnoreCase("")) {
            System.out.println("Printing FROM enableGoButton: " + matricno);

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Error Occured! " + " The matricno no is NOT retrieved. Please, login again.",
                            "and, try!"));

        }
         */
    }//end of the method
}//end of the class

