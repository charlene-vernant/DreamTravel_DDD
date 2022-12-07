package domain;
import java.util.Objects;
class City {
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
        if (! (other instanceof City)) return false;
        City otherCity = (City) other;
        boolean sameName = this.cityName == otherCity.getName();
        return sameName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName);
    }
}
