package COM.ResultLogic.BEAN;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ApplicantsBEAN {
private String replaceCourseChoice;
    private int id;
    private String appNo;

    private String Course_Choice;
    private String Course_admitted;
    private String Surname;
    private String Orthername;
    private String email;
    private String phone;

    private String AppType;
    private String Session;
    private String DOB;
    private String PlaceOfBirth;
    private String Nationality;
    private String State;
    private String Lga;
    private String Permanent_home_address;

    private List<String> couse_choiseList = new ArrayList<>();
    private List<String> couse_admittedList = new ArrayList<>();

    public ArrayList ApplicantListFromDB;
     public ArrayList AdmissionListFromDB;
    private boolean edit = false;

    private String Course_Admitted;
    //generated sestters and getters  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getCourse_Choice() {
        return Course_Choice;
    }

    public void setCourse_Choice(String Course_Choice) {
        this.Course_Choice = Course_Choice;
    }

    public String getCourse_admitted() {
        return Course_admitted;
    }

    public void setCourse_admitted(String Course_admitted) {
        this.Course_admitted = Course_admitted;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getOrthername() {
        return Orthername;
    }

    public void setOrthername(String Orthername) {
        this.Orthername = Orthername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getCouse_choiseList() {
        return couse_choiseList;
    }

    public void setCouse_choiseList(List<String> couse_choiseList) {
        this.couse_choiseList = couse_choiseList;
    }

    public List<String> getCouse_admittedList() {
        return couse_admittedList;
    }

    public void setCouse_admittedList(List<String> couse_admittedList) {
        this.couse_admittedList = couse_admittedList;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public String getSession() {
        return Session;
    }

    public void setSession(String Session) {
        this.Session = Session;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPlaceOfBirth() {
        return PlaceOfBirth;
    }

    public void setPlaceOfBirth(String PlaceOfBirth) {
        this.PlaceOfBirth = PlaceOfBirth;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getLga() {
        return Lga;
    }

    public void setLga(String Lga) {
        this.Lga = Lga;
    }

    public String getPermanent_home_address() {
        return Permanent_home_address;
    }

    public void setPermanent_home_address(String Permanent_home_address) {
        this.Permanent_home_address = Permanent_home_address;
    }

    public String getAppType() {
        return AppType;
    }

    public void setAppType(String AppType) {
        this.AppType = AppType;
    }

    public String getCourse_Admitted() {
        return Course_Admitted;
    }

    public void setCourse_Admitted(String Course_Admitted) {
        this.Course_Admitted = Course_Admitted;
    }

    public String getReplaceCourseChoice() {
        return replaceCourseChoice;
    }

    public void setReplaceCourseChoice(String replaceCourseChoice) {
        this.replaceCourseChoice = replaceCourseChoice;
    }

    
    //Some method needed for our operations
    @PostConstruct
    public void init() {
    try {
        ApplicantListFromDB = ApplicantsDatabaseOperationsBEAN.getApplicantListFromDB();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(ApplicantsBEAN.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(ApplicantsBEAN.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        AdmissionListFromDB = ApplicantsDatabaseOperationsBEAN.getAdmissionListFromDB();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(ApplicantsBEAN.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(ApplicantsBEAN.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//

    //invoke other methods from the 'ApplicantsDatabaseOperationsBEAN' Class for studentBEAN
    public ArrayList applicantsListMthd() {

        return ApplicantListFromDB;
    }//end of the method 
    
    public ArrayList admissionListMthd(){
        return AdmissionListFromDB;
    }//end of the method 
 
      public String editApplicantRecord(int ApplicantId) throws ClassNotFoundException, SQLException{
          
          return ApplicantsDatabaseOperationsBEAN.editApplicantRecordInDB(ApplicantId);
      }//end of the class
    
    public String updateApplicantsDetailsInDB(ApplicantsBEAN updateApplicantObj) throws ClassNotFoundException, SQLException{
        return ApplicantsDatabaseOperationsBEAN.updateApplicantsDetailsInDB(updateApplicantObj);
    }//end of the method 

      public String replaceCourseChoiceForApplicantsDetailsInDB(ApplicantsBEAN updateApplicantObj) throws ClassNotFoundException, SQLException{
        
        return ApplicantsDatabaseOperationsBEAN.replaceWithThisCourseInDB(updateApplicantObj);
    }//end of the method 

      
      
}//end of the class
