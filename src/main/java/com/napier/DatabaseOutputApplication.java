package com.napier;

import com.napier.db.DataLayer;
import com.napier.db.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The MainApplication.
 */
public class DatabaseOutputApplication {
    /**
     * Starts the Application.
     * @param args The arguments.
     * @throws SQLException is thrown if an invalid SQL-Statement is executed.
     */
    public static void main(String[] args) throws SQLException {
        DataLayer connector = new DatabaseConnector();
        connector.connect();

        ResultSet resultSet = connector.executeQuery(
                "SELECT country.name, country.population "
                        + "FROM country "
                        + "ORDER BY country.population DESC",
                5);
        while (resultSet.next()){
            System.out.println(resultSet.getString("country.name")+ " "
                    + resultSet.getString("country.population"));
        }
        connector.disconnect();
    }
}