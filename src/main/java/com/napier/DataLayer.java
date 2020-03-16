package com.napier;

import com.napier.reports.CapitalCityReport;
import com.napier.reports.CityReport;
import com.napier.reports.CountryReport;

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

    /**
     * Method that returns a ordered List of CityReports of a specific region.
     *
     * @param region The name of the region.
     * @param limit    The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CityReports of a specific region.
     * @throws SQLException Thrown when there is an database access error.
     */
    List<CityReport> getCitiesInARegionOrganisedByLargestToSmallestPopulation(String region, int limit) throws SQLException;

    /**
     * Method that returns a ordered List of CityReports of a specific country.
     *
     * @param country The name of the country.
     * @param limit    The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CityReports of a specific country.
     * @throws SQLException Thrown when there is an database access error.
     */
    List<CityReport> getCitiesInACountryOrganisedByLargestToSmallestPopulation(String country, int limit) throws SQLException;

    /**
     * Method that returns a ordered List of CityReports of the world.
     *
     * @param limit The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CityReports of the world.
     * @throws SQLException Thrown when there is an database access error.
     */
    List<CityReport> getCitiesInTheWorldOrganizedByLargestToSmallestPopulation(int limit) throws SQLException;

    /**
     * Method that returns a ordered List of CountryReports of a specific region.
     *
     * @param region The name of the region.
     * @param limit The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CountryReport of a specific region.
     * @throws SQLException Thrown when there is an database access error.
     */
    List<CountryReport> getCountriesInARegionOrganizedByLargestToSmallestPopulation(String region, int limit) throws SQLException;

    /**
     * Method that returns a ordered List of CountryReports of a specific continent.
     *
     * @param continent The name of the continent.
     * @param limit The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CountryReport of a specific continent.
     * @throws SQLException Thrown when there is an database access error.
     */
    List<CountryReport> getCountriesInAContinentOrganizedByLargestToSmallestPopulation(String continent, int limit) throws SQLException;

    /**
     * Method that returns a ordered List of CountryReports of the world.
     *
     * @param limit The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CountryReports of the world.
     * @throws SQLException Thrown when there is an database access error.
     */
    List<CountryReport> getCountriesInTheWorldOrganizedByLargestToSmallestPopulation(int limit) throws SQLException;

    /**
     * Method that returns an ordered List of CapitalCityReports of a region.
     *
     * @param region The name of the region.
     * @param limit The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CapitalCityReports of a specific region
     * @throws SQLException Thrown when there is an database access error.
     */
    List<CapitalCityReport> getCapitalCitiesInARegionOrganizedByLargestToSmallestPopulation(String region, int limit) throws SQLException;

    /**
     * Method that returns an ordered list of CapitalCityReports of a specific continent.
     *
     * @param continent The name of the continent.
     * @param limit The limit (if limit < 0, limit will be ignored.)
     * @return Ordered list of CapitalCityReport of a specific continent.
     * @throws SQLException Thrown when there is an database access error.
     */
    List<CapitalCityReport> getCapitalCitiesInAContinentOrganizedByLargestToSmallestPopulation(String continent, int limit) throws SQLException;

    /**
     * Method that returns an ordered List of CapitalCityReports of the world
     *
     * @param limit The limit (if limit < 0, limit will be ignored.
     * @return Ordered list of CapitalCityReports of the world.
     * @throws SQLException Thrown when there is an database access error.
     */
    List<CapitalCityReport> getCapitalCitiesInTheWorldOrganizedByLargestToSmallestPopulation(int limit) throws SQLException;
}