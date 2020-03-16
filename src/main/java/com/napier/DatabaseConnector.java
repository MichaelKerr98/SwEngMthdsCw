package com.napier;

import com.napier.reports.CapitalCityReport;
import com.napier.reports.CityReport;
import com.napier.reports.CountryReport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Initializes the connection and disconnection from the application and database.
 */
public class DatabaseConnector implements DataLayer {

    private Connection con = null;

    private static String SELECT_CAPITAL_CITY_REPORT = "SELECT city.name AS Capital, country.name AS Country, city.population\n";
    private static String FROM_CITY = "FROM city\n";
    private static String JOIN_COUNTRY = "JOIN country ON city.id=country.capital";
    private static String SELECT_CAPITAL_CITY_REPORT_FROM_CITY = SELECT_CAPITAL_CITY_REPORT + FROM_CITY + JOIN_COUNTRY;

    private static String SELECT_COUNTRY_REPORT = "SELECT cn.code, cn.name, cn.continent, cn.region, cn.population, cn.capital\n";
    private static String FROM_COUNTRY = "FROM country cn\n";
    public static String SELECT_COUNTRY_REPORT_FROM_COUNTRY = SELECT_COUNTRY_REPORT+FROM_COUNTRY;

    private static String SELECT_CITY_REPORT = "SELECT c.name, c.population, c.district, cn.name as country\n";
    private static String FROM_CITY_C_AND_COUNTRY_CN_TABLE = "FROM city c, country cn\n";
    private static String WHERE_CN_CC_EQUALS_C_CC = "WHERE cn.code = c.countrycode\n";
    public static String DESC_ORDER = "ORDER BY population DESC;\n";
    public static String SELECT_CITY_FROM_CITY_COUNTRY_WHERE_COUNTRYCODE = SELECT_CITY_REPORT + FROM_CITY_C_AND_COUNTRY_CN_TABLE + WHERE_CN_CC_EQUALS_C_CC;

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
                Thread.sleep(10_000);
                con = DriverManager.getConnection("jdbc:mysql://localhost:33080/world?useSSL=false", "root", "supersecurepw");
                System.out.println("Successfully connected..");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

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

    @Override
    public List<CityReport> getCitiesInADistrictOrganizedByLargestToSmallestPopulation(String district, int limit) throws SQLException {
        return createCityReport(SELECT_CITY_FROM_CITY_COUNTRY_WHERE_COUNTRYCODE +
                "AND c.district = '"+ district+"'\n" +
                DESC_ORDER,limit);
    }

    @Override
    public List<CityReport> getCitiesInAContinentOrganizedByLargestToSmallestPopulation(String continent, int limit) throws SQLException {
        return createCityReport(SELECT_CITY_FROM_CITY_COUNTRY_WHERE_COUNTRYCODE +
                "AND cn.continent = '"+ continent+"'\n" +
                DESC_ORDER,limit);
    }

    @Override
    public List<CityReport> getCitiesInARegionOrganisedByLargestToSmallestPopulation(String region, int limit) throws SQLException {
        return createCityReport(SELECT_CITY_FROM_CITY_COUNTRY_WHERE_COUNTRYCODE +
                "AND cn.region = '"+ region+"'\n" +
                DESC_ORDER,limit);
    }

    @Override
    public List<CityReport> getCitiesInACountryOrganisedByLargestToSmallestPopulation(String country, int limit) throws SQLException{
        return createCityReport(SELECT_CITY_FROM_CITY_COUNTRY_WHERE_COUNTRYCODE +
                "AND cn.name = '"+country+"'\n" +
                DESC_ORDER, limit);
    }

    @Override
    public List<CityReport> getCitiesInTheWorldOrganizedByLargestToSmallestPopulation(int limit) throws SQLException {
        return createCityReport(SELECT_CITY_FROM_CITY_COUNTRY_WHERE_COUNTRYCODE +
                DESC_ORDER,limit);
    }

    @Override
    public List<CountryReport> getCountriesInARegionOrganizedByLargestToSmallestPopulation(String region, int limit) throws SQLException {
        return createCountryReport(SELECT_COUNTRY_REPORT_FROM_COUNTRY+
                "WHERE cn.region = '"+region+"'\n" +
                DESC_ORDER,limit);
    }

    @Override
    public List<CountryReport> getCountriesInAContinentOrganizedByLargestToSmallestPopulation(String continent, int limit) throws SQLException {
        return createCountryReport(SELECT_COUNTRY_REPORT_FROM_COUNTRY+
                "WHERE cn.continent = '"+continent+"'\n" +
                DESC_ORDER,limit);
    }

    @Override
    public List<CountryReport> getCountriesInTheWorldOrganizedByLargestToSmallestPopulation(int limit) throws SQLException {
        return createCountryReport(SELECT_COUNTRY_REPORT_FROM_COUNTRY+ DESC_ORDER,limit);
    }

    @Override
    public List<CapitalCityReport> getCapitalCitiesInAContinentOrganizedByLargestToSmallestPopulation(String region, int limit) throws SQLException {
        return createCapitalCityReport(SELECT_CAPITAL_CITY_REPORT_FROM_CITY +
                "WHERE country.region = '"+region+"'\n" + DESC_ORDER, limit);
    }

    @Override
    public List<CapitalCityReport> getCapitalCitiesInARegionOrganizedByLargestToSmallestPopulation(String continent, int limit) throws SQLException {
        return createCapitalCityReport(SELECT_CAPITAL_CITY_REPORT_FROM_CITY +
                "WHERE country.continent = '"+continent+"'\n" + DESC_ORDER, limit);
    }

    @Override
    public List<CapitalCityReport> getCapitalCitiesInTheWorldOrganizedByLargestToSmallestPopulation(int limit) throws SQLException {
        return createCapitalCityReport(SELECT_CAPITAL_CITY_REPORT_FROM_CITY + DESC_ORDER, limit);
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

    private List<CountryReport> createCountryReport(String sql, int limit) throws SQLException {
        ResultSet resultSet = executeQuery(sql, limit);
        ArrayList<CountryReport> reports = new ArrayList<>();
        while (resultSet.next()){
            reports.add(new CountryReport(
                    resultSet.getString("Code"),
                    resultSet.getString("Name"),
                    resultSet.getString("Continent"),
                    resultSet.getString("Region"),
                    resultSet.getInt("Population"),
                    resultSet.getInt("Capital")));
        }
        return reports;
    }

    private List<CapitalCityReport> createCapitalCityReport(String sql, int limit) throws SQLException {
        ResultSet resultSet = executeQuery(sql, limit);
        ArrayList<CapitalCityReport> reports = new ArrayList<>();
        while (resultSet.next()){
            reports.add(new CapitalCityReport(
                    resultSet.getString("Name"),
                    resultSet.getString("Country"),
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