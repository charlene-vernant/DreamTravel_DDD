package domain;

import java.util.ArrayList;

class RentalCar {
    // Entity
    private ID id;
    private String nameRentalCar;
    private ArrayList<CarModel> carList;

    RentalCar(String nameRentalCar) {
        this.id = new ID();
        this.nameRentalCar = nameRentalCar;
        this.carList = new ArrayList<CarModel>();
        // Ajoute automatiquement une liste de 3 Modele de voitures définies
        carList.add(new CarModel("Multipla", 30));
        carList.add(new CarModel("Ferrari", 200));
        carList.add(new CarModel("4x4 Tout-terrain", 100));
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
    public void addCar(){
        carList = getCarList();
        carList.add(new CarModel("Multipla", 30));
        carList.add(new CarModel("Ferrari", 200));
        carList.add(new CarModel("4x4 Tout-terrain", 100));

    }
}
