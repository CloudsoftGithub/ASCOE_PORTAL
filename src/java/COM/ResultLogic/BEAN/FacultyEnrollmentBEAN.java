
package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.facultyDAO;
import COM.ResultLogic.MODEL.faculty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped 
public class FacultyEnrollmentBEAN {
    private  faculty facEnrollment = new faculty();

    public faculty getFacEnrollment() {
        return facEnrollment;
    }

    public void setFacEnrollment(faculty facEnrollment) {
        this.facEnrollment = facEnrollment;
    }
        
    public void facultyEnrollmentMethod() throws Exception{
        
        try {
            facultyDAO dao = new facultyDAO();
            dao.facultyEnrollmentMthd(facEnrollment);
            
        } catch (Exception e) {
            throw e;
        }
        
    }//end of the method
    
}//end of the class
