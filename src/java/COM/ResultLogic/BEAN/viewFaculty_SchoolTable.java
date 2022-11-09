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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class viewFaculty_SchoolTable extends DAO {

    PreparedStatement ps;
    ResultSet rs;

    private int id;
    private String title;
    private String code;
    private String instituition;
    
    private String dateregistered;
    private String doneBy;

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

    public String getInstituition() {
        return instituition;
    }

    public void setInstituition(String instituition) {
        this.instituition = instituition;
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

    
    
    public List<viewFaculty_SchoolTable> getEnrolledFaculty_School() throws Exception {
        this.Connector();

        List<viewFaculty_SchoolTable> faculty_schoo_info = new ArrayList<viewFaculty_SchoolTable>();

        try {

            ps = this.getCn().prepareStatement("select * from faculty");
            rs = ps.executeQuery();
            
            while(rs.next()){
                viewFaculty_SchoolTable tbl = new viewFaculty_SchoolTable();
                tbl.setId(rs.getInt("id"));
                tbl.setTitle(rs.getString("title"));
                tbl.setCode(rs.getString("code"));
                tbl.setInstituition(rs.getString("instituition"));
                tbl.setDateregistered(rs.getString("dateregistered"));
                tbl.setDoneBy(rs.getString("doneBy"));
                
                faculty_schoo_info.add(tbl);
            }

        } catch (Exception e) {
            throw e;
        }finally{
            this.Close();
        }

        return faculty_schoo_info;

    }//end of the method

}//end of the class
