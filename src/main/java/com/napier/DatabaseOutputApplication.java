package com.napier;

import com.napier.reports.CityReport;

import java.sql.SQLException;
import java.util.List;

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

        List<CityReport> cityReports = connector.getCitiesInADistrictOrganizedByLargestToSmallestPopulation("Yeeet",5);
        for(CityReport cityReport : cityReports)
            System.out.println(cityReport);
        connector.disconnect();
    }
}