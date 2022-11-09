package COM.ResultLogic.DAO;

import COM.ResultLogic.MODEL.staffSignup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class staffSignupDAO extends DAO {

    int counter = 0;

    String TheEmploymentNo;
    String Theusername;
    String TheCadre;

    public String getTheEmploymentNo() {
        return TheEmploymentNo;
    }

    public void setTheEmploymentNo(String TheEmploymentNo) {
        this.TheEmploymentNo = TheEmploymentNo;
    }

    public String getTheusername() {
        return Theusername;
    }

    public void setTheusername(String Theusername) {
        this.Theusername = Theusername;
    }

    public String getTheCadre() {
        return TheCadre;
    }

    public void setTheCadre(String TheCadre) {
        this.TheCadre = TheCadre;
    }

    public void staffSignupMthd(staffSignup stffSgnp) throws Exception {

        this.Connector();//established a connection

        String myflag = "used";
        String myStatus = "active";

        //checking for duplicate entries 
        PreparedStatement st2 = getCn().prepareStatement("select SerialNo, PinNo from staffSignup where serialNo=? AND PinNo=?");
        st2.setString(1, stffSgnp.getSerialNo());
        st2.setString(2, stffSgnp.getPinNo());

        ResultSet rs2 = st2.executeQuery();

        PreparedStatement st1 = getCn().prepareStatement("select username from staffSignup where username=?");
        st1.setString(1, stffSgnp.getUsername());
        ResultSet rs = st1.executeQuery();

        PreparedStatement st6 = getCn().prepareStatement("select username from staffSignup where email=?");
        st6.setString(1, stffSgnp.getEmail());

        ResultSet rs6 = st6.executeQuery();

        if (rs2.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error in signup invalid scratch card detail, this card has been used.", "thank you!"));
            st1.close();
        } else if (rs.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error in signup This username has been used, pls use a different username", "thank you!"));
            Close();
            st1.close();
        } else if (rs6.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error in signup This Email ID has been used, pls use a different email ID", "thank you!"));
            this.Close();
            st1.close();
        } else {
            /////
            try {
                PreparedStatement ps = getCn().prepareStatement("INSERT INTO staffSignup VALUES(?,'empNo',?,?,?,?,?,?,?,?,now(),?,?,?, ?,?,'active')");

                ps.setString(1, null);
                ps.setString(2, stffSgnp.getFullname());

                ps.setString(3, stffSgnp.getEmail());
                ps.setString(4, stffSgnp.getPhone());
                ps.setString(5, stffSgnp.getAddress());
                ps.setString(6, stffSgnp.getCadre());
                ps.setString(7, stffSgnp.getEmploymentDate());

                ps.setString(8, stffSgnp.getHighestQualification());
                ps.setString(9, stffSgnp.getSchoolttended()); ////
                ps.setString(10, stffSgnp.getUsername());
                ps.setString(11, stffSgnp.getPassword());

                ps.setString(12, stffSgnp.getPinNo());
                ps.setString(13, stffSgnp.getSerialNo());
                ps.setString(14, myflag);

                int rowCount = ps.executeUpdate();

                if (rowCount > 0) {

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Staff Name: ' " + stffSgnp.getFullname() + " has been enrolled successfully. Thank you.", ""));
                    counter++;

                    ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                    redcontext.redirect("staffSuccessfulSignup.xhtml");   /// redirecting to  ...  
                }//end of the if-block

                if (counter > 0) {

                    this.Connector();//estalished connector

                    try {
                        PreparedStatement st4 = getCn().prepareStatement("UPDATE staffSignup  SET emp_no= CONCAT('ASCOE/STAFF/',id) WHERE username=? ");
                        st4.setString(1, stffSgnp.getUsername());
                        st4.executeUpdate();
                        st4.close();
                    } catch (Exception e) {
                        throw e;
                    }
                }

                //Clearing variables after insertion is done
                stffSgnp.setFullname("");
                stffSgnp.setEmail("");
                stffSgnp.setPhone("");
                stffSgnp.setPinNo("");
                stffSgnp.setSerialNo("");
                stffSgnp.setAddress("");
                stffSgnp.setCadre("");
                stffSgnp.setEmploymentDate("");
                //stffSgnp.setUsername("");// commented beacuse it's need for the displa of info after signup 
                stffSgnp.setPassword("");
            } catch (Exception e) {
                throw e;
            } finally {
                this.Close();
            }

            //////
        }
    }//end of the method

    public void retrievingStaffNoMethd(staffSignup stffSgnp) throws Exception {
        this.Connector();
        try {
            PreparedStatement st = getCn().prepareStatement("SELECT emp_no,cadre,username FROM staffSignup WHERE username=? ");
            st.setString(1, stffSgnp.getUsername());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TheEmploymentNo = rs.getString(1);
                stffSgnp.setEmploymentNo(TheEmploymentNo);

                TheCadre = rs.getString(2);
                stffSgnp.setCadre(TheCadre);

                Theusername = rs.getString(3);
                stffSgnp.setUsername(Theusername);

            }
            st.close();
            Close();
        } catch (Exception e) {
            throw e;
        }
    }

}//end of the class 
