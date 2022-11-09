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
public class viewIntakeSessionInfoTable extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    private int id;
    private String intake_session;
    private String intake_year;
    private String status;

    private String dateCaptured;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntake_session() {
        return intake_session;
    }

    public void setIntake_session(String intake_session) {
        this.intake_session = intake_session;
    }

    public String getIntake_year() {
        return intake_year;
    }

    public void setIntake_year(String intake_year) {
        this.intake_year = intake_year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateCaptured() {
        return dateCaptured;
    }

    public void setDateCaptured(String dateCaptured) {
        this.dateCaptured = dateCaptured;
    }

    
    public List<viewIntakeSessionInfoTable> getCapturedIntakeSessionInfo() throws Exception {
        this.Connector();

        List<viewIntakeSessionInfoTable> intakeSession_info = new ArrayList<viewIntakeSessionInfoTable>();

        try {

            ps = this.getCn().prepareStatement("select * from intakesessioninfo ");
            rs = ps.executeQuery();

            while (rs.next()) {
                viewIntakeSessionInfoTable tbl = new viewIntakeSessionInfoTable();
                tbl.setId(rs.getInt("id"));
                tbl.setIntake_session(rs.getString("session"));
                tbl.setIntake_year(rs.getString("year"));
                tbl.setStatus(rs.getString("status"));
                tbl.setDateCaptured(rs.getString("dateCaptured"));
                
                intakeSession_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return intakeSession_info;

    }//end of the method

}//end of the class

