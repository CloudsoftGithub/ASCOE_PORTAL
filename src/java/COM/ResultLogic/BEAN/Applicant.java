
package COM.ResultLogic.BEAN;

import java.io.Serializable;
 
public class Applicant implements Serializable {
  private static final long serialVersionUID = 1L;
    private int id;
    private String appNo;
    private String the_Course_Choice;
    private String the_Surname;
    private String the_Orthername;
    private String the_email;

    Applicant() {

    }//end of the default constructor 

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

}//end of the class
