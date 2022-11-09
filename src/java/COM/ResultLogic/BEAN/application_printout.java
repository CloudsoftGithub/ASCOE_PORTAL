/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@ApplicationScoped
public class application_printout  extends DAO{
      int rowCount = 0;
    private String appNo;
    private String pinno;
    private String serialno;
    private String status;
    private String flag;
    private String appType;

    private String the_retreived_ApplicationNumber;
    private String the_retreived_ApplicationType;
    private String the_retreived_Course_Choice;
    private String the_retreived_Surname;
    private String the_retreived_Orthername;
    private String the_retreived_email;
    private String the_retreived_session;
    private String the_retreived_phoneno;
    private String the_retreived_regDate;
    
    
      public void retrieveDataPrioPrintingPayment() throws ClassNotFoundException, Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
      
        
        this.Connector();//invoked the mysql connection instance 
        
        /////////CONFIRMING that the scratch card pins and serial exist 
        String PreEnrollmentMyflag = "preUsed";
        String PostEnrollmentMyflag = "used";
        String myStatus = "active";

        PreparedStatement st2 = getCn().prepareStatement("SELECT PinNo,SerialNo FROM application_for_admission WHERE SerialNo=? AND PinNo=? AND flag='used' ");
        st2.setString(1, serialno);
        st2.setString(2, pinno);
        ResultSet rs2 = st2.executeQuery();

        PreparedStatement st = getCn().prepareStatement("SELECT PinNo,SerialNo FROM application_for_admission WHERE appno =? AND session=? ");
        st.setString(1, the_retreived_ApplicationNumber);
        st.setString(2, the_retreived_session);

        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Payment Error. You are already DONE with PAYMENT. Please, log into your dashboard and proceeed to STEP 3 - The 'Bio Data' Form. ", " "));
            this.Close();
            st.close();
        }else if (rs2.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Scratch Card Error. This card has been USED. Please, supply correct card details.", ""));
            this.Close();
            st2.close();
        }   else {

            try {
                PreparedStatement ps = getCn().prepareStatement(" INSERT INTO application_for_admission VALUES(?, ?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,  ?,?, ?,?,?,?, ?, ?, now(), ?)");
                ps.setString(1, null);
                ps.setString(2, the_retreived_ApplicationNumber);
                ps.setString(3, the_retreived_ApplicationType);
                ps.setString(4, the_retreived_session);
                ps.setString(5, the_retreived_Course_Choice);

                ps.setString(6, the_retreived_Surname);
                ps.setString(7, the_retreived_Orthername);

                ps.setString(8, null);///gender
                ps.setString(9, null);///DOB
                ps.setString(10, null);///PlaceOfBirth
                ps.setString(11, null);///Nationallity
                ps.setString(12, null);///State
                ps.setString(13, null);///lga
                ps.setString(14, null);///HouseAddress
                ps.setString(15, null);///PermanentHomeAddress

                ps.setString(16, the_retreived_phoneno);
                ps.setString(17, the_retreived_email);

                ps.setString(18, null);///Occupation
                ps.setString(19, null);///nextOfKin
                ps.setString(20, null);///Relationship
                ps.setString(21, null);///Relationship

                ps.setString(22, the_retreived_regDate);
                ps.setString(23, serialno);
                ps.setString(24, pinno);
                ps.setString(25, myStatus);//Status
                ps.setString(26, PreEnrollmentMyflag);//Flag
                //ps.setString(27, "now()");//PaymentDate
                ps.setString(27, null);//photo

                ps.executeUpdate();
                rowCount = rowCount + 1;

                if (rowCount > 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Payment  is succeful for: " + the_retreived_ApplicationType.toUpperCase() + " " + the_retreived_Course_Choice.toUpperCase(), ". Please, log into your dashboard and complete STEP 3 - The 'Bio Data Form'. "));
                    ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();

                    //UPDATING THE 'FLAG' from 'PreEnrollment' to 'PostEnrollment'
                    PreparedStatement ps1 = getCn().prepareStatement(" UPDATE application_for_admission SET flag= ? WHERE appno=? ");
                    ps1.setString(1, PostEnrollmentMyflag);
                    ps1.setString(2, appNo);
                    ps1.executeUpdate();

                    // redcontext.redirect("successful_application_for_addmission.xhtml");
                }//end of the if-block

                //clears the variables
            } catch (Exception e) {
                throw e;
            } finally {
                this.Close();//
            }
        }//end of the else block
    }//end of the method 
    
}//end of the method 
