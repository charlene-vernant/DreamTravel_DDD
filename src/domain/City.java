package domain;

import java.util.Objects;

public class City {
    // Value object
    private final String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }

    public String getName() {
        return cityName;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof City))
            return false;
        City otherCity = (City) other;
        boolean sameName = this.cityName == otherCity.getName();
        return sameName;
    }
   
    public String toString() {
        String chain = "" + cityName;
        return chain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName);
    }
}
