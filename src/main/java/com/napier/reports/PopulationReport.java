package com.napier.reports;

/**
 * The PopulationReport. Contains population information like
 * continent/region/country of world, living in cities and
 * not living in cities
 */
public class PopulationReport {

    // areaScope will either be the continent, region or country
    private final String areaScope;
    private final Long population;
    private final Long populationInCities;
    private final Long populationNotInCities;

    /**
     * The Constructor of PopulationReport.
     *
     * @param areaScope The name of the continent/region/country
     * @param population The total population of the continent/region/country
     * @param populationInCities The total population of the continent/region/country living in cities
     * @param populationNotInCities The total population of the continent/region/country not living in cities
     */
    public PopulationReport(String areaScope, Long population, Long populationInCities, Long populationNotInCities) {
        this.areaScope = areaScope;
        this.population = population;
        this.populationInCities = populationInCities;
        this.populationNotInCities = populationNotInCities;
    }

    /**
     * Getters
     */
    public String getAreaScope() {
        return areaScope;
    }

    public Long getPopulation() {
        return population;
    }

    public Long getPopulationInCities() {
        return populationInCities;
    }

    public Long getPopulationNotInCities() {
        return populationNotInCities;
    }

    /**
     * Outputs all the fields of this object.
     *
     * @return String with all fields.
     */
    @Override
    public String toString() {
        return "CountryReport{" +
                "areaScope='" + areaScope + '\'' +
                ", population='" + population + '\'' +
                ", populationInCities='" + populationInCities + '\'' +
                ", populationNotInCities='" + populationNotInCities + '\'' +
                '}';
    }
}