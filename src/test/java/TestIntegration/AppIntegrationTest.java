package TestIntegration;

import Reports.CityReport;
import com.napier.db.DatabaseConnector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.napier.DatabaseOutputApplication;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppIntegrationTest
{
    static DatabaseOutputApplication databaseOutputApplication;
    static DatabaseConnector databaseConnector;
    private String name;
    private String country;
    private String district;
    private Integer population;

    @BeforeAll
    static void init()
    {
        databaseConnector = new DatabaseConnector();
        databaseConnector.connect();
    }

    @Test
    void testGetEmployee()
    {
        CityReport cityreport = new CityReport(name, country, district, population);
    }
}