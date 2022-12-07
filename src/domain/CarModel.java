package domain;

import java.util.Objects;

class CarModel {
    //Value Object
    private final String carName;
    private final int carPrice;
    CarModel(String carName, int carPrice) {
        this.carName = carName;
        this.carPrice = carPrice;
    }

    public String getCarName() {
        return carName;
    }
    public int getCarPrice(){
        return carPrice;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof CarModel)) return false;
        CarModel otherCarModel = (CarModel) other;
        boolean sameName = this.carName == otherCarModel.getCarName();
        boolean samePrice = this.carPrice == otherCarModel.getCarPrice();
        return sameName && samePrice ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName,carPrice);
    }
}
