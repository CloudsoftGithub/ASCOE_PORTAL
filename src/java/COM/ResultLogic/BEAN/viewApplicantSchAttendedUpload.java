/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class viewApplicantSchAttendedUpload extends DAO implements Serializable {
 
    PreparedStatement ps;
    ResultSet rs;

    private int id;

    private String schoolAttendedName;
    private String appNo;
    private String uploadDate;
    private String from;
    private String to;
    private String certTitle;
    private StreamedContent Cert_file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolAttendedName() {
        return schoolAttendedName;
    }

    public void setSchoolAttendedName(String schoolAttendedName) {
        this.schoolAttendedName = schoolAttendedName;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCertTitle() {
        return certTitle;
    }

    public void setCertTitle(String certTitle) {
        this.certTitle = certTitle;
    }

    public StreamedContent getCert_file() {
        return Cert_file;
    }

    public void setCert_file(StreamedContent Cert_file) {
        this.Cert_file = Cert_file;
    }

    //RETRIEVING VALUES for 'Matric no' FROM THE UI
    public void retriveAppNoFromUI() {//get the current 'AppNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        appNo = ec.getRequestParameterMap().get("studentRegForm:applicant_app_no_from_UI");
    }//end of method

    public List<viewApplicantSchAttendedUpload> getApplicantSchAttendedInfo() throws Exception {
        retriveAppNoFromUI();//invokes the AppNo method

        this.Connector();

        List<viewApplicantSchAttendedUpload> app_sch_attended_info = new ArrayList<viewApplicantSchAttendedUpload>();
        
        try {

            ps = this.getCn().prepareStatement("select * from applicant_upload_sch_attended WHERE appno=? order by id ");//AND session=?
            ps.setString(1, appNo);

            rs = ps.executeQuery();
 
            while (rs.next()) {
                viewApplicantSchAttendedUpload tbl = new viewApplicantSchAttendedUpload();

                tbl.setId(rs.getInt("id"));
                tbl.setAppNo(rs.getString("appno"));
                tbl.setUploadDate(rs.getString("uploadDate"));
                tbl.setSchoolAttendedName(rs.getString("sch_name"));
                tbl.setFrom(rs.getString("from"));
                tbl.setTo(rs.getString("to"));
                tbl.setCertTitle(rs.getString("cert_title"));
                //tbl.setAppNo(rs.getString("appno"));
                //InputStream stream = this.rs.getBinaryStream("cert_upload");
              // Cert_file = (StreamedContent) new DefaultStreamedContent();
 
                app_sch_attended_info.add(tbl);

             
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return app_sch_attended_info;

    }//end of the 

    ////DELETING/REMOVING School attended from THE UPLOADED AREA
    public void removeSch_attended_WithCommandLink(String ApplicationNo) throws Exception {
        this.Connector();//establishes connectdion from the DAO Class (i.e the super class)

        retriveAppNoFromUI();//invokes the AppNo method

        try {

            ps = this.getCn().prepareStatement("DELETE FROM applicant_upload_sch_attended WHERE appno =? ");//
            ps.setString(1, appNo);

            ps.executeUpdate();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Certificate Title: ' " + certTitle + " has been DELETED. Thank you.", ""));

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
            ps.close();
        }//end of finally-block

    }//end of method
}//end of the class 
