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
public class viewregistered_credit_hours extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    private int id;
    private String semester;
    private String level;
    private String coursecode;
    private String coursetitle;
    private int creditunit;
    private String status;
    private String courseCategory;
    private String prerequisite;
    private String dateregistered;
    private String doneby;
    private String session;
    private int maxCreditHours;
    private int minCreditHours;
    private List<String> intakeSessionList = new ArrayList<>();

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getDateregistered() {
        return dateregistered;
    }

    public void setDateregistered(String dateregistered) {
        this.dateregistered = dateregistered;
    }

    public String getDoneby() {
        return doneby;
    }

    public void setDoneby(String doneby) {
        this.doneby = doneby;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getMaxCreditHours() {
        return maxCreditHours;
    }

    public void setMaxCreditHours(int maxCreditHours) {
        this.maxCreditHours = maxCreditHours;
    }

    public int getMinCreditHours() {
        return minCreditHours;
    }

    public void setMinCreditHours(int minCreditHours) {
        this.minCreditHours = minCreditHours;
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
    
    
    public List<viewregistered_credit_hours> getRegisteredCreditHours() throws Exception {
        getintakeSessionInfoMthd();//invoked 
        
        this.Connector();

        List<viewregistered_credit_hours> coursereg_info = new ArrayList<viewregistered_credit_hours>();

        try {

            ps = this.getCn().prepareStatement("select * from credit_unit_reg WHERE session=? AND semester=?  ");//
            ps.setString(1, session);
            ps.setString(2, semester);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                viewregistered_credit_hours tbl = new viewregistered_credit_hours();

                tbl.setId(rs.getInt("id"));
                tbl.setSemester(rs.getString("semester"));
                tbl.setSession(rs.getString("session"));
                tbl.setMaxCreditHours(rs.getInt("max_credit_unit"));
                tbl.setMinCreditHours(rs.getInt("min_credit_unit"));
                
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
    
    public void goViewRegisteredCreditUnitMthd() throws Exception{
        getRegisteredCreditHours();//invoked
        
    }//end of the the method 

}//end of the class

