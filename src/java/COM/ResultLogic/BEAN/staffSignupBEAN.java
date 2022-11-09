package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.staffSignupDAO;
import COM.ResultLogic.MODEL.staffSignup;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class staffSignupBEAN {

    private staffSignup stffsgnp = new staffSignup();

    public staffSignup getStffsgnp() {
        return stffsgnp;
    }

    public void setStffsgnp(staffSignup stffsgnp) {
        this.stffsgnp = stffsgnp;
    }

    public void staffsignupMethod() throws Exception {
        try {
            staffSignupDAO dao = new staffSignupDAO();
            dao.staffSignupMthd(stffsgnp);
        } catch (Exception e) {
            throw e;
        }

    }//end of the method

    public void retrieveStaffNoMthd() throws Exception {

        try {
            staffSignupDAO dao = new staffSignupDAO();
            dao.retrievingStaffNoMethd(stffsgnp);
        } catch (Exception e) {
            throw e;
        }

    }//end of the method
}//end of the class

