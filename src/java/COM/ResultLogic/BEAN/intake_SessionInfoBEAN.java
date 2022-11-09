package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.intake_Session_infoDAO;
import COM.ResultLogic.MODEL.intake_Session_info;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class intake_SessionInfoBEAN {

    private intake_Session_info intkSessioInfo = new intake_Session_info();

    public intake_Session_info getIntkSessioInfo() {
        return intkSessioInfo;
    }

    public void setIntkSessioInfo(intake_Session_info intkSessioInfo) {
        this.intkSessioInfo = intkSessioInfo;
    }

    public void captureIntakeSessionInfoMthd() throws Exception {

        try {
            intake_Session_infoDAO dao = new intake_Session_infoDAO();

            dao.enrollIntake_sessionInfomthd(intkSessioInfo);

        } catch (Exception e) {

            throw e;
        }

    }//end of the method

}//end of the class
