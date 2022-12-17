package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class staffLoginBEAN extends DAO {

    private String username;
    private String password;
    private String email;
    private String phoneno;
    private String staus;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    public void staffLoginMethod() throws Exception {

        this.Connector();//connection established

        try {

            Connection con = null;
            PreparedStatement ps = null;
            String myusername = username.toString();
            String mypassword = password.toString();

            PreparedStatement st = this.getCn().prepareStatement("select username, password from staffsignup where username= ? AND password= ? AND status='active' ");
            st.setString(1, myusername);
            st.setString(2, mypassword);

            ResultSet rs = st.executeQuery();
            if (rs.next()) // found
            {
                HttpSession hs = SessionManagement_util.getSession();
                hs.setAttribute(username, username);

                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("teachingStaffDashboard.xhtml");   /// redirecting to  the 
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                "Invalid username or password! " + "  Pls, use correct credentials,",
                                "and try again."));
            }//end of else block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Invalid Login! " + e.getMessage() + "  Pls, make sure you have singedup as a staff.",
                            "Please, Try Again."));

        }

    }//end of the method
    
    
   /*
    
     public String signoutMethod() throws IOException {
        HttpSession hs = SessionManagement_util.getSession();
        hs.invalidate();
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.username = "";
        this.password = "";
        return "index.xhtml";
    }
    
    */
    
        public String signoutMethod() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.username = "";
        return "";
    }

}//eend of the Class
