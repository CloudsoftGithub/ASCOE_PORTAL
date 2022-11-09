/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ashiru
 */
@ManagedBean
@ViewScoped
public class ApplicantEditDatatableBEAN implements Serializable{

    private int id;
    private String appNo;
    private String the_Course_Choice;
    private String the_Surname;
    private String the_Orthername;
    private String the_email;
    private List<String> ApplicantDetailsList = new ArrayList<>();

    
    private boolean edit = false;

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

    public String getThe_Course_Choice() {
        return the_Course_Choice;
    }

    public void setThe_Course_Choice(String the_Course_Choice) {
        this.the_Course_Choice = the_Course_Choice;
    }

    public String getThe_Surname() {
        return the_Surname;
    }

    public void setThe_Surname(String the_Surname) {
        this.the_Surname = the_Surname;
    }

    public String getThe_Orthername() {
        return the_Orthername;
    }

    public void setThe_Orthername(String the_Orthername) {
        this.the_Orthername = the_Orthername;
    }

    public String getThe_email() {
        return the_email;
    }

    public void setThe_email(String the_email) {
        this.the_email = the_email;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public List<String> getApplicantDetailsList() {
        return ApplicantDetailsList;
    }

    public void setApplicantDetailsList(List<String> ApplicantDetailsList) {
        this.ApplicantDetailsList = ApplicantDetailsList;
    }
    
     
    @PostConstruct
    public void init() {

        //ApplicantDetailsList = ApplicantListOperation.get
    }//end of the method 
}//end of the class
