package com.napier.reports;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LanguageReportT {


    @Test
    public void languageReportTest(){
        com.napier.reports.LanguageReport testee = new com.napier.reports.LanguageReport("test",100_000, 15.3D);
        assertEquals("test", testee.getLanguage());
        assertEquals(100_000, testee.getSpeakers());
        assertEquals(15.3D, testee.getPercentage());
    }

    public void illegalLanguageReportTest(){
        assertThrows(IllegalArgumentException.class, () -> new com.napier.reports.LanguageReport("test", null, null));
    }
}