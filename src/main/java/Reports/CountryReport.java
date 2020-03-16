package Reports;

/**
 * The CountryReport. Contains Country-information such as
 * the countryCode, contryName, continent, region, population and capital.
 */
public class CountryReport {

    public final String countryCode;
    public final String countryName;
    public final String continent;
    public final String region;
    public final Integer population;
    public final Integer capital;

    /**
     * The Constructor of the CountryReport.
     *
     * @param countryCode The countryCode of the country.
     * @param countryName The name of the country.
     * @param continent The countries continent.
     * @param region The countries region.
     * @param population The countries population.
     * @param capital The countries capital.
     */
    public CountryReport(String countryCode, String countryName, String continent, String region, Integer population, Integer capital) {
        if(countryCode == null || countryName == null || continent == null || region == null || population == null || capital == null)
            throw new IllegalArgumentException("Null is not allowed!");
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    /**
     * Getter of the countries CountryCode.
     *
     * @return The countryCode.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Getter of the countries name.
     *
     * @return The countries name.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Getter of the countries continent.
     *
     * @return The continent of the country.
     */
    public String getContinent() {
        return continent;
    }

    /**
     *  Getter of the countries region.
     *
     * @return The countries region.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Getter of the countries population.
     *
     * @return The countries population.
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Getter of the countries capital.
     *
     * @return The countries capital.
     */
    public Integer getCapital() {
        return capital;
    }

    /**
     * Outputs all the fields of this object.
     *
     * @return String with all fields.
     */
    @Override
    public String toString() {
        return "CountryReport{" +
                "countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital=" + capital +
                '}';
    }
}
