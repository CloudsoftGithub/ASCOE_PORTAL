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
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class viewProgramsTable extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    private int id;
    private String title;
    private String code;
    private String duration;
    private String faculty;

    private String dateregistered;
    private String doneBy;
    private String programDureation;
    private List<String> programDurationList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDateregistered() {
        return dateregistered;
    }

    public void setDateregistered(String dateregistered) {
        this.dateregistered = dateregistered;
    }

    public String getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }

    public List<String> getProgramDurationList() {
        return programDurationList;
    }

    public void setProgramDurationList(List<String> programDurationList) {
        this.programDurationList = programDurationList;
    }

    public String getProgramDureation() {
        return programDureation;
    }

    public void setProgramDureation(String programDureation) {
        this.programDureation = programDureation;
    }

    public List<String> getProgramDurationMthd() throws Exception {

        programDurationList.removeAll(programDurationList);

        this.Connector();

        try {

            ps = this.getCn().prepareStatement("SELECT distinct duration FROM programs ");
            rs = ps.executeQuery();

            while (rs.next()) {
                programDurationList.add(rs.getString("duration"));//retrieves all the sessions  and ADD into the intakeSessionList
            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Intake Session Error", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return programDurationList;

    }//end of method

    public List<viewProgramsTable> getenrolledPrograms() throws Exception {
        getProgramDurationMthd();//invoked 
        
        this.Connector();

        List<viewProgramsTable> progrm_info = new ArrayList<viewProgramsTable>();

        try {

            ps = this.getCn().prepareStatement("select * from programs WHERE duration=? ");
            ps.setString(1, programDureation);

            rs = ps.executeQuery();

            while (rs.next()) {
                viewProgramsTable tbl = new viewProgramsTable();
                tbl.setId(rs.getInt("id"));
                tbl.setTitle(rs.getString("title"));
                tbl.setCode(rs.getString("code"));
                tbl.setDuration(rs.getString("duration"));
                tbl.setDateregistered(rs.getString("dateregistered"));
                tbl.setDoneBy(rs.getString("doneBy"));

                progrm_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

       
        return progrm_info;

    }//end of the method

    public void goViewEnrolledrogramsMthd() throws Exception {
        getenrolledPrograms();//invoked

    }//end of the the method 
}//end of the class

