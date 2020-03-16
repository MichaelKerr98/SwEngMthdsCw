package com.napier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DatabaseConnectorTest {

    private static DataLayer testee;

    @BeforeAll
    public static void setUp()
    {
        testee = new DatabaseConnector();
        testee.connect();
    }

    @Test
    public void getCitiesInADistrictOrganizedByLargestToSmallestPopulation() throws SQLException {
        assertEquals(4, testee.getCitiesInADistrictOrganizedByLargestToSmallestPopulation("Berlin",4).size());
    }

    @Test
    public void getCitiesInAContinentOrganizedByLargestToSmallestPopulation() throws SQLException {
        assertEquals(4, testee.getCountriesInAContinentOrganizedByLargestToSmallestPopulation("Europe",4).size());
    }

    @Test
    public void getCitiesInARegionOrganisedByLargestToSmallestPopulation() throws SQLException {
        assertEquals(10, testee.getCitiesInARegionOrganisedByLargestToSmallestPopulation("Polynesia", -1).size());
    }

    @Test
    public void getCitiesInACountryOrganisedByLargestToSmallestPopulation() throws SQLException {
        assertEquals(3 , testee.getCitiesInACountryOrganisedByLargestToSmallestPopulation("Switzerland",3).size());
        assertEquals("Berlin", testee.getCitiesInACountryOrganisedByLargestToSmallestPopulation("Germany", 3).get(0).getName());
    }

    @Test
    public void getCitiesInTheWorldOrganizedByLargestToSmallestPopulation() throws SQLException {
        assertEquals("Tokyo", testee.getCitiesInTheWorldOrganizedByLargestToSmallestPopulation(1).get(0));
    }

    @Test
    public void getCountriesInARegionOrganizedByLargestToSmallestPopulation() throws SQLException {
        assertEquals(2, testee.getCountriesInARegionOrganizedByLargestToSmallestPopulation("Southern Europe", 2).size());
    }

    @Test
    public void getCountriesInAContinentOrganizedByLargestToSmallestPopulation() throws SQLException {
        assertEquals("China", testee.getCountriesInAContinentOrganizedByLargestToSmallestPopulation("Asia", 1).get(0));
    }

    @Test
    public void getCountriesInTheWorldOrganizedByLargestToSmallestPopulation() throws SQLException {
        assertEquals("China", testee.getCountriesInTheWorldOrganizedByLargestToSmallestPopulation(1).get(0));
    }

    @Test
    public void getCapitalCitiesInAContinentOrganizedByLargestToSmallestPopulation() throws SQLException {
        assertEquals("Tokyo", testee.getCapitalCitiesInAContinentOrganizedByLargestToSmallestPopulation("Asia", 1).get(0).getName());
    }

    @Test
    public void getCapitalCitiesInARegionOrganizedByLargestToSmallestPopulation() throws SQLException {
        assertEquals(2, testee.getCapitalCitiesInARegionOrganizedByLargestToSmallestPopulation("Caribbean", 2).size());

    }

    @Test
    public void getCapitalCitiesInTheWorldOrganizedByLargestToSmallestPopulation() throws SQLException {
        assertEquals("Tokyo", testee.getCapitalCitiesInTheWorldOrganizedByLargestToSmallestPopulation(1).get(0).getName());
    }
}