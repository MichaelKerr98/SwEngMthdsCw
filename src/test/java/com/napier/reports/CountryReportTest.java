package com.napier.reports;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountryReportTest {

    @Test
    public void countryReportTest(){
        CountryReport testee = new CountryReport("DE", "Germany", "Europe", "Western Europe", 100,10);
        assertEquals("DE",testee.getCountryCode());
        assertEquals("Germany",testee.getCountryName());
        assertEquals("Europe",testee.getContinent());
        assertEquals("Western Europe", testee.getRegion());
        assertEquals((Integer) 100,testee.getPopulation());
        assertEquals((Integer) 10, testee.getCapital());
    }

    @Test void illegalCountryReportTest(){
        assertThrows(IllegalArgumentException.class, ()-> new CountryReport(null, null, null, null, null, null));
    }

}