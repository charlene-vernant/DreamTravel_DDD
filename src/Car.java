 class Car {
    //Value object or entity ?
 
    private final CarModel model;
    private final int carPrice;

    Car(CarModel model, int carPrice){
        this.model = model;
        this.carPrice = carPrice;
    }

    public CarModel getModel(){
        return  this.model;
    }
    public int getCarPrice(){
        return  this.carPrice;
    }
}
