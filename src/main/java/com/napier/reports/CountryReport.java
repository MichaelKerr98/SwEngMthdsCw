package com.napier.reports;

/**
 *
 */
public class CountryReport {

    private final String countryCode;
    private final String countryName;
    private final String continent;
    private final String region;
    private final Integer population;
    private final Integer capital;

    /**
     *
     * @param countryCode
     * @param countryName
     * @param continent
     * @param region
     * @param population
     * @param capital
     */
    public CountryReport(String countryCode, String countryName, String continent, String region, Integer population, Integer capital) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    /**
     *
     * @return
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     *
     * @return
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     *
     * @return
     */
    public String getContinent() {
        return continent;
    }

    /**
     *
     * @return
     */
    public String getRegion() {
        return region;
    }

    /**
     *
     * @return
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     *
     * @return
     */
    public Integer getCapital() {
        return capital;
    }
}
