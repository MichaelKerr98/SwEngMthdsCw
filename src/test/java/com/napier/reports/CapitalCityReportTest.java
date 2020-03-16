package com.napier.reports;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CapitalCityReportTest {

    @Test
    public void CapitalCityReportTest() {
        CapitalCityReport testee = new CapitalCityReport("Canberra", "Australia", 322723);
        assertEquals("Canberra", testee.getName());
        assertEquals("Australia", testee.getCountry());
        assertEquals(322723, (int)testee.getPopulation());
    }

    @Test
    public void illegalCapitalCityReportTest() {
        assertThrows(IllegalArgumentException.class,() -> new CapitalCityReport("Canberra", null, null));
    }
}