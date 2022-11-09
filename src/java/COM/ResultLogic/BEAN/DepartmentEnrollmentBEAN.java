
package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.departmentDAO;
import COM.ResultLogic.MODEL.department;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
 public class DepartmentEnrollmentBEAN {
    private department dpartment = new department();

    public department getDpartment() {
        return dpartment;
    }

    public void setDpartment(department dpartment) {
        this.dpartment = dpartment;
    }
   
    public void departmentEnrolmentMthd() throws Exception{
        
        try {
         departmentDAO   dao = new departmentDAO();
         dao.departmentEnrollmentMthd(dpartment);
        } catch (Exception e) {
            throw e;
        }
        
    }//end of the method 

    
}//end of the class


