package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class DataEntryBEAN extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    String dataEntryTableName = "";
    boolean editable;
    private int id;
    private String studentname;
    private String semester;
    private String level;
    private String coursecode;
    private String coursecode_for_list;
    private String coursetitle;
    private int creditunit;
    int totalCounter = 0;
    double total;
    private String gradeLetter;
    private double gradePoint;
    private String remarks;
    private double gpa;
    private double cgpa;
    private double totalPoint;

    String sessionpart1;
    String sessionpart2;

    String cosecodePart1;
    String cosecodePart2;

    String part1;
    String part2;
    private List<String> coursesCodeList = new ArrayList<>();
    private List<String> intakeSessionList = new ArrayList<>();

    private String dateregistered;

    private String matricno;
    private String studentLevel;
    private String session;
    private String session_for_studList;

    private int TheCounter = 0;
    private String TheRetrievedName;
    private String TheRetrievedMatricNo;

    public double getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(double totalPoint) {
        this.totalPoint = totalPoint;
    }

    public int getTheCounter() {
        return TheCounter;
    }

    public void setTheCounter(int TheCounter) {
        this.TheCounter = TheCounter;
    }

    public String getTheRetrievedName() {
        return TheRetrievedName;
    }

    public void setTheRetrievedName(String TheRetrievedName) {
        this.TheRetrievedName = TheRetrievedName;
    }

    public String getTheRetrievedMatricNo() {
        return TheRetrievedMatricNo;
    }

    public void setTheRetrievedMatricNo(String TheRetrievedMatricNo) {
        this.TheRetrievedMatricNo = TheRetrievedMatricNo;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(double gradePoint) {
        this.gradePoint = gradePoint;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getGradeLetter() {
        return gradeLetter;
    }

    public void setGradeLetter(String gradeLetter) {
        this.gradeLetter = gradeLetter;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Intake Session Error", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return intakeSessionList;

    }//end of method

    public List<String> getcoursesCodeMthd() throws Exception {

        retriveSessionFromStudentListUI();//invoked 
        // retriveCourseCodeFromStudentListUI();//invoked

        coursesCodeList.removeAll(coursesCodeList);
        this.Connector();

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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Courses Retrieval Error", e.getMessage() + " . Pls, try again"));
        } finally {
            this.Close();
        }

        return coursesCodeList;
    }//end of the method 

    public List<DataEntryBEAN> getStudentRegisteredCoursesFirstSemester() throws Exception {
        retriveMatricNoFromUI();//
        retriveSessionFromUI();//
        retriveSemesterFromUI();//

        this.Connector();

        List<DataEntryBEAN> coursereg_info = new ArrayList<DataEntryBEAN>();

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
                DataEntryBEAN tbl = new DataEntryBEAN();

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

    public List<DataEntryBEAN> getStudentRegisteredCoursesSecondSemester() throws Exception {
        retriveMatricNoFromUI();
        retriveSessionFromUI();//
        retriveSemesterFromUI();//

        this.Connector();

        List<DataEntryBEAN> coursereg_info = new ArrayList<DataEntryBEAN>();

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
                DataEntryBEAN tbl = new DataEntryBEAN();

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

    public List<DataEntryBEAN> getStudentList() throws Exception {
        this.Connector();//establishes connection.

        retriveSessionFromStudentListUI();
        retriveCourseCodeFromStudentListUI();//invoked

        //STEP1: DOWNLOADING THE REGISTERED COURSE FROM THE 'student_course_reg' INTO THE 'result_data_entry' FOR DATA ENTRY*
        //insertTuplesFromCourseRegIntoDataEntrysheetTable();//INVOKED 
        List<DataEntryBEAN> coursereg_info = new ArrayList<DataEntryBEAN>();

        //STEP3: DISPLAYING THE CONTENT OF THE 'result_data_entry' ON THE DATATABLE
        try {

            ps = this.getCn().prepareStatement("SELECT * FROM  result_data_entry WHERE  session=? AND course_code=? order by matricno ASC ");
            ps.setString(1, session);
            ps.setString(2, coursecode);//represents the 'course code'

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DataEntryBEAN tbl = new DataEntryBEAN();

                tbl.setId(rs.getInt("id"));
                tbl.setStudentname(rs.getString("name"));
                tbl.setMatricno(rs.getString("matricno"));
                tbl.setSession(rs.getString("session"));
                tbl.setSemester(rs.getString("semester"));

                tbl.setCoursecode(rs.getString("course_code"));
                // tbl.setCoursetitle(rs.getString("course_title"));
                tbl.setCreditunit(rs.getInt("credit_unit"));
                tbl.setTotal(rs.getDouble("total_score"));
                tbl.setGradeLetter(rs.getString("grade_letter"));
                tbl.setGradePoint(rs.getDouble("grade_point"));
                tbl.setTotalPoint(rs.getDouble("total_point"));
                //tbl.setDateregistered(rs.getString("dateregistered"));
                coursereg_info.add(tbl);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return coursereg_info;

    }//end of the method

    public void previousButtonMthd() {
        TheCounter--;

    }//end of the method 

    public void getnameAndMatricNoForTheRegisteredStudForACourseMthd() throws Exception {
        //clearing variables
        total = 0;//reset the counter to zero
        TheRetrievedName = "";//reset to empty String 
        TheRetrievedMatricNo = "";//reset to empty String 

        this.Connector();//establishes connection.
        TheCounter++;
 
        retriveSessionFromStudentListUI();
        retriveCourseCodeFromStudentListUI();//invoked

        //STEP2: DISPLAYING THE CONTENT OF THE 'result_data_entry' ON THE Name and matric No. textFields
        try {

            ps = this.getCn().prepareStatement("SELECT * FROM  " + dataEntryTableName + " WHERE  session=? AND course_code=? AND id=? order by matricno DESC ");
            ps.setString(1, session);
            ps.setString(2, coursecode);//represents the 'course code'
            ps.setInt(3, TheCounter);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                TheRetrievedName = name;

                String matricNo = rs.getString("matricno");
                TheRetrievedMatricNo = matricNo;
                String subMtric = TheRetrievedMatricNo.substring(11);// 
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error in Result-Sheet-Data-Entry " + " Pls, Click on the 'VIEW LIST BUTTON' first after supplying the 'SESSION' and 'COURSE CODE'. And then proceed to Next of previous Button. ", ""));
        } finally {
            this.Close();
        }

    }//end of the method

    public void insertTuplesFromCourseRegIntoDataEntrysheetTable() throws Exception {

        this.Connector();//establishes connection.
        TheCounter = 0;//reset the counter to zero
        TheRetrievedName = "";//reset to empty String 
        TheRetrievedMatricNo = "";//reset to empty String 

        retriveSessionFromStudentListUI();
        retriveCourseCodeFromStudentListUI();//invoked

        //NOTE: This method is to be invoked within the 'getStudentList' method 
        int count = 0;
        //STEP0: CHECK IF THE CURRENT SESSION AND COURSE CODE ARE FOUND IN THE TABLE 'result_data_entry' TABLE. IF FOUND DO NOTHING 
        /*
         try {
            ps = this.getCn().prepareStatement(" SELECT * FROM result_data_entry WHERE course_code=?  AND session=?  ");
            ps.setString(1, coursecode);
            ps.setString(2, session);//represents the 'course code'
            rs = ps.executeQuery();

           // if (rs.next()) {//IF FOUND ... do UPDATE THE EXISTING RECORD

                // do nothing 
           // } else {

                //STEP1: DOWNLOADING THE REGISTERED COURSES FROM THE 'student_course_reg' INTO THE 'result_data_entry' FOR DATA ENTRY*
                //A:
               

            //}//end of else-block
        } catch (SQLException e) {
            throw e;
        }
         */

        try { //INSERT INTO result_data_entry (id, matricno, name, session, semester, course_code,credit_unit, total_score, grade_letter, grade_point, total_point, date ) SELECT null, matricno, name, session, semester, course_code,credit_unit,null,null,null,null,null FROM student_course_reg WHERE session='2022/2023' AND course_code='EDU 111' AND matricno NOT IN ( SELECT matricno FROM result_data_entry WHERE session='2022/2023' AND course_code='EDU 111'
            // ps = this.getCn().prepareStatement(" INSERT INTO result_data_entry (id, matricno, name, session, semester, course_code,credit_unit, total_score, grade_letter, grade_point, total_point, date ) SELECT null, matricno, name, session, semester, course_code,credit_unit,null,null,null,null,null FROM student_course_reg WHERE  session=? AND course_code=? order by matricno DESC ");
            ps = this.getCn().prepareStatement(" INSERT INTO result_data_entry (id, matricno, name,student_level, session, semester, course_code,credit_unit, total_score, grade_letter, grade_point, total_point, date ) SELECT null, matricno, name, student_level,session, semester, course_code,credit_unit,null,null,null,null,null FROM student_course_reg WHERE session=? AND course_code=? AND matricno NOT IN ( SELECT matricno FROM result_data_entry WHERE session=? AND course_code=?) ");

            System.err.println("Bismillah, Im in the Method!");
             ps.setString(1, session);
            ps.setString(2, coursecode);//represents the 'course code'
            ps.setString(3, session);
            ps.setString(4, coursecode);//represents the 'course code'

            count = ps.executeUpdate();

        } catch (Exception e) {
            e.getMessage();
        } finally {
            //this.Close();
        }
         
        
        //STEP2: 
        //B: CREATING A HELPER TABLE with name of the course and the session 
        createHelperTablePerCourseAndSession();

    }//end of the method

    public void createHelperTablePerCourseAndSession() throws Exception {

        this.Connector();

        retriveSessionFromStudentListUI();//invoked
        retriveCourseCodeFromStudentListUI();//invoked

        //A: CREATING A HELPER TABLE with name of the course and the session 
        // SPLITTING THE COURSE CODE I.E 'ARB 122' is splitted into 'ARB' and '122'
        String[] cusecodeParts = coursecode.split("\\s+");
        cosecodePart1 = cusecodeParts[0];//course code
        cosecodePart2 = cusecodeParts[1];//course title

        // SPLITTING THE SESSION I.E '2020/2021' is splitted into '2020' and '2021'
        String[] sessionparts = session.split("/");
        sessionpart1 = sessionparts[0];//course code
        sessionpart2 = sessionparts[1];//course title

        dataEntryTableName = "result_data_entry" + "_" + cosecodePart1 + "_" + cosecodePart2 + "_" + sessionpart1 + "_" + sessionpart2;

        try {
            ps = this.getCn().prepareStatement(" CREATE  TABLE IF NOT EXISTS " + dataEntryTableName + " LIKE result_data_entry ");
            ps.executeUpdate();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" + " Error: " + e.getMessage(), ""));
        } finally {
            //this.Close();
        }

        //B: COPYING THE students who have offered a couse in a given session FROM THE DATA ENTRY TABLE 
        //INTO THE CREATED TABLE
        /*
                try {

            // ps = this.getCn().prepareStatement(" INSERT INTO " + dataEntryTableName + " (id, matricno, name, session, semester, course_code,credit_unit, total_score, grade_letter, grade_point, total_point, date ) SELECT null, matricno, name, session, semester, course_code,credit_unit,null,null,null,null,null FROM result_data_entry WHERE  session=? AND course_code=? order by matricno ASC ");
            //ps.setString(1, session);
            //ps.setString(2, coursecode);//represents the 'course code'
            //ps.executeUpdate();
            ps = this.getCn().prepareStatement(" SELECT * FROM " + dataEntryTableName + " WHERE  session=? AND course_code=? ");
            //ps = this.getCn().prepareStatement(" SELECT * FROM " + dataEntryTableName + " AS r INNER JOIN result_data_entry AS d ON  r.matricno=d.matricno AND d.session=r.session AND d.course_code=r.course_code AND d.semester=r.semester WHERE  r.matricno=d.matricno AND d.session=? AND d.course_code=? ");

            ps.setString(1, session);
            ps.setString(2, coursecode);//represents the 'course code'
            // ps.setString(3, matricno);
            // ps.setString(4, semester);

            rs = ps.executeQuery();

            if (rs.next()) {//CHECKS OF THE ROWS HAVE BEEN ADDED
                //do nothing 

            } else {//IF NOT FOUND, INSERT INTO THE TABLE

                ps = this.getCn().prepareStatement(" INSERT INTO " + dataEntryTableName + " (id, matricno, name, session, semester, course_code,credit_unit, total_score, grade_letter, grade_point, total_point, date ) SELECT id, matricno, name, session, semester, course_code,credit_unit,null,null,null,null,null FROM result_data_entry WHERE  session=? AND course_code=? order by matricno ASC ");
                ps.setString(1, session);
                ps.setString(2, coursecode);//represents the 'course code'
                ps.executeUpdate();
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error In copying students who offered course" + " Error " + e.getMessage(), ""));
        } finally {
            //this.Close();
        }

         */
        //B1;//TRUNCATING THE created temporary table each time the 'view list ' is clicked (so that new rows are inserted without duplicates)
        try {

            ps = this.getCn().prepareStatement(" TRUNCATE " + dataEntryTableName);
            ps.executeUpdate();

        } catch (Exception e) {
            e.getMessage();
        } finally {
            //do nothing
        }

        ///B2; INSERTING THE TUPLES INTO THE FRESH temporary table whole COPYING FROM THE 'result_data_entry' table 
        try {
            ps = this.getCn().prepareStatement(" INSERT INTO " + dataEntryTableName + " (id, matricno, name, student_level,session, semester, course_code,credit_unit, total_score, grade_letter, grade_point, total_point, date ) SELECT null, matricno, name,student_level,session, semester, course_code,credit_unit,null,null,null,null,null FROM result_data_entry WHERE  session=? AND course_code=? order by matricno ASC ON DUPLICATE KEY UPDATE total_score=VALUES(total_score),grade_letter=VALUES(grade_letter), grade_point=VALUES(grade_point), total_point=VALUES(total_point) ");
            ps.setString(1, session);
            ps.setString(2, coursecode);//represents the 'course code'
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }

        //C: DROP THE CREATED TABLE 'dataEntryTableName' AFTER AN HOUR
        try {
            //SETTING THE EVENT SHEDULER ON
            ps = this.getCn().prepareStatement(" SET @@global.event_scheduler = 1 ");

            ps = this.getCn().prepareStatement(" CREATE EVENT dropTableEvent ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL 15 MINUTE DO DROP TABLE IF EXISTS dataEntryTableName  ");
            ps.executeUpdate();

        } catch (Exception e) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error " + " Error " + e.getMessage(), ""));
        } finally {
            this.Close();
        }
    }//end of the class 

    public void updateRowsMthd() throws Exception {
        this.Connector();//establishes connectdion from the DAO Class (i.e the super class)

        //STEP1: COLLECT THE student 'total score' and update the 'result_data_entry' table
        try {
            ps = this.getCn().prepareStatement(" UPDATE result_data_entry SET total_score=?, date = now() WHERE matricno =? AND session=? AND course_code=? ");//WHERE matricno =? AND session=? AND course_code=?
            ps.setDouble(1, total);
            ps.setString(2, TheRetrievedMatricNo);
            ps.setString(3, session);//set the local variable 'CourseCode' from the command link parameter
            ps.setString(4, coursecode);//set the local variable 'CourseCode' from the command link parameter

            totalCounter = ps.executeUpdate();
            if (totalCounter > 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Record ' for " + matricno + " has been UPDATED with: " + total, " "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The 'Record ' for " + matricno + " NOT UPDATED ", ""));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The 'Record ' for " + matricno + " NOT UPDATED " + e.getMessage(), ""));
            throw e;

        } finally {
            // this.Close();
            //ps.close();
        }//end of finally-block

        //STEP2: UPDATING THE 'GRADE LETTER', 'GRADE POINT' AND 'TOTAL POIN' COLUMNS AND THE 'GRADE POINT' COLUMN ON THE TABLE
        try {
            ps = this.getCn().prepareStatement(" UPDATE result_data_entry  SET	 grade_letter =  CASE 	WHEN (total_score >=70) THEN 'A'  WHEN (total_score >=60) THEN 'B'    WHEN (total_score >=50) THEN 'C'  WHEN (total_score >=45) THEN 'D'   WHEN (total_score >=40) THEN 'E' ELSE  'F' END ,grade_point  = CASE 	WHEN (total_score >=70) THEN '5' WHEN (total_score >=60) THEN '4' WHEN (total_score >=50) THEN '3'  WHEN (total_score >=45) THEN '2'   WHEN (total_score >=40) THEN '1'   ELSE  '0' END   ,total_point = grade_point * credit_unit WHERE session=? AND course_code=? ");//WHERE matricno =? AND session=? AND course_code=?
            ps.setString(1, session);//set the local variable 'CourseCode' from the command link parameter
            ps.setString(2, coursecode);//set the local variable 'CourseCode' from the command link parameter

            ps.executeUpdate();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" + matricno + " Error: " + e.getMessage(), ""));
            throw e;

        } finally {
            this.Close();
            ps.close();
        }//end of finally-block

        //clearing variables after update operations is executed
        total = 0.0;//reset the total value 0.0 after being updated 

    }//end of the method

    public List<DataEntryBEAN> getListOfStudentRegisteredPerACourses() throws Exception {
        retriveSessionFromUI();//

        // SPLITTING THE COURSE CODE & THE COURSE TITLE FROM THE LIST OF COURSES I.E 'ARB 122-ARABIC GRAMMAR I' is splitted into 'ARB 122' and 'ARABIC GRAMMAR I'
        String[] parts = coursetitle.split("-");
        part1 = parts[0];//course code
        part2 = parts[1];//course title
        this.Connector();

        List<DataEntryBEAN> list_of_student_per_course_info = new ArrayList<DataEntryBEAN>();

        try {

            ps = this.getCn().prepareStatement("select * from student_course_reg  ");//AND session=? //WHERE course_code=? AND session=?
            //ps.setString(1, part1.toString());//this repesents the course code
            // ps.setString(2, session);//session 

            rs = ps.executeQuery();

            while (rs.next()) {
                DataEntryBEAN tbl = new DataEntryBEAN();

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

