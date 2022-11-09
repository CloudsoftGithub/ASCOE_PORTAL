package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.programstDAO;
import COM.ResultLogic.MODEL.programms;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class programsEnrollmentBEAN {

    private programms prgrms = new programms();

    public programms getPrgrms() {
        return prgrms;
    }

    public void setPrgrms(programms prgrms) {
        this.prgrms = prgrms;
    }

    public void programEnrollmentMthd() throws Exception {
        try {
            programstDAO dao = new programstDAO();
            dao.programmsEnrollmentMethod(prgrms);
        } catch (Exception e) {
            throw e;
        }

    }//end of the method

}//end of the class
