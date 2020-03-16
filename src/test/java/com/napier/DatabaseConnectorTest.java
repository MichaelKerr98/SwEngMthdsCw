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

    /*@Test
    public void getCitiesInARegionOrganisedByLargestToSmallestPopulation() {
    }

    @Test
    public void getCitiesInACountryOrganisedByLargestToSmallestPopulation() {
    }

    @Test
    public void getCitiesInTheWorldOrganizedByLargestToSmallestPopulation() {
    }

    @Test
    public void getCountriesInARegionOrganizedByLargestToSmallestPopulation() {
    }

    @Test
    public void getCountriesInAContinentOrganizedByLargestToSmallestPopulation() {
    }

    @Test
    public void getCountriesInTheWorldOrganizedByLargestToSmallestPopulation() {
    }*/
}
