package com.napier.reports;

/**
 * The CapitalCityReport contains the capital city name, the country where the capital
 * city is located and the population of the capital city
 */
public class CapitalCityReport {

    private final String name;
    private final String country;
    private final Integer population;

    // Constructor
    public CapitalCityReport(String name, String country, Integer population) {
        if(name == null || country == null || population == null)
            throw new IllegalArgumentException("Null not allowed.");
        this.name = name;
        this.country = country;
        this.population = population;

    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Integer getPopulation() {
        return population;
    }

    // Methods
    @Override
    public String toString() {
        return "CapitalCityReport{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                '}';
    }
}