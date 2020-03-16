package TestUnit;

import Reports.CityReport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityReportT {

    @Test
    public void cityReportTest(){
        Reports.CityReport testee = new Reports.CityReport("Berlin","Germany","Berlin",3_748_000);
        assertEquals("Berlin", testee.getName());
        assertEquals("Germany", testee.getCountry());
        assertEquals("Berlin", testee.getDistrict());
        assertEquals(3_748_000, (int)testee.getPopulation());
    }

    @Test
    public void illegalCityReportTest(){
        assertThrows(IllegalArgumentException.class,() -> new Reports.CityReport("Berlin","Germany", null, null));
    }
}