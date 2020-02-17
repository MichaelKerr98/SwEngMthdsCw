package com.napier.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The DataLayer-Interface.
 */
public interface DataLayer {

    /**
     * Method to connect to the MySQL Database.
     */
    void connect();

    /**
     * Method to disconnect to the MySQL Database.
     */
    void disconnect();

    /**
     * Method which gets a SQL-Statement as a parameter and returns a Set of Results of that statement.
     *
     * @param sql The SQL Statement.
     * @return The Set of Results.
     * @throws SQLException Thrown when the SQL Statements is invalid.
     */
    ResultSet executeQuery(String sql) throws SQLException;

    /**
     * Method which gets a SQL-Statement as a parameter and returns a Set of [N] Results of that statement.
     *
     * @param sql The SQL Statement.
     * @param maxRows The limit for the maximum number of Results.
     * @return The Set of Results.
     * @throws SQLException Thrown when the SQL Statements is invalid.
     */
    ResultSet executeQuery(String sql, int maxRows) throws SQLException;
}