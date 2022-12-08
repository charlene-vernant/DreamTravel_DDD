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
    public boolean equals(Object obj){
            if (obj != null
            && this.getClass()==obj.getClass()
            && this.getName().equals((( (City) obj).getName()))) return true;
            return false;
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
