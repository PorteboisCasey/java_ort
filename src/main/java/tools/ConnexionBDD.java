package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnexionBDD {
    private static Connection cnx = null;

    static {
        try {
            String pilote = "com.mysql.cj.jdbc.Driver";
            Class.forName(pilote);
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/app_db?useSSL=false&serverTimezone=" + TimeZone.getDefault().getID(), "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getCnx() {
        try {
            if (cnx == null || cnx.isClosed() || !cnx.isValid(0)) {
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/app_db?useSSL=false&serverTimezone=" + TimeZone.getDefault().getID(), "root", "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return cnx;
    }
}
