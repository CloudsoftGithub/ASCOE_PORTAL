package COM.ResultLogic.BEAN;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class StudentBean {

    private int id;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String address;

    private List<String> couse_choiseList = new ArrayList<>();

    public ArrayList studentsListFromDB;
    private boolean edit = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getCouse_choiseList() {
        return couse_choiseList;
    }

    public void setCouse_choiseList(List<String> couse_choiseList) {
        this.couse_choiseList = couse_choiseList;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    
    @PostConstruct
    public void init() {
        studentsListFromDB = DatabaseOperation.getStudentsListFromDB();
    }//end of the method

    //invoke other methods from the 'DatabaseOperation' Class for studentBEAN
    public ArrayList studentsList() {
        return studentsListFromDB;
    }//end of the method

    public String saveStudentDetails(StudentBean newStudentObj) {
        return DatabaseOperation.saveStudentDetailsInDB(newStudentObj);
    }//end of the method

    public String editStudentRecord(int studentId) {

        return DatabaseOperation.editStudentRecordInDB(studentId);

    }//end of the method

    public String updateStudentDetails(StudentBean updateStudentObj) {
        return DatabaseOperation.updateStudentDetailsInDB(updateStudentObj);
    }//end of the method

    public String deleteStudentRecord(int studentId) {
        return DatabaseOperation.deleteStudentRecordInDB(studentId);
    }//end of the method

}//end of the class

