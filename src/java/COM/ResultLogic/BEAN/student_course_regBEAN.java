package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class student_course_regBEAN extends DAO {

    private Calendar calendar;
    // String myStudentLevel;

    int maxSpecified_Credit_unit;
    int Summed_registered_credit_unit;

    String part1;
    String part2;
    String mySemester;
    String semesterDetector;

    int rowCount = 0;
    PreparedStatement ps;
    ResultSet rs;

    private String coursetitle;
    private List<String> intakeSessionList = new ArrayList<>();

    private String semester;
    private String studentLevel;
    private String courseTitle;
    private String coursecode;
    private int creditUnit;

    private String fullname;
    private String maricno;
    private String session;

    private List<String> coursesList = new ArrayList<>();
    private List<String> coursesCodeList = new ArrayList<>();

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

    public List<String> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<String> coursesList) {
        this.coursesList = coursesList;
    }

    public List<String> getCoursesCodeList() {
        return coursesCodeList;
    }

    public void setCoursesCodeList(List<String> coursesCodeList) {
        this.coursesCodeList = coursesCodeList;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMaricno() {
        return maricno;
    }

    public void setMaricno(String maricno) {
        this.maricno = maricno;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getCreditUnit() {
        return creditUnit;
    }

    public void setCreditUnit(int creditUnit) {
        this.creditUnit = creditUnit;
    }

    public List<String> getIntakeSessionList() {
        return intakeSessionList;
    }

    public void setIntakeSessionList(List<String> intakeSessionList) {
        this.intakeSessionList = intakeSessionList;
    }
    //RETRIEVING VALUES for 'Session' FROM THE UI

    public void retriveSessionFromUI() {//get the current 'Session' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("studentCourseRegForm:mysession");
    }//end of method

    public void retriveSessionFromStudentListUI() {//get the current 'Session' on the STUDENTLIST UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("RegistedStudentDownloadForm:mysession");
    }//end of method

    //RETRIEVING VALUES for 'Fullname' FROM THE UI
    public void retriveFullNameFromUI() {//get the current 'Fullname' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        fullname = ec.getRequestParameterMap().get("studentCourseRegForm:myFullname");
    }//end of method

    //RETRIEVING VALUES for 'Matric no' FROM THE UI
    public void retriveMatricNoFromUI() {//get the current 'Matric no' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        maricno = ec.getRequestParameterMap().get("studentCourseRegForm:myMatricNo");
    }//end of method

    //RETRIEVING VALUES for 'Student Level' FROM THE UI
    public void retriveStudentLevelFromUI() {//get the current 'Student Level' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        studentLevel = ec.getRequestParameterMap().get("studentCourseRegForm:myLevel");
    }//end of method

    public List<String> getcoursesMthd() throws Exception {
        this.Connector();

        coursesList.removeAll(coursesList);
        //coursesList.remove(coursesList);

        try {

            ps = this.getCn().prepareStatement("SELECT course_code , course_title,credit_unit FROM course_reg");
            rs = ps.executeQuery();

            while (rs.next()) {
                coursesList.add(rs.getString("course_code") + "-" + rs.getString("course_title"));//retrieves all the courses  and ADD into the 'coursesList'
                coursecode = rs.getString("course_code");// set the current course code on the variable
                courseTitle = rs.getString("course_title");// set the current course code on the variable
                creditUnit = rs.getInt("credit_unit");// set the current course code on the varible
            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Courses Retrieval Error", e.getMessage() + " . Pls, try again"));
        } finally {
            this.Close();
        }

        return coursesList;
    }//end of the method 

    public List<String> getcoursesCodeMthd() throws Exception {
        this.Connector();

        retriveSessionFromStudentListUI();//invoked 

        coursesCodeList.removeAll(coursesCodeList);

        try {

            ps = this.getCn().prepareStatement("SELECT course_code FROM student_course_reg ");
            //ps.setString(1, session);
            rs = ps.executeQuery();

            while (rs.next()) {
                coursesCodeList.add(rs.getString("course_code"));//retrieves all the courses  and ADD into the 'coursesList'
                coursecode = rs.getString("course_code");// set the current course code on the variable

            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Courses Retrieval Error", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return coursesCodeList;
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

    public void studentsCourseRegMethod() throws Exception {

        retriveFullNameFromUI();//invoked  
        retriveMatricNoFromUI();//invoked 
        retriveStudentLevelFromUI();//invoked 

        this.Connector();

        // SPLITTING THE COURSE CODE & THE COURSE TITLE FROM THE LIST OF COURSES I.E 'ARB 122-ARABIC GRAMMAR I' is splitted into 'ARB 122' and 'ARABIC GRAMMAR I'
        String[] parts = courseTitle.split("-");
        part1 = parts[0];//course code
        part2 = parts[1];//course title

        //Splitting ONLY the courseCode into 2 
        String[] partss = part1.split(" ");

        String partssA = partss[0];// e.g. "ARB" from "ARB 124"
        String partssB = partss[1];// e.g. "124" from "ARB 124"

        semesterDetector = partssB.substring(1, 2);//Picks the middle digit in the course code i.e (for "ARB 124" it pics 2)

        //Check if appropriate semester is selected, before registering the course
        PreparedStatement ps1 = getCn().prepareStatement("SELECT semester FROM student_course_reg WHERE course_code=? AND session=? AND matricno=? ");
        ps1.setString(1, part1);//course code
        ps1.setString(2, session);
        ps1.setString(3, maricno);

        ResultSet rs1 = ps1.executeQuery();

        //Check for the SPECIFIED max. credit units to be regested  in a semester
        PreparedStatement ps2 = getCn().prepareStatement("SELECT max_credit_unit FROM credit_unit_reg WHERE semester=? AND session=?  ");
        ps2.setString(1, semester);//course code
        ps2.setString(2, session);

        ResultSet rs2 = ps2.executeQuery();
        while (rs2.next()) {
            maxSpecified_Credit_unit = rs2.getInt(1);//the total specified credit unit for a particular semester
            System.out.println(" Testing the maxSpecified_Credit_unit: " + maxSpecified_Credit_unit);

        }

        //Check for the AGGREGATE credit units that has been registred  in a semester
        PreparedStatement ps3 = getCn().prepareStatement("SELECT sum(credit_unit) FROM student_course_reg WHERE semester=? AND session=? AND matricno=? ");
        ps3.setString(1, semester);//course code
        ps3.setString(2, session);
        ps3.setString(3, maricno);

        ResultSet rs3 = ps3.executeQuery();
        while (rs3.next()) {
            Summed_registered_credit_unit = rs3.getInt(1);
            System.out.println(" Testing the Summed_registered_credit_unit: " + Summed_registered_credit_unit);
        }

        //Step1: Check for duplicated course registration
        PreparedStatement psCheck = getCn().prepareStatement("SELECT * FROM student_course_reg WHERE course_code=? AND session=? AND matricno=? ");
        psCheck.setString(1, part1);//course code
        psCheck.setString(2, session);
        psCheck.setString(3, maricno);
        ResultSet rsCheck = psCheck.executeQuery();

        //Check for wether  course registration HAS BEEN VERIFIED
        PreparedStatement psVerified = getCn().prepareStatement("SELECT * FROM student_course_reg WHERE semester=? AND session=? AND matricno=? AND status='Verified' ");
        psVerified.setString(1, semester);//course code
        psVerified.setString(2, session);
        psVerified.setString(3, maricno);
        ResultSet rsVerify = psVerified.executeQuery();

        if (rsCheck.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "This 'Course: ' " + part1 + " - " + part2 + " already added in the session: " + session + ". Pls, select a different course!", ""));

        } else if (maricno.equalsIgnoreCase("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Matric number is blank. Pls, login again  and register courses.", ""));
        } else if ((Summed_registered_credit_unit + creditUnit) > maxSpecified_Credit_unit) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sorry, You can't register more than the SPECIFIED credit unit(s), which is: " + maxSpecified_Credit_unit + " . Contact your level coordinator, Pls.", ""));
        } else if (Integer.parseInt(semesterDetector) % 2 != 0 && semester.equalsIgnoreCase("SECOND SEMESTER")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sorry, YOU CANNOT register  " + part1 + " into SECOND SEMESTER.", "It is a FIRST SEMESTER COURSE!"));
        } else if (Integer.parseInt(semesterDetector) % 2 == 0 && semester.equalsIgnoreCase("FIRST SEMESTER")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sorry, YOU CANNOT register  " + part1 + " into FIRST SEMESTER.", "It is a SECOND SEMESTER COURSE!"));
        } else if (rsVerify.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sorry, YOU CANNOT edit  " + " what has been VERIFIED.", " Please, report to your coordinator. "));
        } else {//Step2: Inserting the tuples into the table

            try {//Step: register the course 
                PreparedStatement ps = getCn().prepareStatement("INSERT INTO student_course_reg VALUES(?,?,?,?,?,?,?,?,?, now(), 'NOT Verified' )");

                ps.setString(1, null);
                ps.setString(2, maricno);
                ps.setString(3, fullname);
                ps.setString(4, studentLevel);
                ps.setString(5, session);
                ps.setString(6, semester);
                ps.setString(7, part1);//course code 
                ps.setString(8, part2);//course title
                ps.setInt(9, creditUnit);

                rowCount = ps.executeUpdate();

                ///////////////////////////////
                if (rowCount > 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Course; ' " + part1 + " - " + part2 + " has been ADDED. Thank you.", ""));

                }//end of the if-block

                //Clearing variables after insertion is done
                courseTitle = "";
                coursecode = "";
                Summed_registered_credit_unit = 0;
                maxSpecified_Credit_unit = 0;

            } catch (Exception e) {
                throw e;
            } finally {
                this.Close(); // this is been commented in order allow the below query to get executed
            }

        }//end of the else-block 
    }//end of the method

    public void deleteCourseMthd() throws Exception {

        try {
            retriveFullNameFromUI();//invoked 
            retriveMatricNoFromUI();//invoked 
            retriveStudentLevelFromUI();//invoked 

            this.Connector();

            // SPLITTING THE COURSE CODE & THE COURSE TITLE FROM THE LIST OF COURSES I.E 'ARB 122-ARABIC GRAMMAR I' is splitted into 'ARB 122' and 'ARABIC GRAMMAR I'
            String[] parts = courseTitle.split("-");
            part1 = parts[0];//course code
            part2 = parts[1];//course title

            // Delete a registered course 
            PreparedStatement ps = getCn().prepareStatement("DELETE FROM student_course_reg WHERE course_code=? AND session=? AND matricno=? ");
            ps.setString(1, part1);//course code
            ps.setString(2, session);
            ps.setString(3, maricno);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Course; ' " + part1 + " - " + part2 + " has been DELETED. Thank you.", ""));
            } else {
                //Do nothing
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Close(); // this is been commented in order allow the below query to get executed
        }

    }//end of the method

    public void viewRegisteredCoursesMethod() throws Exception {

        retriveFullNameFromUI();//invoked 
        retriveMatricNoFromUI();//invoked 
        retriveStudentLevelFromUI();//invoked 

        this.Connector();

    }
}//end of the class 
