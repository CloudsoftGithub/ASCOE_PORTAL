package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class deleteCourseRowInStudentCourseRegBEAN extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    private String matricNo;
    private String session;
    private String courseCode;
    private String coursetile;

    public String getMatricNo() {
        return matricNo;
    }

    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCoursetile() {
        return coursetile;
    }

    public void setCoursetile(String coursetile) {
        this.coursetile = coursetile;
    }

    public void retriveMatricNoFromUI() {//get the current 'MatricNo'  on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        matricNo = ec.getRequestParameterMap().get("studentCourseRegForm:myMatricNo");
    }//end of method  

    public void retriveSessionFromUI() {//get the current 'session'  on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("studentCourseRegForm:mysession");
    }//end of method 

    ////DELETING/REMOVING THE PRODUCTS FROM THE PRE-ORDER LIST (Customer may deside to do some adjustments for some reasons)
    public void removeCourseFromStudentCourseRegListWithCommandLink(String MatricNo, String Session, String CourseCode) throws Exception {
        this.Connector();//establishes connectdion from the DAO Class (i.e the super class)

        retriveMatricNoFromUI();//invokes the method so 'MatricNo' variable get captured from the BEAN
        retriveSessionFromUI();//invokes the method so 'session' variable get captured from the BEAN

        try {

            ps = this.getCn().prepareStatement("DELETE FROM student_course_reg WHERE matricno =? AND session=? AND course_code=? ");//AND session=? AND course_code=?
            ps.setString(1, matricNo);
            ps.setString(2, Session);//set the local variable 'CourseCode' from the command link parameter
            ps.setString(3, CourseCode);//set the local variable 'CourseCode' from the command link parameter

            ps.executeUpdate();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Course; ' " + CourseCode + " has been DELETED. Thank you.", ""));
 
        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
            ps.close();
        }//end of finally-block

    }//end of method

}//end of the class

