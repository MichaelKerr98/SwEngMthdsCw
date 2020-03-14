package com.napier.reports;

/**
 * The PopulationReport. Contains population information like
 * continent/region/country of world, living in cities and
 * not living in cities
 */
public class PopulationReport {

    // areaScope will either be the continent, region or country
    private final String areaScope;
    private final Integer population;
    private final Integer populationInCities;
    private final Integer populationNotInCities;

    /**
     * The Constructor of PopulationReport.
     *
     * @param areaScope The name of the continent/region/country
     * @param population The total population of the continent/region/country
     * @param populationInCities The total population of the continent/region/country living in cities
     * @param populationNotInCities The total population of the continent/region/country not living in cities
     */
    public PopulationReport(String areaScope, Integer population, Integer populationInCities, Integer populationNotInCities) {
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

    public Integer getPopulation() {
        return population;
    }

    public Integer getPopulationInCities() {
        return populationInCities;
    }

    public Integer getPopulationNotInCities() {
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