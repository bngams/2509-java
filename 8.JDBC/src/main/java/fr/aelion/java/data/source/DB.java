package fr.aelion.java.data.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static Connection conn;

    // constant
    private static final String CONN_STRING = "jdbc:mysql://10.95.31.178:3366/appdb?" +
            "user=user&password=password";

    public static Connection getConn() throws Exception {
        if(conn != null) {
            return conn;
        } else {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://10.95.31.178:3366/appdb?" +
                                "user=user&password=password");
                return conn;
            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                throw new Exception("DB connection exception");
            }
        }
    }
}
