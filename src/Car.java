public class Car {
    //Value object
    ID id;
    Model model;
    int price;

    Car(Model model, int price){
        this.id = new ID();
        this.model = model;
        this.price = price;
    }

    public ID getId(){
        return  this.id;
    }
    public Model getModel(){
        return  this.model;
    }
    public int getPrice(){
        return  this.price;
    }
}
