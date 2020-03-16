package TestIntegration;

import Reports.CityReport;
import com.napier.db.DatabaseConnector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import com.napier.db.DataLayer;
import com.napier.db.DatabaseConnector;
import com.napier.DatabaseOutputApplication;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import Reports.CountryReport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppIntegrationTest
{
    static DatabaseOutputApplication DatabaseOutputApplication;
    private String name;
    private String country;
    private String district;
    private Integer population;

    @BeforeAll
    void init()
    {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        databaseConnector.connect();
    }

    @Test
    void testGetEmployee()
    {
        CityReport cityreport = new CityReport(name, country, district, population);
    }
}