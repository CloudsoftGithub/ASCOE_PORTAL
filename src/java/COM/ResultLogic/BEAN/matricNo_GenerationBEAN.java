package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@RequestScoped
public class matricNo_GenerationBEAN extends DAO implements Serializable {

    PreparedStatement ps;
    ResultSet rs;
    ResultSet rssP;

    private Calendar calendar;
    String ProgramCode = "";
    int counter = 0;
    String myMatricNoGenTableName = "";

    String part1;
    String part2;

    private String appNo;
    private String faculty_SchoolName;
    private String department;
    private String programs;
    private String studentName;
    private String generatedMatricNo;
    private String phoneno;
    private Date dateGenerated;

    private String intakeSession;
    private String intakeYear;
    private String intakelevel;

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    private List<String> phoneNo_List = new ArrayList<>();

    private List<String> studentname_List = new ArrayList<>();

    private List<String> faculty_SchoolList = new ArrayList<>();

    private List<String> deparmentsList = new ArrayList<>();

    private List<String> programsSchoolList = new ArrayList<>();

    private List<String> intakeSessionList = new ArrayList<>();

    private List<String> intakeYearList = new ArrayList<>();

    public List<String> getIntakeYearList() {
        return intakeYearList;
    }

    public void setIntakeYearList(List<String> intakeYearList) {
        this.intakeYearList = intakeYearList;
    }

    public List<String> getIntakeSessionList() {
        return intakeSessionList;
    }

    public void setIntakeSessionList(List<String> intakeSessionList) {
        this.intakeSessionList = intakeSessionList;
    }

    public String getFaculty_SchoolName() {
        return faculty_SchoolName;
    }

    public void setFaculty_SchoolName(String faculty_SchoolName) {
        this.faculty_SchoolName = faculty_SchoolName;
    }

    public List<String> getDeparmentsList() {
        return deparmentsList;
    }

    public void setDeparmentsList(List<String> deparmentsList) {
        this.deparmentsList = deparmentsList;
    }

    public List<String> getProgramsSchoolList() {
        return programsSchoolList;
    }

    public void setProgramsSchoolList(List<String> programsSchoolList) {
        this.programsSchoolList = programsSchoolList;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPrograms() {
        return programs;
    }

    public void setPrograms(String programs) {
        this.programs = programs;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGeneratedMatricNo() {
        return generatedMatricNo;
    }

    public void setGeneratedMatricNo(String generatedMatricNo) {
        this.generatedMatricNo = generatedMatricNo;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public Date getDateGenerated() {
        return dateGenerated;
    }

    public void setDateGenerated(Date dateGenerated) {
        this.dateGenerated = dateGenerated;
    }

    public List<String> getPhoneNo_List() {
        return phoneNo_List;
    }

    public void setPhoneNo_List(List<String> phoneNo_List) {
        this.phoneNo_List = phoneNo_List;
    }

    public List<String> getStudentname_List() {
        return studentname_List;
    }

    public void setStudentname_List(List<String> studentname_List) {
        this.studentname_List = studentname_List;
    }

    public List<String> getFaculty_SchoolList() {
        return faculty_SchoolList;
    }

    public void setFaculty_SchoolList(List<String> faculty_SchoolList) {
        this.faculty_SchoolList = faculty_SchoolList;
    }

    public String getIntakeSession() {
        return intakeSession;
    }

    public void setIntakeSession(String intakeSession) {
        this.intakeSession = intakeSession;
    }

    public String getIntakeYear() {
        return intakeYear;
    }

    public void setIntakeYear(String intakeYear) {
        this.intakeYear = intakeYear;
    }

    public String getIntakelevel() {
        return intakelevel;
    }

    public void setIntakelevel(String intakelevel) {
        this.intakelevel = intakelevel;
    }

    public void retriveFaculty_SchoolNameFromUI() {//get the current Faculty_SchoolName on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        faculty_SchoolName = ec.getRequestParameterMap().get("matricNumerAssignmentForm:faculty-SchoolName");
    }//end of method

    public void retriveDepartmentNameFromUI() {//get the current DeptlName on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        department = ec.getRequestParameterMap().get("matricNumerAssignmentForm:dept");
    }//end of method

    public List<String> getfaculty_SchoolTitleMthd() throws Exception {

        faculty_SchoolList.removeAll(faculty_SchoolList);

        this.Connector();

        try {

            ps = this.getCn().prepareStatement("SELECT title FROM faculty");
            rs = ps.executeQuery();

            while (rs.next()) {
                faculty_SchoolList.add(rs.getString("title"));//retrieves all the facultie/schools  and ADD into the faculty_SchoolList
            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Faculty/School Retrieval Error", e.getMessage() + " . Pls, try again"));
        } finally {
            this.Close();
        }

        return faculty_SchoolList;

    }//end of method

    public void getstudentAdmissionInfoMthd() throws Exception {

        this.Connector();
        studentName = "";//Clears student's name prio fetching it  from DB
        phoneno = "";//Clears student's name prio fetching it from DB
        programs = "";//Clears student's name prio fetching it from DB
        
        try { 
            ps = this.getCn().prepareStatement("SELECT concat(surname, \" \", orther), phoneno,course_admitted,session  FROM admission_list WHERE appno=? "); //
            ps.setString(1, appNo);
            rs = ps.executeQuery();

            while (rs.next()) {
                studentName = rs.getString(1);
                phoneno = rs.getString(2);
                programs = rs.getString(3);
                intakeSession = rs.getString(4);

                //SPLITTING THE 'intakeSession' into two parts in order to get the 'IntakeYear'
                String[] parts = intakeSession.split("/");
                part1 = parts[0];//The inTake Year 
                part2 = parts[1];//The Next Year
                intakeYear = part1;//setting the 'part1' as intakeYear

            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Studentsname Retrieval Error", e.getMessage() + " . Pls, try again"));
        } finally {
            this.Close();
        }

    }//end of method

    public List<String> getphoneNoMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked in order to get the lates session

        phoneNo_List.removeAll(phoneNo_List);

        this.Connector();

        try { 
            ps = this.getCn().prepareStatement("SELECT phoneno FROM admission_list WHERE SESSION=? "); //
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                phoneNo_List.add(rs.getString(1));//retrieves all the students names  and ADD into the studentname_List
                System.err.println("ListPrinting:" + phoneNo_List);
            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "PhoneNo Retrieval Error", e.getMessage() + " . Pls, try again"));
        } finally {
            this.Close();
        }

        return studentname_List;

    }//end of method

    public List<String> getdepartmentTitleMthd() throws Exception {

        deparmentsList.removeAll(deparmentsList);

        this.Connector();

        try {

            ps = this.getCn().prepareStatement("SELECT title FROM department");
            rs = ps.executeQuery();

            while (rs.next()) {
                deparmentsList.add(rs.getString("title"));//retrieves all the deparments  and ADD into the deparmentsList
            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Department Retrieval Error", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return deparmentsList;

    }//end of method

    public List<String> getprogramsTitleMthd() throws Exception {

        //retriveDepartmentNameFromUI();//invoked
        programsSchoolList.removeAll(programsSchoolList);

        this.Connector();

        try {

            //ps = this.getCn().prepareStatement("SELECT d.title, p.title,pd.department_id FROM department d, programs p, programs_has_department pd where p.id = pd.programs_id  AND d.id = pd.department_id AND d.title=? ");
            ps = this.getCn().prepareStatement("SELECT title FROM programs");
            rs = ps.executeQuery();

            while (rs.next()) {
                programsSchoolList.add(rs.getString("title"));//retrieves all the deparments  and ADD into the deparmentsList
            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Programs Retrieval Error", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return programsSchoolList;

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

    public List<String> getSessionInfoForStudentRegMthd() throws Exception {
        //retriveDepartmentNameFromUI();//invoked
        intakeSessionList.removeAll(intakeSessionList);

        this.Connector();

        try {

            ps = this.getCn().prepareStatement("SELECT session FROM intakesessioninfo order by session Asc limit 1");
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

    public List<String> getintakeYearInfoMthd() throws Exception {

        intakeYearList.removeAll(intakeYearList);

        this.Connector();

        try {

            ps = this.getCn().prepareStatement("SELECT year FROM intakesessioninfo ");
            rs = ps.executeQuery();

            while (rs.next()) {
                intakeYearList.add(rs.getString("year"));//retrieves all the Years  and ADD into the intakeYearList
            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Intake Year  Error", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return intakeYearList;

    }//end of method

    public void generateMatricNoMthd() throws Exception {

        this.Connector();//

        ////Pulling the ProgramCode from the 'programs' table
        ps = this.getCn().prepareStatement("SELECT code FROM programs WHERE title = ? ");
        ps.setString(1, programs);
        rs = ps.executeQuery();

        while (rs.next()) {
            ProgramCode = rs.getString("code");
        }//end of while-block

        String myMatricNo = "";

        calendar = new GregorianCalendar();
        int cal = this.calendar.get(1);
        String calString = Integer.toString(cal);//converted to string 
        String subCal = calString.substring(2);//  Substring captures ONLY two digits from the YEAR-four digits (e.g 2021, ONLY 21 is captured)

        myMatricNoGenTableName = "generatedmatricno_" + ProgramCode;
        myMatricNo = "ER" + "/" + subCal + "/" + ProgramCode + "/";

        //VALIDATING THE SUPPLIED PHONE NO 
        ps = this.getCn().prepareStatement("SELECT phoneno FROM " + myMatricNoGenTableName + " WHERE phoneno = ? ");
        ps.setString(1, phoneno);
        rs = ps.executeQuery();
        if (rs.next()) {//Phone no is found

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "This Phone no:  " + phoneno + " has been used by another person", "replace it and try again"));

        } else {//phone NOT found
            System.out.println(" Printing the Cal TWO DIGITS " + subCal);
            ///Generating the Matric No
            try {

                if (studentName.equalsIgnoreCase("")) {//Serverside validations for the requred inputs
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please, supply name ", " and try again. Thank you."));
                } else if (phoneno.equalsIgnoreCase("")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please, supply phone ", " and try again. Thank you."));

                } else {
                    ps = getCn().prepareStatement("INSERT INTO " + myMatricNoGenTableName + " values(null,?,?,?,?,?,?, Date(Now()), ?,?,?)");
                    ps.setString(1, myMatricNo);
                    ps.setString(2, studentName);
                    ps.setString(3, faculty_SchoolName);
                    ps.setString(4, department);
                    ps.setString(5, programs);
                    ps.setString(6, phoneno);
                    ps.setString(7, intakelevel);
                    ps.setString(8, intakeSession);
                    ps.setString(9, intakeYear);
                    ps.executeUpdate();

                    counter++;//incrementing the counter 
                }

            } catch (Exception e) {
                throw e;
            } finally {
                // this.Close();
            }

            if (counter > 0) {//UPDATING THE MATRICNO IN THE 'myMatricNoGenTableName' TABLE 
                try {
                    PreparedStatement st4 = getCn().prepareStatement("UPDATE " + myMatricNoGenTableName + "  SET generatedMatricno= CONCAT(generatedMatricno,id) WHERE phoneno=? ");
                    st4.setString(1, phoneno);
                    st4.executeUpdate();

                } catch (Exception e) {
                    throw e;
                } finally {
                    // this.Close();
                }
            }

            ////Pulling the just generated MATRIC NO
            try {
                ps = this.getCn().prepareStatement("SELECT generatedMatricno FROM " + myMatricNoGenTableName);
                rs = ps.executeQuery();

                while (rs.next()) {
                    generatedMatricNo = rs.getString("generatedMatricno");
                }//end of while-block

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You have succcessfully generated a matric no: " + generatedMatricNo + " for: " + programs, " Thank you."));

            } catch (Exception e) {

                throw e;

            } finally {
                //this.Close();
            }

            if (counter > 0) {// 1. i.e record have been inserted into the 'myMatricNoGenTableName' table
                //2. Then we want to insert info into the the 'levelcompute' 

                /*
                  ps = this.getCn().prepareStatement("  SELECT id, matricno,level,session,year FROM levelcompute ");

                rs = ps.executeQuery();
                if (rs.next()) {//IF FOUND ... do nothing

                    //Do nothing 
                } else {//IF NOT FOUND .. Insert into the 'levelcompute' table  

                    ps = this.getCn().prepareStatement(" INSERT INTO levelcompute SELECT id, generatedMatricno,intake_level,intake_session,year FROM " + myMatricNoGenTableName);
                    ps.executeUpdate();
                }
                
                 */
                try {
                    ps = this.getCn().prepareStatement(" INSERT INTO levelcompute values(null, ?, ?, ?, ?)");
                    ps.setString(1, generatedMatricNo);//THE FULLED MATRIC NO
                    ps.setString(2, intakelevel);
                    ps.setString(3, intakeSession);
                    ps.setString(4, intakeYear);
                    ps.executeUpdate();

                } catch (Exception e) {
                    throw e;
                } finally {
                    this.Close();
                }
            }

        }

    }//end of the method

}//end of the class

