package COM.ResultLogic.DAO;

import COM.ResultLogic.MODEL.usersSignup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class usersSignupDAO extends DAO {

    public void usersCreationMthd(usersSignup usersSigp) throws Exception {

        this.Connector();

        ////////////// Checking the multiple signup with same username
        PreparedStatement st1 = this.getCn().prepareStatement("select * from users where username=?");
        st1.setString(1, usersSigp.getUsername());

        ResultSet rs = st1.executeQuery(); /////////////this block of code check for the multiple username signup as stated above. BUT THE TEST WWAS DONE BELOW IN THE ELSE IF BLOCK
        if (rs.next()) { // NOTE: the query state for this if block has been written above 

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Signup Error.  " + " This 'username' has been signed up, pls use a different username", "  "));

            //this.Close();
            // st1.close();
        } else {

            try {//thic block of codes does the actual insertions 

                PreparedStatement st = this.getCn().prepareStatement("INSERT INTO users values(?,?,?,?,?,?,Date(Now()))");
                st.setString(1, null);
                st.setString(2, usersSigp.getUsername());
                st.setString(3, usersSigp.getPassword());
                st.setString(4, usersSigp.getUserType());
                st.setString(5, usersSigp.getGsmNo());
                st.setString(6, usersSigp.getName());
                st.executeUpdate();
                st.close();

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "You succcessfully signup" + " thank you! ",
                                "you will be redirected to a different page"));

                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("usersLogin.xhtml");

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Users Creation Error.  " + e.getMessage() + " Pls, try again", ""));

            }//end of method

        }//end of else-block

    }//end of usersCreationMthd

    public void adminUsersCreationMthd(usersSignup usersSigp) throws Exception {
        String Mystatus = "Active";
        this.Connector();

        ////////////// Checking the multiple admin signup with same username
        PreparedStatement st1 = this.getCn().prepareStatement("select * from adminusers where username=?");
        st1.setString(1, usersSigp.getUsername());

        ResultSet rs = st1.executeQuery(); /////////////this block of code check for the multiple username signup as stated above. BUT THE TEST WWAS DONE BELOW IN THE ELSE IF BLOCK
        if (rs.next()) { // NOTE: the query state for this if block has been written above 

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Signup Error. " + " This 'Admin Username' has been signed up, pls use a different username", ""));

            //this.Close();
            // st1.close();
        } else {

            try {//thic block of codes does the actual insertions 

                PreparedStatement st = this.getCn().prepareStatement("INSERT INTO adminusers values(?,?,?,?,?,?,?,Date(Now()), ?)");
                st.setString(1, null);
                st.setString(2, usersSigp.getUsername());
                st.setString(3, usersSigp.getPassword());
                st.setString(4, usersSigp.getUserType());
                st.setString(5, usersSigp.getGsmNo());
                st.setString(6, usersSigp.getEmailid());
                st.setString(7, usersSigp.getName());
                st.setString(8, Mystatus);//status with embedded values of "Active"
                st.executeUpdate();
                st.close();

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "You succcessfully created an Admin" + " thank you! ",
                                ""));

                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("successOnAdminuserCreation.xhtml");

            } catch (Exception e) {
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Users Creation Error. " +  e.getMessage() + " Pls, try again", ""));

            }//end of method

        }//end of else-block

    }//end of usersCreationMthd

}//end of class
