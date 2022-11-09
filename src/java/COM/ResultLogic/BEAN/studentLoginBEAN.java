package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class studentLoginBEAN extends DAO {

    private Calendar calendar;
    String myStudentLevel;

    int rowCount = 0;
    PreparedStatement ps;
    ResultSet rs;

    private String username;
    private String password;
    private String userType;
    private String email;
    private String phoneno;
    private String matricNo;

    private String fullName;

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMyStudentLevel() {
        return myStudentLevel;
    }

    public void setMyStudentLevel(String myStudentLevel) {
        this.myStudentLevel = myStudentLevel;
    }

    public String getMatricNo() {
        return matricNo;
    }

    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }

    public void studentLoginMthd() throws Exception {
        this.Connector();//
        //PULLING student Info
        pullingStudentInfoMthd();

        //PULLING student LEVEL
        pullingStudentLevelInfoMthd();//invoked 

        try {

            Connection con = null;
            PreparedStatement ps = null;

            PreparedStatement st = this.getCn().prepareStatement("select username, password from studentreg where username= ? and password= ? ");
            st.setString(1, username);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            if (rs.next()) // found
            {

                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("studentDashboard.xhtml");   /// redirecting to  the 

            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                "Wrong Login Credentials! " + "  username or password NOT correct!",
                                "Supply correc credentials and try again"));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Invalid Login! " + e.getMessage() + "  Pls, make that you have signed up as a student!",
                            "and , try again"));
        } finally {
            // this.Close();
        }

        //PULLING student Info
        //pullingStudentInfoMthd();
        //PULLING student LEVEL
        //pullingStudentLevelInfoMthd();//invoked 
    }//end of the method

    public void pullingStudentInfoMthd() throws Exception {
        this.Connector();//

        pullingStudentLevelInfoMthd();//invoked 

        try {

            String myusername = username.toString();
            String mypassword = password.toString();

            PreparedStatement st = this.getCn().prepareStatement("select firstname,middlename,lastname,matricno from studentreg where username= ? and password= ? ");
            st.setString(1, myusername);
            st.setString(2, mypassword);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String FisrtName = rs.getString("firstname");
                String MiddleName = rs.getString("middlename");
                String LastName = rs.getString("lastname");
                matricNo = rs.getString("matricno");

                fullName = FisrtName + " " + MiddleName + " " + LastName;

            }

        } catch (Exception e) {

            throw e;
        }

    }//end of the method 

    public void pullingStudentLevelInfoMthd() throws Exception {//
        this.Connector();
 
        ////////////////////
        //ps = this.getCn().prepareStatement("SELECT matricno FROM studentreg where username= ? and password= ? ");
        ps = this.getCn().prepareStatement("SELECT level FROM levelcompute WHERE matricno= ?  ");
        ps.setString(1, matricNo);
        rs = ps.executeQuery();
       
        while (rs.next()) {
            myStudentLevel = rs.getString("level");
             
            System.out.println("sample level: "+ myStudentLevel);
            System.out.println("matric no: "+ matricNo);
            /*
            String StudentMatricNo = rs.getString("matricno");
            String Student_Sub_AmtricNo = StudentMatricNo.substring(4, 5);
            int subMatricNo = Integer.parseInt(Student_Sub_AmtricNo);
            System.err.println("Testing Level: " + Student_Sub_AmtricNo);
            calendar = new java.util.GregorianCalendar();
            int mycurrentCalendarYear = calendar.get(Calendar.YEAR);//PULLS out the current Calendar (Year) from the system time

            int myDif = mycurrentCalendarYear - subMatricNo;
            System.out.println("Testing Calendar: " + mycurrentCalendarYear);
            System.out.println("Testing Sub: " + subMatricNo);

            System.out.println("TESTING DIF: " + myDif);
            
             if (myDif == 0) {
                myStudentLevel = "NCE I";
            } else if (myDif == 1) {
                myStudentLevel = "NCE II";

            } else if (myDif == 2) {
                myStudentLevel = "NCE III";
            } else if (myDif == 3) {//For spillover students students - 1st Year
                myStudentLevel = "NCE IV";
            } else if (myDif == 4) {//For spillover students students - 2nd Year
                myStudentLevel = "NCE V";
            } else {
                myStudentLevel = "NA";
            }
             */

        }//end of while-block

    }//end of the method

}//end of the class
