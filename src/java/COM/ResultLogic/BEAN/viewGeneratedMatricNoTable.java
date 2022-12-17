/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class viewGeneratedMatricNoTable extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    private int id;
    private String faculty_SchoolName;
    private String department;
    private String programs;
    private String studentName;
    private String generatedMatricNo;
    private String phoneno;
    private String dateGenerated;

    private String intakeSession;
    private String intakeYear;
    private String intakelevel;

    private List<String> intakeSessionList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty_SchoolName() {
        return faculty_SchoolName;
    }

    public void setFaculty_SchoolName(String faculty_SchoolName) {
        this.faculty_SchoolName = faculty_SchoolName;
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

    public String getDateGenerated() {
        return dateGenerated;
    }

    public void setDateGenerated(String dateGenerated) {
        this.dateGenerated = dateGenerated;
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

    public List<String> getIntakeSessionList() {
        return intakeSessionList;
    }

    public void setIntakeSessionList(List<String> intakeSessionList) {
        this.intakeSessionList = intakeSessionList;
    }

    public List<String> getintakeSessionInfoMthd() throws Exception {

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

    public void goViewGeneratedMatricNoMthd() throws Exception {
        getGeneratedMatricNumberForARISMthd();//invoked
        getGeneratedMatricNumberForBICHMthd();//invoked
        getGeneratedMatricNumberForINCOMthd();//invoked
        getGeneratedMatricNumberForENHAMthd();//invoked

        getGeneratedMatricNumberForENSOMthd();//invoked
        getGeneratedMatricNumberForHASOMthd();
        getGeneratedMatricNumberForARHAMthd();
        getGeneratedMatricNumberForCOBIMthd();
        getGeneratedMatricNumberForCOCHMthd();
        getGeneratedMatricNumberForCOMTHMthd();
        getGeneratedMatricNumberForCOPHMthd();
        getGeneratedMatricNumberForENARMthd();
        getGeneratedMatricNumberForENENMthd();
        getGeneratedMatricNumberForENISMthd();
        getGeneratedMatricNumberForINBIMthd();
        getGeneratedMatricNumberForINCHMthd();
        getGeneratedMatricNumberForINPHMthd();
        getGeneratedMatricNumberForISCMthd();
        getGeneratedMatricNumberForMTHBIMthd();
        getGeneratedMatricNumberForMTHCHMthd();
        getGeneratedMatricNumberForMTHPHMthd();
        getGeneratedMatricNumberForMTHINMthd();
        getGeneratedMatricNumberForISARMthd();
        getGeneratedMatricNumberForISHAMthd();
        getGeneratedMatricNumberForISSOMthd();
        getGeneratedMatricNumberForSOARMthd();
        getGeneratedMatricNumberForSOSOMthd();
    }//end of the the method 

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForARISMthd() throws Exception {
        //intakeSession = "";//Clears the 'intakeSession' before fetching the data

        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement(" select * from generatedmatricno_aris WHERE intake_session=? order by  generatedMatricno asc, intake_level");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();
            System.out.println(" Sample Intake Session " + intakeSession);

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForBICHMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_bich WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForINCOMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_inco WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForENHAMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_enha WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));
                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForENSOMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select id,fullname,generatedMatricno,faculty_school,department,programm, phoneno,dateGenerated,intake_level,intake_session,year from generatedmatricno_enso WHERE intake_session=? order by  generatedMatricno asc, intake_level");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForHASOMthd() throws Exception {

        getintakeSessionInfoMthd();//invoked 
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_haso WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForARHAMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from  	generatedmatricno_arha WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForCOBIMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from  	generatedmatricno_cobi WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForCOCHMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_coch WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForCOMTHMthd() throws Exception {

        getintakeSessionInfoMthd();//invoked 
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from  	generatedmatricno_comth WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForCOPHMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from  	generatedmatricno_coph  WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForENARMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_enar WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForENENMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from  	generatedmatricno_enen  WHERE intake_session=? order by  generatedMatricno asc, intake_level ");

            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForENISMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_enis WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForINBIMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_inbi WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForINCHMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_inch  WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForINPHMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_inph WHERE intake_session=? order by  generatedMatricno asc, intake_level");
            ps.setString(1, intakeSession);

            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForISCMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_isc WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForMTHBIMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from  	generatedmatricno_mthbi WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);

            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForMTHCHMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from  	generatedmatricno_mthch WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);

            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForMTHPHMthd() throws Exception {

        getintakeSessionInfoMthd();//invoked 
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_mthph WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);

            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForMTHINMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_mthin WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForISARMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_isar WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForISHAMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_isha WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method
    
    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForISSOMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_isso WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method
    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForSOARMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_soar WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method
     public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForSOSOMthd() throws Exception {
        getintakeSessionInfoMthd();//invoked 

        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_soso WHERE intake_session=? order by  generatedMatricno asc, intake_level ");
            ps.setString(1, intakeSession);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewGeneratedMatricNoTable tbl = new viewGeneratedMatricNoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setStudentName(rs.getString("fullname"));
                tbl.setGeneratedMatricNo(rs.getString("generatedMatricno"));
                tbl.setFaculty_SchoolName(rs.getString("faculty_school"));
                tbl.setDepartment(rs.getString("department"));
                tbl.setPrograms(rs.getString("programm"));
                tbl.setPhoneno(rs.getString("phoneno"));
                tbl.setDateGenerated(rs.getString("dateGenerated"));

                tbl.setIntakelevel(rs.getString("intake_level"));
                tbl.setIntakeSession(rs.getString("intake_session"));
                tbl.setIntakeYear(rs.getString("year"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method
}//end of the class

