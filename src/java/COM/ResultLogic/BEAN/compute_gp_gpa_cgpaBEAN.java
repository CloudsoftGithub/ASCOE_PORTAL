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
public class compute_gp_gpa_cgpaBEAN extends DAO {

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

    public void computeGPandGPAMthd() throws Exception {
        this.Connector();//establishes connectivity 

        //STEP1: inserting the tuples into the 'compute_cgpa' table
        try {

            ps = this.getCn().prepareStatement(" SELECT * FROM compute_cgpa WHERE  session=? AND semester=? ");
            ps.setString(1, session);
            ps.setString(2, semester);//represents the 'course code'

            rs = ps.executeQuery();
            if (rs.next()) {//IF FOUND ... do nothing

                //Do nothing 
            } else {//IF NOT FOUND .. Insert into the 'compute_cgpa' table  

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

    public void computeCGPAMthd() throws Exception {
        this.Connector();//establishes connectivity 

        //STEP1: inserting the tuples into the 'compute_cgpa' table
        try {

            ps = this.getCn().prepareStatement(" SELECT * FROM cgpa WHERE  session=? ");
            ps.setString(1, session);

            rs = ps.executeQuery();
            if (rs.next()) {//IF FOUND ... do nothing

                //Do nothing 
            } else {//IF NOT FOUND .. Insert into the 'compute_cgpa' table  

                ps = this.getCn().prepareStatement(" INSERT INTO  cgpa  SELECT null, matricno, name, session, sum(total_credit_unit), sum(total_grade_point), sum(total_grade_point)/sum(total_credit_unit), null, now()  FROM compute_cgpa  WHERE session=? GROUP BY matricno ");
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

    public List<compute_gp_gpa_cgpaBEAN> getStudentGPandGPAFirstSemester() throws Exception {
        this.Connector();//establishes connection.

        retriveSessionFromStudentListUI();

        //STEP1: Listening the computed GP, GPA ....
        List<compute_gp_gpa_cgpaBEAN> coursereg_info = new ArrayList<compute_gp_gpa_cgpaBEAN>();

        //STEP3: DISPLAYING THE CONTENT OF THE 'result_data_entry' ON THE DATATABLE
        try {

            ps = this.getCn().prepareStatement("SELECT * FROM  compute_cgpa WHERE  session=? AND semester='FIRST SEMESTER' order by matricno ASC ");
            ps.setString(1, session);
            //ps.setString(2, semester);// 

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compute_gp_gpa_cgpaBEAN tbl = new compute_gp_gpa_cgpaBEAN();

                tbl.setId(rs.getInt("id"));
                tbl.setStudentname(rs.getString("name"));
                tbl.setMatricno(rs.getString("matricno"));
                tbl.setSession(rs.getString("session"));
                tbl.setSemester(rs.getString("semester"));

                tbl.setTotal_credit_unit(rs.getInt("total_credit_unit"));
                tbl.setTotal_grade_point(rs.getInt("total_grade_point"));
                tbl.setGrade_point_average(rs.getDouble("grade_point_average"));
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

    public List<compute_gp_gpa_cgpaBEAN> getStudentGPandGPASecondSemester() throws Exception {
        this.Connector();//establishes connection.

        retriveSessionFromStudentListUI();

        //STEP1: Listening the computed GP, GPA ....
        List<compute_gp_gpa_cgpaBEAN> coursereg_info = new ArrayList<compute_gp_gpa_cgpaBEAN>();

        //STEP3: DISPLAYING THE CONTENT OF THE 'result_data_entry' ON THE DATATABLE
        try {

            ps = this.getCn().prepareStatement("SELECT * FROM  compute_cgpa WHERE  session=? AND semester='SECOND SEMESTER' order by matricno ASC ");
            ps.setString(1, session);
            //ps.setString(2, semester);// 

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compute_gp_gpa_cgpaBEAN tbl = new compute_gp_gpa_cgpaBEAN();

                tbl.setId(rs.getInt("id"));
                tbl.setStudentname(rs.getString("name"));
                tbl.setMatricno(rs.getString("matricno"));
                tbl.setSession(rs.getString("session"));
                tbl.setSemester(rs.getString("semester"));

                tbl.setTotal_credit_unit(rs.getInt("total_credit_unit"));
                tbl.setTotal_grade_point(rs.getInt("total_grade_point"));
                tbl.setGrade_point_average(rs.getDouble("grade_point_average"));
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

