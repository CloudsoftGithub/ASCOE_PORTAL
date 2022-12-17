package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class viewStudentregisteredCourses extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    private int id;
    private String studentname;
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
    int totatRegiteredCreditUnit;

    public int getTotatRegiteredCreditUnit() {
        return totatRegiteredCreditUnit;
    }

    public void setTotatRegiteredCreditUnit(int totatRegiteredCreditUnit) {
        this.totatRegiteredCreditUnit = totatRegiteredCreditUnit;
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

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
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

    //RETRIEVING VALUES for 'Matric no' FROM THE UI
    public void retriveMatricNoFromUI() {//get the current 'Matric no' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        matricno = ec.getRequestParameterMap().get("studentCourseRegForm:myMatricNo");
    }//end of method

    //RETRIEVING VALUES for 'Session' FROM THE UI
    public void retriveSessionFromUI() {//get the current 'Session' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("studentCourseRegForm:mysession");
    }//end of method
    
    //RETRIEVING VALUES for 'Session' FROM THE UI
    public void retriveMatricNoromUI_in_the_Exams_Card() {//get the current 'matricno' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        matricno = ec.getRequestParameterMap().get("studentExamsCardPrintingForm:myMatricNo");
    }//end of method
    
 //RETRIEVING VALUES for 'Session' FROM THE UI
    public void retriveSessionFromUI_in_the_Exams_Card() {//get the current 'Session' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("studentExamsCardPrintingForm:mysession");
    }//end of method
    
    //RETRIEVING VALUES for 'Session' FROM THE UI
    public void retriveSemesterFromUI_in_the_Exams_Card() {//get the current 'semester' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        semester = ec.getRequestParameterMap().get("studentExamsCardPrintingForm:semester");
    }//end of method
    
    //RETRIEVING VALUES for 'Semester' FROM THE UI
    public void retriveSemesterFromUI() {//get the current 'Semester' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        semester = ec.getRequestParameterMap().get("studentCourseRegForm:semester");
    }//end of method

    //RETRIEVING VALUES for 'CourseTitle' FROM THE UI
    public void retriveCourseTitleFromUI() {//get the current 'CourseTitle' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        coursetitle = ec.getRequestParameterMap().get("RegistedStudentDownloadForm:CourseTitle");
    }//end of method

    public void retriveSessionFromStudentListUI() {//get the current 'Session' on the STUDENTLIST UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("RegistedStudentDownloadForm:mysession");
    }//end of method

    public void retriveCourseCodeFromStudentListUI() {//get the current 'CourseCode' on the STUDENTLIST UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        coursecode = ec.getRequestParameterMap().get("RegistedStudentDownloadForm:CourseTitle");
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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Intake Session Error. ", e.getMessage() + " . Pls, try again"));
        } finally {
            this.Close();
        }

        return intakeSessionList;

    }//end of method

    public List<String> getcoursesCodeMthd() throws Exception {
        this.Connector();

        retriveSessionFromStudentListUI();//invoked 
        // retriveCourseCodeFromStudentListUI();//invoked

        coursesCodeList.removeAll(coursesCodeList);

        try {

            ps = this.getCn().prepareStatement("SELECT distinct(course_code) FROM student_course_reg WHERE session=? ");//AND course_code=?
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

    public List<viewStudentregisteredCourses> getStudentRegisteredCoursesFirstSemester() throws Exception {
        retriveMatricNoFromUI();//
        retriveSessionFromUI();//
        retriveSemesterFromUI();//

        this.Connector();

        List<viewStudentregisteredCourses> coursereg_info = new ArrayList<viewStudentregisteredCourses>();

        try {

            //ps = this.getCn().prepareStatement("select * from student_course_reg WHERE matricno=? AND session=?");
            ps = this.getCn().prepareStatement("select * from student_course_reg WHERE semester='FIRST SEMESTER' AND matricno=? AND session=? order by course_code ");//AND session=?
            ps.setString(1, matricno);
            ps.setString(2, session);

            System.err.println("Testing myMatric no today:" + matricno);
            System.err.println("Testing session no today:" + session);
            System.err.println("Testing semester no today:" + semester);

            rs = ps.executeQuery();

            while (rs.next()) {
                viewStudentregisteredCourses tbl = new viewStudentregisteredCourses();

                tbl.setId(rs.getInt("id"));
                tbl.setMatricno(rs.getString("matricno"));
                tbl.setSession(rs.getString("session"));
                tbl.setSemester(rs.getString("semester"));

                tbl.setLevel(rs.getString("student_level"));
                tbl.setCoursecode(rs.getString("course_code"));
                tbl.setCoursetitle(rs.getString("course_title"));
                tbl.setCreditunit(rs.getInt("credit_unit"));

                tbl.setDateregistered(rs.getString("dateregistered"));
                totatRegiteredCreditUnit += rs.getInt("credit_unit");//Computes the total credits units registered
                tbl.setTotatRegiteredCreditUnit(totatRegiteredCreditUnit);

                coursereg_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return coursereg_info;

    }//end of the method

    public List<viewStudentregisteredCourses> getStudentRegisteredCoursesSecondSemester() throws Exception {
        retriveMatricNoFromUI();
        retriveSessionFromUI();//
        retriveSemesterFromUI();//

        this.Connector();

        List<viewStudentregisteredCourses> coursereg_info = new ArrayList<viewStudentregisteredCourses>();

        try {

            //ps = this.getCn().prepareStatement("select * from student_course_reg WHERE matricno=? AND session=?");
            ps = this.getCn().prepareStatement("select * from student_course_reg WHERE semester='SECOND SEMESTER' AND matricno=? AND session=? ");//AND session=?
            ps.setString(1, matricno);
            ps.setString(2, session);

            System.err.println("Testing myMatric no today:" + matricno);
            System.err.println("Testing session no today:" + session);
            System.err.println("Testing semester no today:" + semester);

            rs = ps.executeQuery();

            while (rs.next()) {
                viewStudentregisteredCourses tbl = new viewStudentregisteredCourses();

                tbl.setId(rs.getInt("id"));
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

    public List<viewStudentregisteredCourses> getStudentExamsCard() throws Exception {
      
        
        retriveMatricNoromUI_in_the_Exams_Card();//invoked
        retriveSessionFromUI_in_the_Exams_Card();//invoked 
        retriveSemesterFromUI_in_the_Exams_Card();//invoked 
 
        this.Connector();

        List<viewStudentregisteredCourses> coursereg_info = new ArrayList<viewStudentregisteredCourses>();

        try {
            ps = this.getCn().prepareStatement("select * from student_course_reg WHERE semester=? AND matricno=? AND session=? order by course_code ");//AND session=? 
            ps.setString(1, semester);
            ps.setString(2, matricno);
            ps.setString(3, session);

            System.err.println("Testing myMatric no today:" + matricno);
            System.err.println("Testing session no today:" + session);
            System.err.println("Testing semester no today:" + semester);

            rs = ps.executeQuery();

            while (rs.next()) {
                viewStudentregisteredCourses tbl = new viewStudentregisteredCourses();

                tbl.setId(rs.getInt("id"));
                tbl.setMatricno(rs.getString("matricno"));
                tbl.setSession(rs.getString("session"));
                tbl.setSemester(rs.getString("semester"));

                tbl.setLevel(rs.getString("student_level"));
                tbl.setCoursecode(rs.getString("course_code"));
                tbl.setCoursetitle(rs.getString("course_title"));
                tbl.setCreditunit(rs.getInt("credit_unit"));

                tbl.setDateregistered(rs.getString("dateregistered"));
                totatRegiteredCreditUnit += rs.getInt("credit_unit");//Computes the total credits units registered
                tbl.setTotatRegiteredCreditUnit(totatRegiteredCreditUnit);

                coursereg_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return coursereg_info;

    }//end of the method
    
    public void goViewExamsCardMthd() throws Exception{
        getStudentExamsCard();
    }//end of the method 

    public void sumUpRegisteredCreditUnitInAaSemester(String matrinno, String session, String semester) throws Exception {

        try {
            ps = this.getCn().prepareStatement(" SELECT sum(credit_unit) FROM student_course_reg  WHERE matricno=? AND session=? AND semester=?  ");
            ps.setString(1, matricno);
            ps.setString(2, session);
            ps.setString(3, semester);

            rs = ps.executeQuery();

            while (rs.next()) {

                totatRegiteredCreditUnit = rs.getInt(1);
            }
        } catch (Exception e) {
        } finally {
            this.Close();
        }

    }//end of the method

    public List<viewStudentregisteredCourses> getStudentList() throws Exception {
        //retriveCourseTitleFromUI();//invoked
        retriveSessionFromStudentListUI();
        retriveCourseCodeFromStudentListUI();//invoked

        this.Connector();//establishes connection

        List<viewStudentregisteredCourses> coursereg_info = new ArrayList<viewStudentregisteredCourses>();

        try {

            ps = this.getCn().prepareStatement("select * from student_course_reg WHERE  session=? AND course_code=? ");//AND session=?
            ps.setString(1, session);
            ps.setString(2, coursecode);//represents the 'course code'

            rs = ps.executeQuery();

            while (rs.next()) {
                viewStudentregisteredCourses tbl = new viewStudentregisteredCourses();

                tbl.setId(rs.getInt("id"));
                tbl.setStudentname(rs.getString("name"));
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

    public List<viewStudentregisteredCourses> getListOfStudentRegisteredPerACourses() throws Exception {
        retriveSessionFromUI();//

        // SPLITTING THE COURSE CODE & THE COURSE TITLE FROM THE LIST OF COURSES I.E 'ARB 122-ARABIC GRAMMAR I' is splitted into 'ARB 122' and 'ARABIC GRAMMAR I'
        String[] parts = coursetitle.split("-");
        part1 = parts[0];//course code
        part2 = parts[1];//course title
        this.Connector();

        List<viewStudentregisteredCourses> list_of_student_per_course_info = new ArrayList<viewStudentregisteredCourses>();

        try {

            ps = this.getCn().prepareStatement("select * from student_course_reg  ");//AND session=? //WHERE course_code=? AND session=?
            //ps.setString(1, part1.toString());//this repesents the course code
            // ps.setString(2, session);//session 

            rs = ps.executeQuery();

            while (rs.next()) {
                viewStudentregisteredCourses tbl = new viewStudentregisteredCourses();

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
        retriveMatricNoFromUI();//invoked
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
    }//end of the method
}//end of the class

