package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ApplicantEditDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Connection connection;
    PreparedStatement ps;
    ResultSet rs;

    public void Connector() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://node141231-ascoekd.w1-us.cloudjiffy.net/resultlogic", "root", "YLYhho19451");

            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resultlogic?user=root&password=ash123");

        } catch (Exception e) {
            System.out.println("Error in Connecting() -->" + e.getMessage());
            throw e;
        } finally {
        }
    }

    public void editRow(Applicant applcnt, String appNum) throws Exception {

        try {
            ps = connection.prepareStatement(" UPDATE application_for_admission SET course_choice=?  WHERE appno=? ");
            ps.setString(1, applcnt.getThe_Course_Choice());
            ps.setString(2, appNum);
            ps.executeUpdate();

            System.err.println("Sample Outputs: " + applcnt.getThe_Course_Choice() + "AppNo:" + applcnt.getAppNo());

        } catch (Exception e) {
            e.getMessage();
        } finally {
            connection.close();
        }

    }//end of the method

}//end of the class
