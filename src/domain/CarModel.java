package domain;

import java.util.Objects;

class CarModel {
    //Value Object
    private final String carName;

    CarModel(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof CarModel)) return false;
        CarModel otherCarModel = (CarModel) other;
        boolean sameName = this.carName == otherCarModel.getCarName();
        return sameName ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
