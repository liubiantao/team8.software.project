package database;

/**
 * @author Tommy
 */

import java.sql.*;

public class DbManager {
    private Connection connection;
    private Statement statement;

    /**
     * Connects to the MySQl database using the URL, username and password.
     */
    public void connect() {
        String URL = "jdbc:mysql://localhost:3306/scdb?zeroDateTimeBehavior=convertToNull";
        String username = "root";
        String password = "1l2mmatt";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e) {
            System.err.println("Failed to load JDCB driver "
                                +e .getMessage());
        }
       
        try {
            connection = DriverManager.getConnection(URL, username, 
                                                     password);
        }
        catch(SQLException e) {
            System.err.println("Problem with setting up " + URL
                                + e.getMessage());
        }
    }
    
     /**
     * Connects to the MySQl database using the a supplied URL, username and password.
     * 
     * @param URL      the URL for the database
     * @param username the username for the database
     * @param password the password used for the database
     */
    public void connect(String URL, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e) {
            System.err.println("Failed to load JDCB driver "
                                +e .getMessage());
        }

        try {
            connection = DriverManager.getConnection(URL, username, 
                                                     password);
        }
        catch(SQLException e) {
            System.err.println("Problem with setting up " + URL
                                + e.getMessage());
        }
    }
    
    /**
     * Closes the connection
     */
    public void disconnect() {
        try {
            connection.close();
        }
        catch(SQLException e) {
            System.err.println("Problem disconnecting from the MySQL database "
                                +e.getMessage());
        }
    }
    
    /**
     * Queries the database and returns a Resultset
     * 
     * @param query a MySQL query
     * @return      a ResultSet with the result data
     */
    public ResultSet query(String query) {
       ResultSet result = null;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(query);
        }
        catch (SQLException e) {
            System.err.println("Cannot execute query from DbManger " 
                                + e.getMessage());
        }
        finally {
            return result;
        }
    }
    
    /**
     * Executes an update to a Database
     * 
     * @param query a MySQL query 
     */
    public void update(String query) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException e) {
            System.err.println("Cannot execute update from DbManger " 
                                + e.getMessage());
        }
    }
}
