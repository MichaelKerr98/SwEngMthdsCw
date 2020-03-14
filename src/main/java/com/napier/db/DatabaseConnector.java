package com.napier.db;

import com.napier.reports.CityReport;
import com.napier.reports.CountryReport;
import com.napier.reports.PopulationReport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Initializes the connection and disconnection from the application and database.
 */
public class DatabaseConnector implements DataLayer {

    private Connection con = null;

    private static String SELECT_POPULATION_REPORT = ", SUM(country.Population) AS Total_Population, " +
            "SUM(city.Population) AS Population_Living_In_Cities, SUM(country.Population - city.Population) AS" +
            " Population_Not_Living_In_Cities\n";
    private static String FROM_COUNTRY_AND_JOIN = "FROM country\nJOIN city ON country.capital=city.id\n";
    private static String SELECT_POPULATION_REPORT_FROM_COUNTRY_AND_JOIN = SELECT_POPULATION_REPORT + FROM_COUNTRY_AND_JOIN;
    private static String ORDER_BY = "ORDER BY Total_Population\n";

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
    public List<PopulationReport> getPopulationOfContinentInTotalInCitiesAndNotInCities(String continent, int limit) throws SQLException{
        return createPopulationReport("SELECT " + continent + SELECT_POPULATION_REPORT_FROM_COUNTRY_AND_JOIN +
                "GROUP BY '"+continent+"'\n" + ORDER_BY, limit);
    }

    @Override
    public List<PopulationReport> getPopulationOfRegionInTotalInCitiesAndNotInCities(String region, int limit) throws SQLException {
        return createPopulationReport("SELECT " + region + SELECT_POPULATION_REPORT_FROM_COUNTRY_AND_JOIN +
                "GROUP BY '"+region+"'\n" + ORDER_BY, limit);
    }

    @Override
    public List<PopulationReport> getPopulationOfCountryInTotalInCitiesAndNotInCities(String country, int limit) throws SQLException {
        return createPopulationReport("SELECT " + country + SELECT_POPULATION_REPORT_FROM_COUNTRY_AND_JOIN +
                "GROUP BY '"+country+"'\n" + ORDER_BY, limit);
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

    private List<PopulationReport> createPopulationReport(String sql, int limit) throws SQLException {
        ResultSet resultSet = executeQuery(sql, limit);
        ArrayList<PopulationReport> reports = new ArrayList<>();
        while (resultSet.next()){
            reports.add(new PopulationReport(
                    resultSet.getString("Area Scope"),
                    resultSet.getInt("Total Population"),
                    resultSet.getInt("Total Population In Cities"),
                    resultSet.getInt("Total Population Not In Cities")));
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
