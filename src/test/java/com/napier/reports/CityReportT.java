package com.napier.reports;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityReportT {

    @Test
    public void cityReportTest(){
        com.napier.reports.CityReport testee = new com.napier.reports.CityReport("Berlin","Germany","Berlin",3_748_000);
        assertEquals("Berlin", testee.getName());
        assertEquals("Germany", testee.getCountry());
        assertEquals("Berlin", testee.getDistrict());
        assertEquals(3_748_000, (int)testee.getPopulation());
    }

    @Test
    public void illegalCityReportTest(){
        assertThrows(IllegalArgumentException.class,() -> new com.napier.reports.CityReport("Berlin","Germany", null, null));
    }
}