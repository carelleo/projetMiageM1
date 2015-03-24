package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBDD {

    private static String url = "jdbc:mysql://localhost/bdd_copromanager";
    private static String user = "root";
    private static String passwd = "";

    private static Connection c;

    public static Connection getConnection() {

        if (c == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                
                c = DriverManager.getConnection(url, user, passwd);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return c;
    }
}
