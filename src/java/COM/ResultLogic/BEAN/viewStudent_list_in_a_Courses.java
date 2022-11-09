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
public class viewStudent_list_in_a_Courses extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    private int id;
    private String semester;
    private String level;
    private String coursecode;
    private String coursetitle;
    private int creditunit;
    String part1;
    String part2;
    
    private String dateregistered;

    private String matricno;
    private String studentLevel;
    private String session;

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

    //RETRIEVING VALUES for 'Semester' FROM THE UI
    public void retriveSemesterFromUI() {//get the current 'Semester' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        semester = ec.getRequestParameterMap().get("studentCourseRegForm:semester");
    }//end of method

        //RETRIEVING VALUES for 'CourseTitle' FROM THE UI
    public void retriveCourseTitleFromUI() {//get the current 'Semester' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        coursetitle = ec.getRequestParameterMap().get("studentCourseRegForm:CourseTitle");
    }//end of method
    
    public List<viewStudent_list_in_a_Courses> getStudentRegisteredCoursesFirstSemester() throws Exception {
        retriveMatricNoFromUI();//
        retriveSessionFromUI();//
        retriveSemesterFromUI();//
        
        this.Connector();

        List<viewStudent_list_in_a_Courses> coursereg_info = new ArrayList<viewStudent_list_in_a_Courses>();

        try {

            //ps = this.getCn().prepareStatement("select * from student_course_reg WHERE matricno=? AND session=?");
            ps = this.getCn().prepareStatement("select * from student_course_reg WHERE semester='FIRST SEMESTER' AND matricno=? AND session=? ");//AND session=?
            ps.setString(1, matricno);
            ps.setString(2, session);

            System.err.println("Testing myMatric no today:" + matricno);
            System.err.println("Testing session no today:" + session);
            System.err.println("Testing semester no today:" + semester);

            rs = ps.executeQuery();

            while (rs.next()) {
                viewStudent_list_in_a_Courses tbl = new viewStudent_list_in_a_Courses();

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

          public List<viewStudent_list_in_a_Courses> getListOfStudentRegisteredPerACourses() throws Exception {
         retriveSessionFromUI();//
         retriveCourseTitleFromUI();//
                
          // SPLITTING THE COURSE CODE & THE COURSE TITLE FROM THE LIST OF COURSES I.E 'ARB 122-ARABIC GRAMMAR I' is splitted into 'ARB 122' and 'ARABIC GRAMMAR I'
        String[] parts = coursetitle.split("-");
        part1 = parts[0];//course code
        part2 = parts[1];//course title
         this.Connector();

        List<viewStudent_list_in_a_Courses> list_of_student_per_course_info = new ArrayList<viewStudent_list_in_a_Courses>();

        try {

            ps = this.getCn().prepareStatement("select * from student_course_reg WHERE course_code=? AND session=? ");//AND session=?
            ps.setString(1, part1);//this repesents the course code
            ps.setString(2, session);//session 
 
            rs = ps.executeQuery();

            while (rs.next()) {
                viewStudent_list_in_a_Courses tbl = new viewStudent_list_in_a_Courses();

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

    public List<viewStudent_list_in_a_Courses> getStudentRegisteredCoursesSecondSemester() throws Exception {
        retriveMatricNoFromUI();
        retriveSessionFromUI();//
        retriveSemesterFromUI();//

        this.Connector();

        List<viewStudent_list_in_a_Courses> coursereg_info = new ArrayList<viewStudent_list_in_a_Courses>();

        try {

            //ps = this.getCn().prepareStatement("select * from student_course_reg WHERE matricno=? AND session=?");
            ps = this.getCn().prepareStatement("select * from student_course_reg WHERE semester='SECOND SEMESTER' AND matricno=? AND session=? ");//
            ps.setString(1, matricno);
            ps.setString(2, session);

            System.err.println("Testing myMatric no today:" + matricno);
            System.err.println("Testing session no today:" + session);
            System.err.println("Testing semester no today:" + semester);

            rs = ps.executeQuery();

            while (rs.next()) {
                viewStudent_list_in_a_Courses tbl = new viewStudent_list_in_a_Courses();

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

