package domain;

import java.util.ArrayList;
import java.util.Random;

class RentalCar {
    // Entity
    private final ID id;
    private String nameRentalCar;
    private ArrayList<CarModel> carList;

    RentalCar(String nameRentalCar) {
        this.id = new ID();
        this.nameRentalCar = nameRentalCar;
        this.carList = new ArrayList<CarModel>();
        initCar();
    }

    public ID getID() {
        return this.id;
    }

    public String getNameRentalCar() {
        return this.nameRentalCar;
    }

    public ArrayList<CarModel> getCarList() {
        return this.carList;
    }

    // Voir comment je peux l'utiliser
    public void initCar() {
        Random r = new Random();
        int priceInitial = r.nextInt(30);
        carList = getCarList();
        carList.add(new CarModel("Multipla", priceInitial));
        carList.add(new CarModel("Ferrari", priceInitial *= 1.3));
        carList.add(new CarModel("4x4 Tout-terrain", priceInitial *= 1.2));

    }

    @Override
    public boolean equals(Object o) {
        if (o != null
                && o.getClass() == this.getClass()
                && this.getID() == ((Hotel) o).getId())
            return true;
        return false;
    }
}
