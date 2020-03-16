package Reports;

/**
 * The CityReport. Contains city-information such as
 * the city name, the cities country, the cities destrict and the cities population.
 */
public class CityReport {

    private final String name;
    private final String country;
    private final String district;
    private final Integer population;

    /**
     * The Constructor of the CityReport.
     *
     * @param name The name of the city.
     * @param country The country of the city.
     * @param district The district of the city.
     * @param population The population of the city.
     */
    public CityReport(String name, String country, String district, Integer population) {
        if(name == null || district == null || population == null || country == null)
            throw new IllegalArgumentException("Null is not allowed!");
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    /**
     * Getter of the cities name.
     *
     * @return The cities name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of the cities country.
     *
     * @return The countries name.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Getter of the cities district.
     *
     * @return The cities district.
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Getter of the cities population.
     *
     * @return The cities population.
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Outputs all the fields of this object.
     *
     * @return String with all fields.
     */
    @Override
    public String toString() {
        return "CityReport{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}
