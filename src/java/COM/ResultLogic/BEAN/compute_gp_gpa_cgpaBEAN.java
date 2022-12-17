package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class compute_gp_gpa_cgpaBEAN extends DAO {

    PreparedStatement ps;
    ResultSet rs;
    String ProgramCode = "";
    private String date;
    String Course_App_Tile;
    private String theRetrievedDepartment;

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

    public String getTheRetrievedDepartment() {
        return theRetrievedDepartment;
    }

    public void setTheRetrievedDepartment(String theRetrievedDepartment) {
        this.theRetrievedDepartment = theRetrievedDepartment;
    }

    public String getCourse_App_Tile() {
        return Course_App_Tile;
    }

    public void setCourse_App_Tile(String Course_App_Tile) {
        this.Course_App_Tile = Course_App_Tile;
    }

    private List<String> coursesCodeList = new ArrayList<>();
    private List<String> intakeSessionList = new ArrayList<>();
    private List<String> couse_choiseList = new ArrayList<>();
    private String course_choise;

    private String dateregistered;

    private String matricno;
    private String studentLevel;
    private String session;
    private String session_for_studList;

    private int TheCounter = 0;
    private String TheRetrievedName;
    private String TheRetrievedMatricNo;
    private int total_credit_unit;
    private int total_grade_point;
    private double grade_point_average;
    private double cummulative_grade_point_average;

    public double getCummulative_grade_point_average() {
        return cummulative_grade_point_average;
    }

    public void setCummulative_grade_point_average(double cummulative_grade_point_average) {
        this.cummulative_grade_point_average = cummulative_grade_point_average;
    }

    public int getTotal_credit_unit() {
        return total_credit_unit;
    }

    public void setTotal_credit_unit(int total_credit_unit) {
        this.total_credit_unit = total_credit_unit;
    }

    public int getTotal_grade_point() {
        return total_grade_point;
    }

    public void setTotal_grade_point(int total_grade_point) {
        this.total_grade_point = total_grade_point;
    }

    public double getGrade_point_average() {
        return grade_point_average;
    }

    public void setGrade_point_average(double grade_point_average) {
        this.grade_point_average = grade_point_average;
    }

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

    public void retriveSessionFromStudentListUI() {//get the current 'Session' on the STUDENTLIST UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("RegistedStudentDownloadForm:mysession");
    }//end of method

    public void retriveSession2FromStudentListUI() {//get the current 'Session' on the STUDENTLIST UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("computerCGPAForm:mysession");
    }//end of method

    public void retriveSessionFacultySchResulttListUI() {//get the current 'Session' on the FacultySchResulttListU UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("FacultySchoolResultGenerationForm:mysession");
    }//end of method

    public void retriveLevelFacultySchResulttListUI() {//get the current 'Level' on the FacultySchResulttListU UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        level = ec.getRequestParameterMap().get("FacultySchoolResultGenerationForm:myLevel");
    }//end of method

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

    public List<String> getSessionInfoForStudentRegMthd() throws Exception {
        retriveSessionFacultySchResulttListUI();//Invoked 

        //retriveDepartmentNameFromUI();//invoked
        intakeSessionList.removeAll(intakeSessionList);

        this.Connector();

        try {

            ps = this.getCn().prepareStatement("SELECT session FROM intakesessioninfo order by session ");
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
                couse_choiseList.add(rs.getString("title"));//retrieves all the registered course_chioce 
            }//end of while-block
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Programs Retrieval Error. ", e.getMessage() + " . Pls, try again"));
        } finally {
            //this.Close();
        }

        return couse_choiseList;

    }//end of method

    public void computeGPandGPAMthd() throws Exception {
        this.Connector();//establishes connectivity 
        //STEP1: Inserting the tuples into the 'compute_cgpa' table
        try {

            ps = this.getCn().prepareStatement(" SELECT * FROM compute_cgpa WHERE  session=? AND semester=? ");
            ps.setString(1, session);
            ps.setString(2, semester);//represents the 'course code'
            rs = ps.executeQuery();

            if (rs.next()) {//IF FOUND ... UPDATE THE EXISTING RECORD TO THE NEW....

                //STEP1: Delete the existing record by SESSION AND SEMESTER 
                ps = this.getCn().prepareStatement(" DELETE FROM compute_cgpa WHERE  session=? AND semester=? ");
                ps.setString(1, session);
                ps.setString(2, semester);// 
                ps.executeUpdate();

                //STEP2: THEN INSERT THE NEW TUBLE FROM THE ...  select query 
                ps = this.getCn().prepareStatement(" INSERT INTO  compute_cgpa   SELECT null, matricno, name, session, semester, sum(credit_unit), sum(total_point), sum(total_point)/sum(credit_unit),null,now() from result_data_entry WHERE semester=? AND session=? GROUP BY matricno ");
                ps.setString(1, semester);
                ps.setString(2, session);// 
                ps.executeUpdate();

            } else {//IF NOT FOUND .. Insert into the 'compute_cgpa' table  

                //Step3: inserting the FRESH NEW tuples into the 'compute_cgpa' 
                ps = this.getCn().prepareStatement(" INSERT INTO  compute_cgpa   SELECT null, matricno, name, session, semester, sum(credit_unit), sum(total_point), sum(total_point)/sum(credit_unit),null,now() from result_data_entry WHERE semester=? AND session=? GROUP BY matricno ");
                ps.setString(1, semester);
                ps.setString(2, session);// 
                ps.executeUpdate();
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error " + " GP and GPA computer Error " + e.getMessage(), ""));

        } finally {
            //this.Close();
        }

        //STEP2: UPDATING THE 'remarks' COLUMN AND THE 'GRADE POINT' COLUMN ON THE 'compute_cgpa' TABLE
        try {
            ps = this.getCn().prepareStatement(" UPDATE compute_cgpa  SET remark =  CASE WHEN (grade_point_average >= 4.50) THEN 'DISTICTION'  WHEN (grade_point_average >=3.50) THEN 'CREDIT' WHEN (grade_point_average >=2.40) THEN 'MERIT'  WHEN (grade_point_average >=1.5) THEN 'PASS'   WHEN (grade_point_average >=1.0) THEN 'LOW PASS' ELSE  'FAIL' END  WHERE session=? AND semester=? ");//
            ps.setString(1, session);//set the local variable 'CourseCode' from the command link parameter
            ps.setString(2, semester);//set the local variable 'CourseCode' from the command link parameter

            ps.executeUpdate();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" + matricno + " Error: " + e.getMessage(), ""));
            throw e;

        } finally {
            this.Close();
            ps.close();
        }//end of finally-block

    }//end of the method

    public void computeGPandGPAFirstSemesterMthd() throws Exception {
        this.Connector();//establishes connectivity 
        //STEP1: Inserting the tuples into the 'compute_cgpa' table
        try {

            ps = this.getCn().prepareStatement(" SELECT * FROM compute_cgpa WHERE  session=? AND semester='FIRST SEMESTER' ");
            ps.setString(1, session);
            // ps.setString(2, semester);//represents the 'course code'
            rs = ps.executeQuery();

            if (rs.next()) {//IF FOUND ... UPDATE THE EXISTING RECORD TO THE NEW....

                //STEP1: Delete the existing record by SESSION AND SEMESTER 
                ps = this.getCn().prepareStatement(" DELETE FROM compute_cgpa WHERE  session=? AND semester='FIRST SEMESTER' ");
                ps.setString(1, session);
                //ps.setString(2, semester);// 
                ps.executeUpdate();

                //STEP2: THEN INSERT THE NEW TUBLE FROM THE ...  select query 
                ps = this.getCn().prepareStatement(" INSERT INTO  compute_cgpa   SELECT null, matricno, name, session, semester, sum(credit_unit), sum(total_point), sum(total_point)/sum(credit_unit),null,now() from result_data_entry WHERE semester='FIRST SEMESTER' AND session=? GROUP BY matricno ");
                // ps.setString(1, semester);
                ps.setString(1, session);// 
                ps.executeUpdate();

            } else {//IF NOT FOUND .. Insert into the 'compute_cgpa' table  

                //Step3: inserting the FRESH NEW tuples into the 'compute_cgpa' 
                ps = this.getCn().prepareStatement(" INSERT INTO  compute_cgpa   SELECT null, matricno, name, session, semester, sum(credit_unit), sum(total_point), sum(total_point)/sum(credit_unit),null,now() from result_data_entry WHERE semester='FIRST SEMESTER' AND session=? GROUP BY matricno ");
                // ps.setString(1, semester);
                ps.setString(1, session);// 
                ps.executeUpdate();
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error " + " GP and GPA computer Error " + e.getMessage(), ""));

        } finally {
            //this.Close();
        }

        //STEP2: UPDATING THE 'remarks' COLUMN AND THE 'GRADE POINT' COLUMN ON THE 'compute_cgpa' TABLE
        try {
            ps = this.getCn().prepareStatement(" UPDATE compute_cgpa  SET remark =  CASE WHEN (grade_point_average >= 4.50) THEN 'DISTICTION'  WHEN (grade_point_average >=3.50) THEN 'CREDIT' WHEN (grade_point_average >=2.40) THEN 'MERIT'  WHEN (grade_point_average >=1.5) THEN 'PASS'   WHEN (grade_point_average >=1.0) THEN 'LOW PASS' ELSE  'FAIL' END  WHERE session=? AND semester='FIRST SEMESTER' ");//
            ps.setString(1, session);//set the local variable 'CourseCode' from the command link parameter
            //ps.setString(2, semester);//set the local variable 'CourseCode' from the command link parameter

            ps.executeUpdate();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" + matricno + " Error: " + e.getMessage(), ""));
            throw e;

        } finally {
            this.Close();
            ps.close();
        }//end of finally-block

    }//end of the method

    public void computeGPandGPASecondSemesterMthd() throws Exception {
        this.Connector();//establishes connectivity 
        //STEP1: Inserting the tuples into the 'compute_cgpa' table
        try {

            ps = this.getCn().prepareStatement(" SELECT * FROM compute_cgpa WHERE  session=? AND semester='SECOND SEMESTER' ");
            ps.setString(1, session);
            // ps.setString(2, semester);//represents the 'course code'
            rs = ps.executeQuery();

            if (rs.next()) {//IF FOUND ... UPDATE THE EXISTING RECORD TO THE NEW....

                //STEP1: Delete the existing record by SESSION AND SEMESTER 
                ps = this.getCn().prepareStatement(" DELETE FROM compute_cgpa WHERE  session=? AND semester='SECOND SEMESTER' ");
                ps.setString(1, session);
                //ps.setString(2, semester);// 
                ps.executeUpdate();

                //STEP2: THEN INSERT THE NEW TUBLE FROM THE ...  select query 
                ps = this.getCn().prepareStatement(" INSERT INTO  compute_cgpa   SELECT null, matricno, name, session, semester, sum(credit_unit), sum(total_point), sum(total_point)/sum(credit_unit),null,now() from result_data_entry WHERE semester='SECOND SEMESTER' AND session=? GROUP BY matricno ");
                // ps.setString(1, semester);
                ps.setString(1, session);// 
                ps.executeUpdate();

            } else {//IF NOT FOUND .. Insert into the 'compute_cgpa' table  

                //Step3: inserting the FRESH NEW tuples into the 'compute_cgpa' 
                ps = this.getCn().prepareStatement(" INSERT INTO  compute_cgpa   SELECT null, matricno, name, session, semester, sum(credit_unit), sum(total_point), sum(total_point)/sum(credit_unit),null,now() from result_data_entry WHERE semester='SECOND SEMESTER' AND session=? GROUP BY matricno ");
                // ps.setString(1, semester);
                ps.setString(1, session);// 
                ps.executeUpdate();
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error " + " GP and GPA computer Error " + e.getMessage(), ""));

        } finally {
            //this.Close();
        }

        //STEP2: UPDATING THE 'remarks' COLUMN AND THE 'GRADE POINT' COLUMN ON THE 'compute_cgpa' TABLE
        try {
            ps = this.getCn().prepareStatement(" UPDATE compute_cgpa  SET remark =  CASE WHEN (grade_point_average >= 4.50) THEN 'DISTICTION'  WHEN (grade_point_average >=3.50) THEN 'CREDIT' WHEN (grade_point_average >=2.40) THEN 'MERIT'  WHEN (grade_point_average >=1.5) THEN 'PASS'   WHEN (grade_point_average >=1.0) THEN 'LOW PASS' ELSE  'FAIL' END  WHERE session=? AND semester='SECOND SEMESTER' ");//
            ps.setString(1, session);//set the local variable 'CourseCode' from the command link parameter
            //ps.setString(2, semester);//set the local variable 'CourseCode' from the command link parameter

            ps.executeUpdate();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" + matricno + " Error: " + e.getMessage(), ""));
            throw e;

        } finally {
            this.Close();
            ps.close();
        }//end of finally-block

    }//end of the method

    public void generateGPandGPA_Faculty_Sch_Format_By_ProgramMthd() throws Exception {

        //STEP0: INVOKING THE methods that computes GP/GPA FOR BOTH 1ST SND 2ND SEMESTERS FIRST BEFORE OTHER AVTIVITIES
        computeGPandGPAFirstSemesterMthd();//invoked for 1st Semester GP/GPA calculation
        computeGPandGPASecondSemesterMthd();//invoked for 2nd Semester GP/GPA calculation
        computeCGPAMthd();//invoked for thenCGPA Computation 

        // getStudentsResult();
        this.Connector();//establishes connectivity 

        retriveSessionFacultySchResulttListUI();//invoked 
        retriveLevelFacultySchResulttListUI();//invoked
        String[] parts = null;//Initialization of for the Parts with string array type

        part1 = "";//clears the content prio loading a the values below
        part2 = "";

        //STEP1:// SPLITTING THE COURSE CODE & THE PROGRAM/COMBINATION I.E 'Arabic/Hausa' is splitted into 'Arabic' and 'Hausa', where Arabic is the Department OR 
        if (course_choise.contains("/")) {//if course-choice/Program/Combination contains a foward slash "/"
            parts = course_choise.split("/");
        } else {//if course-choice/Program/Combination contains a parenthesis "()"
            parts = course_choise.split("\\(");
        }

        part1 = parts[0];//Part1 reprsent the Department
        theRetrievedDepartment = part1;
        System.out.println("Result of the splitting: " + part1);
        System.out.println("Result of the splitting: " + part2);

        //STEP2: RETRIVEING THE PROGRAM 'APPTYPE' TITLE 
        ps = this.getCn().prepareStatement(" SELECT  a.app_type FROM  programs p inner join admission_list a WHERE p.title=? AND a.course_choice= ? ");
        ps.setString(1, course_choise);
        ps.setString(2, course_choise);//represents the 'course code'
        rs = ps.executeQuery();

        while (rs.next()) {
            Course_App_Tile = rs.getString(1);
        }//end of the while-block
        //course_choise = Course_App_Tile +course_choise;

        getStudentsResult();//invoked .. the method 'getStudentsResult' which handles the functionalities for the Result Display in the Datatable

        getStudentGPandGPAPerProgramAndSemester();//invoked ...

        /*
         //STEP1: Inserting the tuples into the 'compute_cgpa' table
        try {

            ps = this.getCn().prepareStatement(" SELECT * FROM compute_cgpa WHERE  session=? AND semester=? ");
            ps.setString(1, session);
            ps.setString(2, semester);//represents the 'course code'
            rs = ps.executeQuery();

            if (rs.next()) {//IF FOUND ... UPDATE THE EXISTING RECORD TO THE NEW....

                //STEP1: Delete the existing record by SESSION AND SEMESTER 
                ps = this.getCn().prepareStatement(" DELETE FROM compute_cgpa WHERE  session=? AND semester=? ");
                ps.setString(1, session);
                ps.setString(2, semester);// 
                ps.executeUpdate();

                //STEP2: THEN INSERT THE NEW TUBLE FROM THE ...  select query 
                ps = this.getCn().prepareStatement(" INSERT INTO  compute_cgpa   SELECT null, matricno, name, session, semester, sum(credit_unit), sum(total_point), sum(total_point)/sum(credit_unit),null,now() from result_data_entry WHERE semester=? AND session=? GROUP BY matricno ");
                ps.setString(1, semester);
                ps.setString(2, session);// 
                ps.executeUpdate();

            } else {//IF NOT FOUND .. Insert into the 'compute_cgpa' table  

                //Step3: inserting the FRESH NEW tuples into the 'compute_cgpa' 
                ps = this.getCn().prepareStatement(" INSERT INTO  compute_cgpa   SELECT null, matricno, name, session, semester, sum(credit_unit), sum(total_point), sum(total_point)/sum(credit_unit),null,now() from result_data_entry WHERE semester=? AND session=? GROUP BY matricno ");
                ps.setString(1, semester);
                ps.setString(2, session);// 
                ps.executeUpdate();
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error " + " GP and GPA computer Error " + e.getMessage(), ""));

        } finally {
            //this.Close();
        }

        //STEP2: UPDATING THE 'remarks' COLUMN AND THE 'GRADE POINT' COLUMN ON THE 'compute_cgpa' TABLE
        try {
            ps = this.getCn().prepareStatement(" UPDATE compute_cgpa  SET remark =  CASE WHEN (grade_point_average >= 4.50) THEN 'DISTICTION'  WHEN (grade_point_average >=3.50) THEN 'CREDIT' WHEN (grade_point_average >=2.40) THEN 'MERIT'  WHEN (grade_point_average >=1.5) THEN 'PASS'   WHEN (grade_point_average >=1.0) THEN 'LOW PASS' ELSE  'FAIL' END  WHERE session=? AND semester=? ");//
            ps.setString(1, session);//set the local variable 'CourseCode' from the command link parameter
            ps.setString(2, semester);//set the local variable 'CourseCode' from the command link parameter

            ps.executeUpdate();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" + matricno + " Error: " + e.getMessage(), ""));
            throw e;

        } finally {
            this.Close();
            ps.close();
        }//end of finally-block
         */
    }//end of the method

    public void computeCGPAMthd() throws Exception {
        this.Connector();//establishes connectivity 

        //STEP1: inserting the tuples into the 'compute_cgpa' table
        try {

            ps = this.getCn().prepareStatement(" SELECT * FROM cgpa WHERE  session=? ");
            ps.setString(1, session);
            rs = ps.executeQuery();

            if (rs.next()) {//IF FOUND ... do UPDATE THE EXISTING RECORD

                //STEP-A-: Delete the existing record by SESSION AND SEMESTER 
                ps = this.getCn().prepareStatement(" DELETE FROM cgpa WHERE  session=? ");
                ps.setString(1, session);
                ps.executeUpdate();

                //STEP-B-: THEN INSERT THE NEW TUBLE FROM THE ...  select query 
                ps = this.getCn().prepareStatement(" INSERT INTO  cgpa  SELECT null, matricno, name, session, sum(total_credit_unit), sum(total_grade_point), ROUND( sum(total_grade_point)/sum(total_credit_unit), 2 ), null, now()  FROM compute_cgpa  WHERE session=?  GROUP BY matricno ");
                ps.setString(1, session);// 
                ps.executeUpdate();

            } else {//IF NOT FOUND .. Insert into the 'compute_cgpa' table  

                ps = this.getCn().prepareStatement(" INSERT INTO  cgpa  SELECT null, matricno, name, session, sum(total_credit_unit), sum(total_grade_point), ROUND( sum(total_grade_point)/sum(total_credit_unit), 2 ), null, now()  FROM compute_cgpa  WHERE session=?  GROUP BY matricno ");
                ps.setString(1, session);// 
                ps.executeUpdate();
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error " + " GP and GPA computer Error " + e.getMessage(), ""));

        } finally {
            //this.Close();
        }

        //STEP2: UPDATING THE 'remarks' COLUMN AND THE 'GRADE POINT' COLUMN ON THE 'compute_cgpa' TABLE
        try {
            ps = this.getCn().prepareStatement(" UPDATE cgpa  SET remark =  CASE WHEN (cummulative_grade_point_average >= 4.50) THEN 'DISTICTION'  WHEN (cummulative_grade_point_average >=3.50) THEN 'CREDIT' WHEN (cummulative_grade_point_average >=2.40) THEN 'MERIT'  WHEN (cummulative_grade_point_average >=1.5) THEN 'PASS'   WHEN (cummulative_grade_point_average >=1.0) THEN 'LOW PASS' ELSE  'FAIL' END  WHERE session=?  ");//
            ps.setString(1, session);//set the local variable 'CourseCode' from the command link parameter

            ps.executeUpdate();

        } catch (Exception e) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" + matricno + " Error: " + e.getMessage(), ""));
            throw e;

        } finally {
            this.Close();
            ps.close();
        }//end of finally-block

    }//end of the method

    public List<compute_gp_gpa_cgpaBEAN> getStudentsResult() throws Exception {
        this.Connector();//establishes connection.

        retriveLevelFacultySchResulttListUI();//invoked

        //STEP0: DEDUCING (EXTRACTING) THE THREE-LETTER INSIDE THE MATRIC NO FROM THE 'PROGRAM/COMBINATION'. This will enable us to fetch the student Results ONLY for the 'Program'
        ////Pulling the ProgramCode from the 'programs' table
        ps = this.getCn().prepareStatement("SELECT code FROM programs WHERE title = ? ");
        ps.setString(1, course_choise);
        rs = ps.executeQuery();

        while (rs.next()) {
            ProgramCode = rs.getString("code");
        }//end of while-block

        //STEP1: Listening the computed GP, GPA ....
        List<compute_gp_gpa_cgpaBEAN> coursereg_info = new ArrayList<compute_gp_gpa_cgpaBEAN>();

        //STEP3: DISPLAYING THE CONTENT OF THE 'result_data_entry' ON THE DATATABLE
        try {

            ps = this.getCn().prepareStatement("SELECT id,matricno,name,session,semester,course_code,credit_unit,total_score,grade_letter FROM result_data_entry WHERE session=? AND semester=? AND student_level=? AND matricno LIKE ? order by course_code DESC");//matricno,
            ps.setString(1, session);
            ps.setString(2, semester);// 
            ps.setString(3, level);
            ps.setString(4, "%" + ProgramCode + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compute_gp_gpa_cgpaBEAN tbl = new compute_gp_gpa_cgpaBEAN();

                tbl.setId(rs.getInt(1));
                tbl.setMatricno(rs.getString(2));
                tbl.setStudentname(rs.getString(3));
                tbl.setSession(rs.getString(4));
                tbl.setSemester(rs.getString(5));

                tbl.setCoursecode(rs.getString(6));
                tbl.setCreditunit(rs.getInt(7));
                tbl.setTotal(rs.getDouble(8));
                tbl.setGradeLetter(rs.getString(9));

                coursereg_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return coursereg_info;

    }//end of the method

    public List<compute_gp_gpa_cgpaBEAN> getStudentGPandGPAPerProgramAndSemester() throws Exception {
        this.Connector();//establishes connection.

       // retriveSessionFromStudentListUI();

        //STEP1: Listening the computed GP, GPA ....
        List<compute_gp_gpa_cgpaBEAN> coursereg_info = new ArrayList<compute_gp_gpa_cgpaBEAN>();

        //STEP3: DISPLAYING THE CONTENT OF THE 'result_data_entry' ON THE DATATABLE
        try {

            ps = this.getCn().prepareStatement("SELECT id,name,matricno,session,semester,total_credit_unit,total_grade_point,round(grade_point_average, 2),remark,date  FROM  compute_cgpa WHERE  session=? AND semester=? AND matricno LIKE ?  order by matricno ASC ");
            ps.setString(1, session);
            ps.setString(2, semester);//ccc
            ps.setString(3, "%" + ProgramCode + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compute_gp_gpa_cgpaBEAN tbl = new compute_gp_gpa_cgpaBEAN();

                tbl.setId(rs.getInt(1));
                tbl.setStudentname(rs.getString(2));
                tbl.setMatricno(rs.getString(3));
                tbl.setSession(rs.getString(4));
                tbl.setSemester(rs.getString(5));

                tbl.setTotal_credit_unit(rs.getInt(6));
                tbl.setTotal_grade_point(rs.getInt(7));
                tbl.setGrade_point_average(rs.getDouble(8));
                tbl.setRemarks(rs.getString(9));
                tbl.setDateregistered(rs.getString(10));

                coursereg_info.add(tbl);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return coursereg_info;

    }//end of the method

    public List<compute_gp_gpa_cgpaBEAN> getStudentGPandGPAFirstSemester() throws Exception {
        this.Connector();//establishes connection.

        retriveSessionFromStudentListUI();

        //STEP1: Listening the computed GP, GPA ....
        List<compute_gp_gpa_cgpaBEAN> coursereg_info = new ArrayList<compute_gp_gpa_cgpaBEAN>();

        //STEP3: DISPLAYING THE CONTENT OF THE 'result_data_entry' ON THE DATATABLE
        try {

            ps = this.getCn().prepareStatement("SELECT id,name,matricno,session,semester,total_credit_unit,total_grade_point,round(grade_point_average, 2),remark,date  FROM  compute_cgpa WHERE  session=? AND semester='FIRST SEMESTER' order by matricno ASC ");
            ps.setString(1, session);
            //ps.setString(2, semester);// 

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compute_gp_gpa_cgpaBEAN tbl = new compute_gp_gpa_cgpaBEAN();

                tbl.setId(rs.getInt(1));
                tbl.setStudentname(rs.getString(2));
                tbl.setMatricno(rs.getString(3));
                tbl.setSession(rs.getString(4));
                tbl.setSemester(rs.getString(5));

                tbl.setTotal_credit_unit(rs.getInt(6));
                tbl.setTotal_grade_point(rs.getInt(7));
                tbl.setGrade_point_average(rs.getDouble(8));
                tbl.setRemarks(rs.getString(9));
                tbl.setDateregistered(rs.getString(10));

                coursereg_info.add(tbl);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return coursereg_info;

    }//end of the method

    public List<compute_gp_gpa_cgpaBEAN> getStudentGPandGPASecondSemester() throws Exception {
        this.Connector();//establishes connection.

        retriveSessionFromStudentListUI();

        //STEP1: Listening the computed GP, GPA ....
        List<compute_gp_gpa_cgpaBEAN> coursereg_info = new ArrayList<compute_gp_gpa_cgpaBEAN>();

        //STEP3: DISPLAYING THE CONTENT OF THE 'result_data_entry' ON THE DATATABLE
        try {

            ps = this.getCn().prepareStatement("SELECT  id,name,matricno,session,semester,total_credit_unit,total_grade_point,round(grade_point_average, 2),remark,date FROM  compute_cgpa WHERE  session=? AND semester='SECOND SEMESTER' order by matricno ASC ");
            ps.setString(1, session);
            //ps.setString(2, semester);// 

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compute_gp_gpa_cgpaBEAN tbl = new compute_gp_gpa_cgpaBEAN();

                tbl.setId(rs.getInt(1));
                tbl.setStudentname(rs.getString(2));
                tbl.setMatricno(rs.getString(3));
                tbl.setSession(rs.getString(4));
                tbl.setSemester(rs.getString(5));

                tbl.setTotal_credit_unit(rs.getInt(6));
                tbl.setTotal_grade_point(rs.getInt(7));
                tbl.setGrade_point_average(rs.getDouble(8));
                tbl.setRemarks(rs.getString(9));
                tbl.setDateregistered(rs.getString(10));

                coursereg_info.add(tbl);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return coursereg_info;

    }//end of the method

    public List<compute_gp_gpa_cgpaBEAN> getStudentCGPA() throws Exception {
        this.Connector();//establishes connection.

        retriveSession2FromStudentListUI();

        //STEP1: Listening the computed GP, GPA ....
        List<compute_gp_gpa_cgpaBEAN> coursereg_info = new ArrayList<compute_gp_gpa_cgpaBEAN>();

        //STEP3: DISPLAYING THE CONTENT OF THE 'result_data_entry' ON THE DATATABLE
        try {

            ps = this.getCn().prepareStatement("SELECT * FROM  cgpa WHERE  session=? order by matricno ASC ");
            ps.setString(1, session);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compute_gp_gpa_cgpaBEAN tbl = new compute_gp_gpa_cgpaBEAN();

                tbl.setId(rs.getInt("id"));
                tbl.setStudentname(rs.getString("name"));
                tbl.setMatricno(rs.getString("matricno"));
                tbl.setSession(rs.getString("session"));

                tbl.setTotal_credit_unit(rs.getInt("total_credit_unit"));
                tbl.setTotal_grade_point(rs.getInt("total_grade_point"));
                tbl.setCummulative_grade_point_average(rs.getDouble("cummulative_grade_point_average"));

                tbl.setRemarks(rs.getString("remark"));
                tbl.setDateregistered(rs.getString("date"));

                coursereg_info.add(tbl);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return coursereg_info;

    }//end of the method

}//end of the class

