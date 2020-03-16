package com.napier;

import com.napier.reports.CityReport;
import com.napier.reports.CountryReport;

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

        List<CityReport> cityReports = connector.getCitiesInADistrictOrganizedByLargestToSmallestPopulation("Gelderland",5);
        for(CityReport cityReport : cityReports)
            System.out.println(cityReport);

        System.out.println("Continent");
        List<CountryReport> countryReports = connector.getCountriesInAContinentOrganizedByLargestToSmallestPopulation("South America", 4);
        for(CountryReport countryReport : countryReports)
            System.out.println(countryReport);

        System.out.println("World");
        List<CountryReport> countryReportsIntWorld = connector.getCountriesInTheWorldOrganizedByLargestToSmallestPopulation( 4);
        for(CountryReport countryReport : countryReportsIntWorld)
            System.out.println(countryReport);
        connector.disconnect();
    }
}