package ch09_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDemo {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/testdb"; // database name
    private static final String DB_USER = "jwbook";                 // user id
    private static final String DB_PASSWORD = "1234";               // passward

    public static void main(String[] args) {
        try {
           // DeleteDbFiles.execute("~", "testdb", true); // drop db if exist 'testdb'
            initDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private static void initDB() throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            // create TEST_TABLE for example
            stmt.execute("CREATE TABLE TEST_TABLE(idx INT PRIMARY KEY, name VARCHAR(100));");
            
            // insert some values into TEST_TABLE
            stmt.execute("INSERT INTO TEST_TABLE VALUES(1, 'Martin.Park'), (2, 'OskarDevelopers');");
             
            // get result by using SELECT query
            ResultSet rs = stmt.executeQuery("SELECT * FROM TEST_TABLE;");
            while (rs.next()) {
                System.out.println("idx : " + rs.getString("idx") + " / " + "name : " + rs.getString("name"));
            }
            
            stmt.close();
            connection.commit();
            
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}