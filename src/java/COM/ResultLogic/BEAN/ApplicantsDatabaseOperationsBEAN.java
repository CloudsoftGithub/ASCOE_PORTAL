package COM.ResultLogic.BEAN;

import static COM.ResultLogic.BEAN.DatabaseOperation.connObj;
import static COM.ResultLogic.BEAN.DatabaseOperation.getConnection;
import static COM.ResultLogic.BEAN.DatabaseOperation.pstmt;
import static COM.ResultLogic.BEAN.DatabaseOperation.resultSetObj;
import static COM.ResultLogic.BEAN.DatabaseOperation.stmtObj;
import COM.ResultLogic.DAO.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ApplicantsDatabaseOperationsBEAN {

    public static Statement stmtObj;
    public static Connection connObj = null;
    public static ResultSet resultSetObj;
    public static PreparedStatement pstmt;

    public static Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          // connObj = (Connection) DriverManager.getConnection("jdbc:mysql://node141231-ascoekd.w1-us.cloudjiffy.net/resultlogic", "root", "YLYhho19451");

            connObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/resultlogic?user=root&password=ash123");
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:" + e.getMessage(), ""));
        }
        return connObj;
    }

    public static ArrayList getApplicantListFromDB() throws ClassNotFoundException, SQLException {

        ArrayList applicantsList = new ArrayList();
        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("select * from application_for_admission ");
            while (resultSetObj.next()) {
                ApplicantsBEAN applicantObj = new ApplicantsBEAN();
                applicantObj.setId(resultSetObj.getInt("id"));
                applicantObj.setAppNo(resultSetObj.getString("appno"));
                applicantObj.setAppType(resultSetObj.getString("app_type"));
                applicantObj.setSession(resultSetObj.getString("session"));
                applicantObj.setCourse_Choice(resultSetObj.getString("course_choice"));
                applicantObj.setCourse_admitted(resultSetObj.getString("course_admitted"));
                applicantObj.setSurname(resultSetObj.getString("surname"));
                applicantObj.setOrthername(resultSetObj.getString("orther"));
                applicantObj.getState();
                applicantsList.add(applicantObj);
            }

            System.out.println("Total Records Fetched: " + applicantsList.size());
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:" + e.getMessage(), ""));
        } finally {
            connObj.close();
        }
        return applicantsList;
    }

    public static ArrayList getAdmissionListFromDB() throws ClassNotFoundException, SQLException {
        ArrayList applicantsList = new ArrayList();
        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("select * from admission_list order by session desc, appno asc ");
            while (resultSetObj.next()) {
                ApplicantsBEAN applicantObj = new ApplicantsBEAN();
                applicantObj.setId(resultSetObj.getInt("id"));
                applicantObj.setAppNo(resultSetObj.getString("appno"));
                applicantObj.setSession(resultSetObj.getString("session"));
                applicantObj.setSurname(resultSetObj.getString("surname"));
                applicantObj.setOrthername(resultSetObj.getString("orther"));
                applicantObj.setDOB(resultSetObj.getString("DOB"));

                applicantObj.setPhone(resultSetObj.getString("phoneno"));
                applicantObj.setEmail(resultSetObj.getString("email"));
                applicantObj.setState(resultSetObj.getString("state"));
                applicantObj.setLga(resultSetObj.getString("lga"));
                applicantObj.setCourse_admitted(resultSetObj.getString("course_admitted"));

                applicantObj.getState();
                applicantsList.add(applicantObj);
            }
            System.out.println("Total Records Fetched: " + applicantsList.size());
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:" + e.getMessage(), ""));
        } finally {
            connObj.close();
        }
        return applicantsList;
    }

    public static String editApplicantRecordInDB(int applicantId) throws ClassNotFoundException, SQLException {
        ApplicantsBEAN editRecord = null;
        System.out.println("editApplicantRecordInDB() : App  AppNo: " + applicantId);

        /* Setting The Particular Applicant Details In Session */
        Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("select * from application_for_admission where id = " + applicantId);
            if (resultSetObj != null) {
                resultSetObj.next();
                System.err.println("AppNOTest: " + applicantId);
                editRecord = new ApplicantsBEAN();//instanciation for the 'ApplicantsBEAN' class obj

                editRecord.setId(resultSetObj.getInt("id"));
                editRecord.setAppNo(resultSetObj.getString("appno"));
                editRecord.setSession(resultSetObj.getString("session"));
                editRecord.setSurname(resultSetObj.getString("surname"));
                editRecord.setOrthername(resultSetObj.getString("orther"));
                editRecord.setAppType(resultSetObj.getString("app_type"));

                editRecord.setCourse_Choice(resultSetObj.getString("course_choice"));
                editRecord.setCourse_admitted(resultSetObj.getString("course_admitted"));

            }
            sessionMapObj.put("editRecordObj", editRecord);
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:" + e.getMessage(), ""));
        } finally {
            connObj.close();
        }
        return "/applicantAdmissionDecision.xhtml?faces-redirect=true";

    }//end of the method

    public static String updateApplicantsDetailsInDB(ApplicantsBEAN updateApplicantObj) throws ClassNotFoundException, SQLException {
        try {
            pstmt = getConnection().prepareStatement(" UPDATE application_for_admission SET course_admitted=course_choice WHERE id=? ");
            pstmt.setInt(1, updateApplicantObj.getId());
            System.err.println("course_admitted:" + updateApplicantObj.getId());
            pstmt.executeUpdate();

            //COPYING THE INFORMATION FOR ADMITTED APPLICANT INTO A TABLE CALLED 'ADMISSION_LIST'            
            pstmt = getConnection().prepareStatement(" INSERT INTO admission_list SELECT * FROM application_for_admission WHERE id=? ");
            pstmt.setInt(1, updateApplicantObj.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:" + e.getMessage(), ""));
        } finally {
            connObj.close();
        }

        return "/view_applicant_list.xhtml?faces-redirect=true";

    }//end of the method

    public static String replaceWithThisCourseInDB(ApplicantsBEAN updateApplicantObj) throws ClassNotFoundException, SQLException {
        try {
            //pstmt = getConnection().prepareStatement(" UPDATE application_for_admission SET course_admitted=course_choice WHERE id=? ");
            pstmt = getConnection().prepareStatement(" UPDATE application_for_admission SET course_admitted=? WHERE id=? ");

            pstmt.setString(1, updateApplicantObj.getReplaceCourseChoice());
            pstmt.setInt(2, updateApplicantObj.getId());
            System.err.println("course_admitted:" + updateApplicantObj.getId());

            pstmt.executeUpdate();

            //COPYING THE INFORMATION FOR ADMITTED APPLICANT INTO A TABLE CALLED 'ADMISSION_LIST'            
            pstmt = getConnection().prepareStatement(" INSERT INTO admission_list SELECT * FROM application_for_admission WHERE id=? ");
            pstmt.setInt(1, updateApplicantObj.getId());
            pstmt.executeUpdate();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Applicant Admitted into ", updateApplicantObj.getCourse_Choice() + " . "));

        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:" + e.getMessage(), ""));
        } finally {
            connObj.close();
        }

        return "/view_applicant_list.xhtml?faces-redirect=true";

    }//end of the method

}//end of the class

