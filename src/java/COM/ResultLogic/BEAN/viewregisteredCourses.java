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
public class viewregisteredCourses extends DAO {

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

    public List<viewregisteredCourses> getRegisteredCourses() throws Exception {
        this.Connector();

        List<viewregisteredCourses> coursereg_info = new ArrayList<viewregisteredCourses>();

        try {

            ps = this.getCn().prepareStatement("select * from course_reg ");
            rs = ps.executeQuery();

            while (rs.next()) {
                viewregisteredCourses tbl = new viewregisteredCourses();
            
                tbl.setId(rs.getInt("id"));
                tbl.setSemester(rs.getString("semester"));
                tbl.setLevel(rs.getString("level"));
                tbl.setCoursecode(rs.getString("course_code"));
                tbl.setCoursetitle(rs.getString("course_title"));
                tbl.setCreditunit(rs.getInt("credit_unit"));
                tbl.setStatus(rs.getString("status"));
                tbl.setPrerequisite(rs.getString("prerequisite"));
                tbl.setCourseCategory(rs.getString("course_category"));
                tbl.setDateregistered(rs.getString("dateregistered"));
                tbl.setDoneby(rs.getString("doneby"));
 
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

