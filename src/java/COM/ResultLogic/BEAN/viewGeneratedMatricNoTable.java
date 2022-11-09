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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
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

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForARISMthd() throws Exception {
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_ARIS ");
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

    public List<viewGeneratedMatricNoTable> getGeneratedMatricNumberForBICHMthd() throws Exception {
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_bich ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_inco ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_enha ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_enso ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_haso ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_ARHA ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_COBI ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_COCH ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_COMTH ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_COPH ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_ENAR ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_ENEN ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_ENIS ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_INBI ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_INCH ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_INPH ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_ISC ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_MTHBI ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_MTHCH ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_MTHPH ");
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
        this.Connector();

        List<viewGeneratedMatricNoTable> depart_info = new ArrayList<viewGeneratedMatricNoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from generatedmatricno_MTHIN ");
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

