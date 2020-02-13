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
     * @return returns a Set of Results.
     * @throws SQLException when the SQL Statements is invalid.
     */
    ResultSet executeSQLStatement(String sql) throws SQLException;

    /**
     *
     * @param sql
     * @param maxRows
     * @return
     * @throws SQLException
     */
    ResultSet executeSQLStatement(String sql, int maxRows) throws SQLException;
}
