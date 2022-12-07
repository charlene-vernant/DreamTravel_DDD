package domain;

import java.util.ArrayList;

// Agregate : il creer les entity !!!
// il corrspond au panier d'un site de e commerce par exemple
public class Travel {
    private ID id ;
    private ArrayList<Flight> flightList;
    private ArrayList<Service> serviceList;
    private float price;

    Travel(){
        this.id = new ID();
        
    }
}
