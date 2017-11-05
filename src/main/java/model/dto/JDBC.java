package model.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class for opening and closing database connection with singleton pattern
 */
public class JDBC {
    private static String connectionDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String connectionUrl = "jdbc:sqlserver://localhost:1433;user=arman;password=123456";
    private static Connection con;

    private JDBC(){}
    private static void loadDriver() {
        try {
            Class.forName(connectionDriver);
        } catch (Exception e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
    }

    private static void loadConnection() {
        try {
            con = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
    }

    public static Connection openConnection() {
        if (con == null) {
            loadDriver();
            loadConnection();
        }
        return con;
    }

    public static void closeConnection() {
        if (con == null) {
            System.out.println("No connection exists");
        } else {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                System.out.println(e.getClass() + ": " + e.getMessage());
            }
        }
    }
}
