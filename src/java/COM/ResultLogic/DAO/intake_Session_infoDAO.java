package COM.ResultLogic.DAO;

import COM.ResultLogic.MODEL.intake_Session_info;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class intake_Session_infoDAO extends DAO {

    public void enrollIntake_sessionInfomthd(intake_Session_info intkSessionInfo) throws Exception {
        this.Connector();//

        //checking for duplicate entries 
        PreparedStatement st1 = getCn().prepareStatement("select * from intakesessioninfo where session = ? AND year=? ");
        st1.setString(1, intkSessionInfo.getIntake_session());
        st1.setString(2, intkSessionInfo.getIntake_year());

        ResultSet rs = st1.executeQuery();

        if (rs.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "The supplied 'Intake Session info' has been used. Pls, check your entries!", "thank you!"));

        } else {
            ////

            try {

                PreparedStatement ps = getCn().prepareStatement("INSERT INTO intakesessioninfo VALUES(?, ?,?,'on', now())");

                ps.setString(1, null);
                ps.setString(2, intkSessionInfo.getIntake_session());
                ps.setString(3, intkSessionInfo.getIntake_year());

                int rowCount = ps.executeUpdate();

                if (rowCount > 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Intake Session: ' " + intkSessionInfo.getIntake_session() + " has been captured successfully. Thank you.", ""));

                }//end of the if-block

                //Clearing variables after insertion is done
                intkSessionInfo.setIntake_session("");
                intkSessionInfo.setIntake_year("");

            } catch (Exception e) {

            } finally {
                this.Close();//
            }

        }//end of the else-block 

    }//end of the method

}//end of the class
