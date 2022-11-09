package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
 
@ManagedBean
@RequestScoped
public class CreditUnitRegBEAN extends DAO {

    PreparedStatement ps;
    ResultSet rs;
    ResultSet rssP;

        private List<String> intakeSessionList = new ArrayList<>();

    private int id;
    private String semester;
    private String session;
    private int maxCreditunit;
    private int minCreditunit;

    private String dateregistered;

    public List<String> getIntakeSessionList() {
        return intakeSessionList;
    }

    public void setIntakeSessionList(List<String> intakeSessionList) {
        this.intakeSessionList = intakeSessionList;
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

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getMaxCreditunit() {
        return maxCreditunit;
    }

    public void setMaxCreditunit(int maxCreditunit) {
        this.maxCreditunit = maxCreditunit;
    }

    public String getDateregistered() {
        return dateregistered;
    }

    public void setDateregistered(String dateregistered) {
        this.dateregistered = dateregistered;
    }

    public int getMinCreditunit() {
        return minCreditunit;
    }

    public void setMinCreditunit(int minCreditunit) {
        this.minCreditunit = minCreditunit;
    }

    //RETRIEVING VALUES for 'Session' FROM THE UI
    public void retriveSessionFromUI() {//get the current 'Session' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = ec.getRequestParameterMap().get("creditHours_regForm:mysession");
    }//end of method
    
    public List<String> getintakeSessionInfoMthd() throws Exception {
        //retriveDepartmentNameFromUI();//invoked
        intakeSessionList.removeAll(intakeSessionList);

        this.Connector();

        try {

            ps = this.getCn().prepareStatement("SELECT session FROM intakesessioninfo ");
            rs = ps.executeQuery();

            while (rs.next()) {
                intakeSessionList.add(rs.getString("session"));//retrieves all the sessions  and ADD into the intakeSessionList
            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Intake Session Error", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return intakeSessionList;

    }//end of method

    public void credit_unit_RegMthd() throws Exception {
        retriveSessionFromUI();//invoked

        this.Connector(); //invoked 

        //checking for duplicate entries 
        PreparedStatement st1 = getCn().prepareStatement("SELECT * FROM credit_unit_reg WHERE semester=? AND session=? ");
        st1.setString(1, semester);
        st1.setString(2, session);

        ResultSet rs = st1.executeQuery();

        if (rs.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Credit hours for this session: " + session + ", " + semester + " has been captured. Pls, check your entries!", "thank you!"));
        } else if (maxCreditunit <= 0 || minCreditunit <= 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Pls, supply a VALID number for 'max' and 'min' credit hours(units)", "thank you!"));

        } else {
            /////

            try {

                PreparedStatement ps = getCn().prepareStatement("INSERT INTO credit_unit_reg VALUES(?, ?,?,?,?, now())");
                ps.setString(1, null);
                ps.setString(2, semester);
                ps.setString(3, session);
                ps.setInt(4, maxCreditunit);
                ps.setInt(5, minCreditunit);

                int rowCount = ps.executeUpdate();

                if (rowCount > 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Credit hour(unit) for ' " + semester + ", " + session + " has been captured successfully. Thank you.", ""));

                }//end of the if-block

                //Clearing variables after insertion is done
                semester = "";
                session = "";
                maxCreditunit = 0;
                minCreditunit = 0;

            } catch (Exception e) {
                throw e;
            } finally {
                this.Close();
            }

            //////
        }

    }//end of the method 

    public void delete_CreditHours() throws Exception {

        try {
            retriveSessionFromUI();//invoked

            this.Connector(); //invoked 

            //checking for duplicate entries 
            PreparedStatement st1 = getCn().prepareStatement("DELETE FROM credit_unit_reg WHERE semester=? AND session=? ");
            st1.setString(1, semester);
            st1.setString(2, session);

            int rs = st1.executeUpdate();
            if (rs > 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Credit Hours(Units) for the Semester; " + semester + " , Session: " + session + " has been DELETED. Thank you.", ""));
            } else if (rs==0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Credit Hours(Units) for the Semester; " + semester + " , Session: " + session + " is NOT FOUND. Thank you.", ""));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

    }//end of the method 
}//end of the class

