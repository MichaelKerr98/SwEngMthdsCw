package com.napier.reports;

/**
 * The LanguageReport. Contains language-information
 * (name, amount of speakers and the percentage of the worlds population).
 */
public class LanguageReport {

    private String language;
    private int speakers;
    private double percentage;

    /**
     * The Constructor of the LanguageReport.
     *
     * @param language The name of the language.
     * @param speakers The number of people speaking a certain language.
     * @param percentage The percentage of the world's population.
     */
    public LanguageReport(String language, int speakers, double percentage) {
        this.language = language;
        this.speakers = speakers;
        this.percentage = percentage;
    }

    /**
     * Getter of the language name.
     *
     * @return The name of the language.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Getter of speakers.
     *
     * @return The number of people speaking a certain language.
     */
    public int getSpeakers() {
        return speakers;
    }

    /**
     * Getter of percentage.
     *
     * @return The percentage of the world's population.
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * Outputs all the fields of this object.
     *
     * @return String with all fields.
     */
    @Override
    public String toString() {
        return "LanguageReport{" +
                "language='" + language + '\'' +
                ", speakers=" + speakers +
                ", percentage=" + percentage +
                '}';
    }
}
