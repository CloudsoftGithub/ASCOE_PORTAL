package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean
@RequestScoped
public class courseRegBEAN extends DAO {

    PreparedStatement ps;
    ResultSet rs;
    ResultSet rssP;

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

    private List<String> programsSchoolList = new ArrayList<>();

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

    public List<String> getProgramsSchoolList() {
        return programsSchoolList;
    }

    public void setProgramsSchoolList(List<String> programsSchoolList) {
        this.programsSchoolList = programsSchoolList;
    }

    public void courseRegMthd() throws Exception {
        this.Connector(); //invoked 
        String dommyDoneBy = "Admin";

        //checking for duplicate entries 
        PreparedStatement st1 = getCn().prepareStatement("select * from course_reg where course_title=? AND course_code=? AND course_category = ?");
        st1.setString(1, coursetitle);
        st1.setString(2, coursecode);
        st1.setString(3, courseCategory);
        ResultSet rs = st1.executeQuery();

        if (rs.next()) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "The supplied 'Course' Name OR title has been registered. Pls, check your entries!", "thank you!"));

        } else {
            /////

            try {

                PreparedStatement ps = getCn().prepareStatement("INSERT INTO course_reg VALUES(?, ?,?,?,?,?,?,?,?, now(), ?)");

                ps.setString(1, null);
                ps.setString(2, semester);
                ps.setString(3, level);
                ps.setString(4, coursecode);
                ps.setString(5, coursetitle);
                ps.setInt(6, creditunit);
                ps.setString(7, status);
                ps.setString(8, courseCategory);
                ps.setString(9, prerequisite);
                ps.setString(10, dommyDoneBy);
                int rowCount = ps.executeUpdate();

                if (rowCount > 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Course Code: ' " + coursecode+ "  With Course Title: "+ coursetitle + " has been enrolled successfully. Thank you.", ""));

                }//end of the if-block

                //Clearing variables after insertion is done
                coursecode = "";
                coursetitle = "";
                creditunit = 0;
 
            } catch (Exception e) {
                throw e;
            } finally {
                this.Close();
            }

            //////
        }

    }//end of the method 
}//end of the class

