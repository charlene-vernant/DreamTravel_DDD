package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

// Agregate : il creer les entity !!! il est visible hors du domaine !!!!
// aucune des methodes ne doit être une entity : parametre des methodes typées par des value object
// il corrspond au panier d'un site de e commerce par exemple
public class Travel {
    private ID id ;
    private ArrayList<Flight> flightList;
    private Map<ID, Room> rooms; 
    private Map<ID, CarModel> cars; 
    // service est une entity qui doit contenir les hotels et les voitures
    private float price;
    private Client client;

    public Travel(String clientName){
        this.id = new ID();
        this.flightList = new ArrayList<Flight>();
        this.price = 0;
        //this.serviceList = new ArrayList<Service>();
        this.client = new Client(clientName);

    }

    public void updatePrice(float price){
        for(int flight =0; flight < flightList.size(); flight++){
            this.price+=flightList.get(flight).getPrice();
        }
        for (Room room : rooms.values()) {
            this.price+=room.getRoomPrice();
        }
        for (CarModel carModel : cars.values()) {
            this.price+=carModel.getCarPrice();
        }
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
 
    public void addFlight(City departure, City destination, int classe, float price, LocalDate date){
        Flight flight = new Flight(departure,destination,classe, price, date);
        flightList.add(flight);
    }

    public void addHotel(ID hotelID, Room room) {
        rooms.put(hotelID, room);
        System.out.println(rooms.get(hotelID));
    }

    public void addRentalCar(ID rentalCarID, CarModel carModel) {
        cars.put(rentalCarID, carModel);
        System.out.println(cars.get(rentalCarID));
    }
  
    @Override
    public String toString(){
        String chain = "id : " +this.id + " vols : "+this.flightList+" client : "+this.client+" prix : "+this.price; //voir pk ça beug        
        return chain;
    }
   
}
