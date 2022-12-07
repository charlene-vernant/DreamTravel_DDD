package domain;

import java.util.ArrayList;

// Agregate : il creer les entity !!! il est visible hors du domaine !!!!
// aucune des methodes ne doit être une entity : parametre des methodes typées par des value object
// il corrspond au panier d'un site de e commerce par exemple
public class Travel {
    private ID id ;
    private ArrayList<Flight> flightList;
    //private ArrayList<Service> serviceList; 
    // service est une entity qui doit contenir les hotels et les voitures
    //private float price;
    private Client client;

    Travel(){
        this.id = new ID();
        // add le reste 
    }

    public ID getId(){
        return id;
    }

    //add les autres getters
}
