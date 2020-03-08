package com.napier.db;

import com.napier.reports.CityReport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
     * Method that returns a ordered List of CityReports of a specific district.
     *
     * @param district The name of the district.
     * @param limit    The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CityReports of a specific district.
     * @throws SQLException Thrown when there is an database access error.
     */
    List<CityReport> getCitiesInADistrictOrganizedByLargestToSmallestPopulation(String district, int limit) throws SQLException;

    /**
     * Method that returns a ordered List of CityReports of a specific continent.
     *
     * @param continent The name of the continent.
     * @param limit    The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CityReports of a specific continent.
     * @throws SQLException Thrown when there is an database access error.
     */
    List<CityReport> getCitiesInAContinentOrganizedByLargestToSmallestPopulation(String continent, int limit) throws SQLException;

}
