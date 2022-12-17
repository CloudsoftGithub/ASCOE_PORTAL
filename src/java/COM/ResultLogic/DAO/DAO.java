package COM.ResultLogic.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO implements Serializable {

    private Connection cn;

    private PreparedStatement ps;

    public static boolean login(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Connection getCn() {
        return this.cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void Connector() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Class.forName("com.mysql.jdbc.Driver");
           //cn = (Connection) DriverManager.getConnection("jdbc:mysql://node141231-ascoekd.w1-us.cloudjiffy.net/resultlogic", "root", "YLYhho19451");

             cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resultlogic?user=root&password=ash123");
        } catch (Exception e) {
            System.out.println("Error in login/Connecting() -->" + e.getMessage());
            throw e;
        } finally {
        }
    }

    public void Close() throws Exception {
        try {
            if (!this.cn.isClosed()) {
                this.cn.close();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cn.close();
            //this.ps.close();
        }
    }
}
