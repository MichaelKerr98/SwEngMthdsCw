package com.napier.reports;

/**
 *
 */
public class CityReport {

    private final String name;
    private final String country;
    private final String district;
    private final Integer population;

    /**
     *
     * @param name
     * @param country
     * @param district
     * @param population
     */
    public CityReport(String name, String country, String district, Integer population) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @return
     */
    public String getDistrict() {
        return district;
    }

    /**
     *
     * @return
     */
    public Integer getPopulation() {
        return population;
    }
}
