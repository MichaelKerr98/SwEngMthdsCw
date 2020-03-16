package TestUnit;

import Reports.LanguageReport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LanguageReportT {


    @Test
    public void languageReportTest(){
        Reports.LanguageReport testee = new Reports.LanguageReport("test",100_000, 15.3D);
        assertEquals("test", testee.getLanguage());
        assertEquals(100_000, testee.getSpeakers());
        assertEquals(15.3D, testee.getPercentage());
    }

    public void illegalLanguageReportTest(){
        assertThrows(IllegalArgumentException.class, () -> new Reports.LanguageReport("test", null, null));
    }
}