package COM.ResultLogic.DAO;

import COM.ResultLogic.MODEL.faculty;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class facultyDAO extends DAO {

    public void facultyEnrollmentMthd(faculty fclty) throws Exception {
        this.Connector(); //invoked 
        String dommyDoneBy = "Admin";

        //checking for duplicate entries 
        PreparedStatement st1 = getCn().prepareStatement("select * from faculty where title=? OR code=? ");
        st1.setString(1, fclty.getTitle());
        st1.setString(2, fclty.getCode());
        ResultSet rs = st1.executeQuery();

        if (rs.next()) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "The supplied 'Faculty/School' Name OR Code has been used. Pls, check your entries!", "thank you!"));

        } else {
            /////

            try {

                PreparedStatement ps = getCn().prepareStatement("INSERT INTO faculty VALUES(?, ?,?,?, now(), ?)");

                ps.setString(1, null);
                ps.setString(2, fclty.getTitle());
                ps.setString(3, fclty.getCode());
                ps.setString(4, fclty.getInstituition());
                ps.setString(5, dommyDoneBy);
                int rowCount = ps.executeUpdate();

                if (rowCount > 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The 'Faculty/School' " + fclty.getTitle() + " has been enrolled successfully. Thank you.", ""));
                     
                }//end of the if-block

                //Clearing variables after insertion is done
                fclty.setTitle("");
                fclty.setInstituition("");
                fclty.setCode("");

            } catch (Exception e) {
                throw e;
            } finally {
                this.Close();
            }

            //////
        }

    }//end of the method 

 
}//end of the class
