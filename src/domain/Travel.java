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
    private float price;
    private Client client;

    Travel(String clientName){
        this.id = new ID();
        this.flightList = new ArrayList<Flight>();
        this.price = 0;
        //this.serviceList = new ArrayList<Service>();
        this.client = new Client(clientName);

    }

    public ID getId(){
        return this.id;
    }
    public ArrayList<Flight> getFlightList(){
        return this.flightList;
    }
    public float getPrice(){
        return this.price;
    }
    public Client getClient(){
        return this.client;
    }
    /*public ArrayList<Service> getServiceList(){
        return serviceList;
    }*/

    public void addFlight(City departure, City destination,int classe){
        Flight flight = new Flight(departure,destination,classe);
        flightList.add(flight);
    }
    /*public void addService(){
        ;
    }*/
    
}
