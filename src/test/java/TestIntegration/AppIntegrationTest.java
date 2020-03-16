package TestIntegration;

import Reports.CityReport;
import Reports.CountryReport;
import Reports.LanguageReport;
import com.napier.db.DataLayer;
import com.napier.db.DatabaseConnector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.napier.DatabaseOutputApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppIntegrationTest
{

    static DatabaseOutputApplication databaseOutputApplication;
    static DatabaseConnector databaseConnector;
    String name;
    String country;
    String district;
    Integer population;
    String countryName;
    String continent;
    String region;
    Integer capital;
    Integer speakers;
    Double percentage;

    @BeforeAll
    static void init()
    {
        DataLayer connector = new DatabaseConnector();
        connector.connect();
    }

    @Test
    void testGetCountry()
    {
        CountryReport countryReport = new CountryReport("GBR", countryName, continent, region, population, capital);
        assertEquals(countryReport.countryName, "United Kingdom");
        assertEquals(countryReport.continent, "Europe");
        assertEquals(countryReport.region, "British Islands");
        assertEquals(countryReport.population, "1378330.00");
        assertEquals(countryReport.capital, "London");
    }

    @Test
    void testGetCity()
    {
        CityReport cityReport = new CityReport("Haikou", country, district, population);
        assertEquals(cityReport.country, "CHN");
        assertEquals(cityReport.district, "Hainan");
        assertEquals(cityReport.population, "454300");
    }

    @Test
    void testGetLanguage()
    {
        LanguageReport languageReport = new LanguageReport("French", speakers, percentage);
        assertEquals(languageReport.speakers, "");
        assertEquals(languageReport.percentage, "");
    }
}