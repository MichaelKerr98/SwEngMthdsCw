package com.napier.db;

import com.napier.reports.CityReport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Initializes the connection and disconnection from the application and database.
 */
public class DatabaseConnector implements DataLayer {

    private Connection con = null;

    /**
     * Method to connect to the MySQL Database.
     */
    @Override
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                Thread.sleep(30_000);
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "supersecurepw");
                System.out.println("Successfully connected..");
                Thread.sleep(5_000);
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Method to disconnect from the MySQL Database.
     */
    @Override
    public void disconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Method which gets a SQL-Statement as a parameter and returns a Set of Results of that statement.
     *
     * @param sql The SQL Statement.
     * @return The Set of Results.
     * @throws SQLException Thrown when the SQL Statements is invalid.
     */
    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        return executeQuery(sql, -1);
    }

    /**
     * Method which gets a SQL-Statement as a parameter and returns a Set of [N] Results of that statement.
     *
     * @param sql The SQL Statement.
     * @param maxRows The limit for the maximum number of Results.
     * @return The Set of Results.
     * @throws SQLException Thrown when the SQL Statements is invalid.
     */
    @Override
    public ResultSet executeQuery(String sql, int maxRows) throws SQLException {
        Statement statement = buildStatement(maxRows);
        return statement.executeQuery(sql);
    }

    private List<CityReport> createCityReport(String sql, int limit) throws SQLException {
        ResultSet resultSet = executeQuery(sql, limit);
        ArrayList<CityReport> reports = new ArrayList<>();
        while (resultSet.next()){
            reports.add(new CityReport(
                    resultSet.getString("Name"),
                    resultSet.getString("Country"),
                    resultSet.getString("District"),
                    resultSet.getInt("Population")));
        }
        return reports;
    }

    private Statement buildStatement(int maxRows) throws SQLException {
        Statement statement = con.createStatement();
        if(maxRows>=0)
            statement.setMaxRows(maxRows);
        return statement;
    }
}
