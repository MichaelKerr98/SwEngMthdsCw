package com.napier.reports;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PopulationReportTest {

    @Test
    public void PopulationReportTest() {
        PopulationReport testee = new PopulationReport("Asia", 3705025700L, 101322793L, 3603702907L);
        assertEquals(3705025700L, (long)testee.getPopulation());
        assertEquals(101322793L, (long)testee.getPopulationInCities());
        assertEquals(3603702907L, (long)testee.getPopulationNotInCities());
    }

    public void illegalLanguageReportTest(){
        assertThrows(IllegalArgumentException.class, () -> new PopulationReport("Asia", null, null, null));
    }
}