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

    private static String SELECT_CITY = "SELECT c.name, c.population, c.district, cn.name as country\n";
    private static String FROM_CITY_C_AND_COUNTRY_CN_TABLE = "FROM city c, country cn\n";
    private static String WHERE_CN_CC_EQUALS_C_CC = "WHERE cn.code = c.countrycode\n";
    public static String DESC_ORDER = "ORDER BY c.population DESC;\n";
    public static String SELECT_CITY_FROM_CITY_COUNTRY_WHERE_COUNTRYCODE = SELECT_CITY + FROM_CITY_C_AND_COUNTRY_CN_TABLE + WHERE_CN_CC_EQUALS_C_CC;


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
     * Method that returns a ordered List of CityReports of a specific district.
     *
     * @param district The name of the district.
     * @param limit    The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CityReports of a specific district.
     * @throws SQLException Thrown when there is an database access error.
     */
    @Override
    public List<CityReport> getCitiesInADistrictOrganizedByLargestToSmallestPopulation(String district, int limit) throws SQLException {
        return createCityReport(SELECT_CITY_FROM_CITY_COUNTRY_WHERE_COUNTRYCODE +
                "AND c.district = '"+ district+"'\n" +
                DESC_ORDER,limit);
    }

    /**
     * Method that returns a ordered List of CityReports of a specific continent.
     *
     * @param continent The name of the continent.
     * @param limit    The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CityReports of a specific continent.
     * @throws SQLException Thrown when there is an database access error.
     */
    @Override
    public List<CityReport> getCitiesInAContinentOrganizedByLargestToSmallestPopulation(String continent, int limit) throws SQLException {
        return createCityReport(SELECT_CITY_FROM_CITY_COUNTRY_WHERE_COUNTRYCODE +
                "AND cn.continent = '"+ continent+"'\n" +
                DESC_ORDER,limit);
    }

    /**
     * Method that returns a ordered List of CityReports of a specific region.
     *
     * @param region The name of the region.
     * @param limit    The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CityReports of a specific region.
     * @throws SQLException Thrown when there is an database access error.
     */
    public List<CityReport> getCitiesInARegionOrganisedByLargestToSmallestPopulation(String region, int limit) throws SQLException {
        return createCityReport(SELECT_CITY_FROM_CITY_COUNTRY_WHERE_COUNTRYCODE +
                "AND cn.region = '"+ region+"'\n" +
                DESC_ORDER,limit);
    }

    /**
     * Method that returns a ordered List of CityReports of a specific country.
     *
     * @param country The name of the country.
     * @param limit    The limit (if limit < 0, limit will be ignored.)
     * @return Ordered List of CityReports of a specific country.
     * @throws SQLException Thrown when there is an database access error.
     */
    public List<CityReport> getCitiesInACountryOrganisedByLargestToSmallestPopulation(String country, int limit) throws SQLException{
        return createCityReport(SELECT_CITY_FROM_CITY_COUNTRY_WHERE_COUNTRYCODE +
                "AND cn.name = '"+country+"'\n" +
                DESC_ORDER, limit);
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

    private ResultSet executeQuery(String sql, int maxRows) throws SQLException {
        Statement statement = buildStatement(maxRows);
        return statement.executeQuery(sql);
    }

    private Statement buildStatement(int maxRows) throws SQLException {
        Statement statement = con.createStatement();
        if(maxRows>=0)
            statement.setMaxRows(maxRows);
        return statement;
    }
}
