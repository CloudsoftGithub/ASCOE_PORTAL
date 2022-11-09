package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
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

    
    
    
    public List<viewregistered_credit_hours> getRegisteredCreditHours() throws Exception {
        this.Connector();

        List<viewregistered_credit_hours> coursereg_info = new ArrayList<viewregistered_credit_hours>();

        try {

            ps = this.getCn().prepareStatement("select * from credit_unit_reg ");
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

}//end of the class

