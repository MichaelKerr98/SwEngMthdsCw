package com.napier.reports;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountryReportT {

    @Test
    public void countryReportTest(){
        com.napier.reports.CountryReport testee = new com.napier.reports.CountryReport("DE", "Germany", "Europe", "Western Europe", 82_790_00, 3_068);
        assertEquals("DE",testee.getCountryCode());
        assertEquals("Germany",testee.getCountryName());
        assertEquals("Europe",testee.getContinent());
        assertEquals("Western Europe",testee.getRegion());
        assertEquals(82_790_00,(int)testee.getPopulation());
        assertEquals(3_068,(int)testee.getCapital());
    }

    @Test void illegalCountryReportTest(){
        assertThrows(IllegalArgumentException.class, () -> new com.napier.reports.CountryReport(null, "Germany", "Europe", null, null, null));
    }

}