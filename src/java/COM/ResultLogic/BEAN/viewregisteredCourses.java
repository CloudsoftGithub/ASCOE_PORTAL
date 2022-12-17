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
public class viewregisteredCourses extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    private List<String> courseCategoryList = new ArrayList<>();
    private List<String> courseLevelList = new ArrayList<>();
    private List<String> courseSemesterList = new ArrayList<>();

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

    public List<String> getCourseSemesterList() {
        return courseSemesterList;
    }

    public void setCourseSemesterList(List<String> courseSemesterList) {
        this.courseSemesterList = courseSemesterList;
    }

    public List<String> getCourseLevelList() {
        return courseLevelList;
    }

    public void setCourseLevelList(List<String> courseLevelList) {
        this.courseLevelList = courseLevelList;
    }

    public List<String> getCourseCategoryList() {
        return courseCategoryList;
    }

    public void setCourseCategoryList(List<String> courseCategoryList) {
        this.courseCategoryList = courseCategoryList;
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

    public List<String> getlelvelMthd() throws Exception {

        this.Connector();
        courseLevelList.removeAll(courseLevelList);//

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT distinct level FROM course_reg ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseLevelList.add(rs.getString("level"));// 
            }//end of while-block
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Course Level Error. ", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return courseLevelList;

    }//end of method

    public List<String> getcoursecategoryMthd() throws Exception {

        this.Connector();
        courseCategoryList.removeAll(courseCategoryList);//

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT distinct course_category FROM course_reg ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseCategoryList.add(rs.getString("course_category"));// 
             }//end of while-block
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Course Category Error. ", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return courseCategoryList;

    }//end of method

    public List<viewregisteredCourses> getRegisteredCourses() throws Exception {
        
        getcoursecategoryMthd();//Invoked this method in order to get the 'selected course category'
        getlelvelMthd();//invoked this method in order to get the 'selected course category'
        
        this.Connector();//invoked
        
        List<viewregisteredCourses> coursereg_info = new ArrayList<viewregisteredCourses>();

        try {

            ps = this.getCn().prepareStatement("select * from course_reg WHERE course_category = ?  AND level=? AND semester=? ");// AND level=?
            ps.setString(1, courseCategory);
            ps.setString(2, level);
            ps.setString(3, semester);
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

    public void goViewMethod() throws Exception {

        getRegisteredCourses();
    }//end 

}//end of the class

