/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM.ResultLogic.BEAN;

import COM.ResultLogic.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class viewDepartmentTable extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    private int id;
    private String title;
    private String code;
    private String faculty;

    private String dateregistered;
    private String doneBy;

    private List<String> DepartmentCodeList = new ArrayList<>();

    public List<String> getDepartmentCodeList() {
        return DepartmentCodeList;
    }

    public void setDepartmentCodeList(List<String> DepartmentCodeList) {
        this.DepartmentCodeList = DepartmentCodeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDateregistered() {
        return dateregistered;
    }

    public void setDateregistered(String dateregistered) {
        this.dateregistered = dateregistered;
    }

    public String getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }

    public List<String> getDepartmentsMthd() throws Exception {

        DepartmentCodeList.removeAll(DepartmentCodeList);

        this.Connector();

        try {

            ps = this.getCn().prepareStatement("SELECT code FROM department ");
            rs = ps.executeQuery();

            while (rs.next()) {
                DepartmentCodeList.add(rs.getString("code"));//retrieves all the  ..
            }//end of while-block

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Department Code Error", e.getMessage() + " . Pls, try again"));

        } finally {
            this.Close();
        }

        return DepartmentCodeList;

    }//end of method

    public List<viewDepartmentTable> getEnrolledDpartment() throws Exception {
        
       getDepartmentsMthd();//invoked 
       
        this.Connector();

        List<viewDepartmentTable> depart_info = new ArrayList<viewDepartmentTable>();

        try {

            ps = this.getCn().prepareStatement("select * from department WHERE code=? ");
            ps.setString(1, code);
            rs = ps.executeQuery();

            while (rs.next()) {
                viewDepartmentTable tbl = new viewDepartmentTable();
                tbl.setId(rs.getInt("id"));
                tbl.setTitle(rs.getString("title"));
                tbl.setCode(rs.getString("code"));
                tbl.setDateregistered(rs.getString("dateregistered"));
                tbl.setDoneBy(rs.getString("doneBy"));

                depart_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

        return depart_info;

    }//end of the method
    
        public void goViewDepartmentsMthd() throws Exception {
        getEnrolledDpartment();//invoked

    }//end of the the method 

}//end of the class

