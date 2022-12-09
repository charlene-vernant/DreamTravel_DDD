package domain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Catalog {
    // Entity ou Agregate ? 
    private final ID id;
    private  ArrayList<Ticket> catalogTicket;
    private  ArrayList<City> departureDestination ;
    private  ArrayList<Hotel> catalogHotel ;
    private  ArrayList<RentalCar> catalogCar ;
    private  ArrayList<Integer> poolTicket ;

    public Catalog() {
        this.id = new ID();
        this.catalogTicket = new ArrayList<Ticket>();
        this.departureDestination = new ArrayList<City>();
        this.catalogHotel = new ArrayList<Hotel>();
        this.catalogCar = new ArrayList<RentalCar>();
        this.poolTicket = new ArrayList<Integer>();
        initCatalog();
    }

    public ID getHotelID(int choice){
        return catalogHotel.get(choice).getId();
    }
    public ID getCarID(int choice){
        return catalogCar.get(choice).getID();
    }

    public Room getRoom(int choiceHotel, int choiceRoom){
        /*
         * La manière de faire ici c'est un peu dégueu, j'ai pas réussi à penser à autre chose
         */
        return (Room)catalogHotel.get(choiceHotel).roomList.get(choiceRoom);
    }

    public CarModel getModel(int choiceCar, int choiceModel){
        /*
         * La manière de faire ici c'est un peu dégueu, j'ai pas réussi à penser à autre chose
         */
        return catalogCar.get(choiceCar).getCarList().get(choiceModel);
    }

    public ArrayList<Hotel> getCatalogHotel(){
        return catalogHotel;
    }
    public ArrayList<RentalCar> getCatalogCar(){
        return catalogCar;
    }
    public ArrayList<Ticket> getCatalogTicket() {
        return catalogTicket;
    }

    public ArrayList<City> getDepartureDestination() {
        return departureDestination;
    }
    public ID getID(){
        return this.id;
    }
    public void displayCity(){
        for (int i = 0; i < departureDestination.size(); i++){
            System.out.println(">>> ("+i+") : " + departureDestination.get(i).toString());
        }
    }

    public void displayTicketCatalog(){
        
        for (int i = 0; i < catalogTicket.size(); i++){
            System.out.println(">>> ("+i+") : " + catalogTicket.get(i).toString());
        }
        System.out.println(catalogTicket.size());
    }
    public void displayResearchTicketCatalog(City departure, City destination){
        
        for (int i = 0; i < catalogTicket.size(); i++){
            if ((catalogTicket.get(i).getDeparture().toString().equals(departure.toString())) && (catalogTicket.get(i).getDestination().toString().equals(destination.toString()))){
                System.out.println(">>> ("+i+") : " + catalogTicket.get(i).toString());
            }
        }
    }
    public void displayHotelCatalog(){
        
        for (int i = 0; i < catalogHotel.size(); i++){
            System.out.println(">>> ("+i+") : " + catalogHotel.get(i).getHotelName());
        }
    }

    public void displayRoomCatalog(int choice){
        ArrayList<Room> rooms = catalogHotel.get(choice).getRoomList();
        for (int i = 0; i < rooms.size(); i++){
            System.out.println(">>> ("+i+") : " + rooms.get(i).getroomName()+ ", prix: "+ rooms.get(i).getRoomPrice());
        }
    }

    public void displayCarCatalog(){
        
        for (int i = 0; i < catalogCar.size(); i++){
            System.out.println(">>> ("+i+") : " + catalogCar.get(i).getNameRentalCar());
        }
    }

    public void displayModelCatalog(int choice){
        ArrayList<CarModel> carModels = catalogCar.get(choice).getCarList();
        for (int i = 0; i < carModels.size(); i++){
            System.out.println(">>> ("+i+") : " + carModels.get(i).getCarName()+ ", prix: "+ carModels.get(i).getCarPrice());
        }
    }


    public void initCatalog(){
        ArrayList<JSONObject> catalogParsed = new ArrayList<JSONObject>();
        catalogParsed = parseCatalog();
        addPoolTicket();
        addCity(catalogParsed);
        addTicket(catalogParsed);
        addHotel();
        addCar();
    }
    //Service 
    public void addPoolTicket(){
        poolTicket.add(1);
        poolTicket.add(1);
        poolTicket.add(1);
    }
    // verifi qu'il reste des tickets de reduction dans la liste
    //retourne faux si la liste est vide ou vrai si pas vide
    public boolean poolIsAvailable(){
        if (poolTicket.isEmpty()){return false;}
        return true;
    }

    public void usePoolTicket(){
        if(poolIsAvailable()){
            System.out.println("Vous benficiez d'une réduction de 20% sur votre vol");
        this.poolTicket.remove(0);}
    }
    //Service
    public void addCity(ArrayList<JSONObject> catalog){
        City tmp;
        for (int i = 0; i < catalog.size(); i++) {
            JSONObject city = (JSONObject) catalog.get(i);
            //System.out.println(">> "+city.get("departure"));
            tmp = new City(city.get("departure").toString());
            this.departureDestination.add(tmp);

        }
    }
    
    public void addTicket(ArrayList<JSONObject> catalog){
        for(int departure = 0; departure<departureDestination.size();departure++){
            for (int destination = 0; destination < departureDestination.size(); destination++){
                if (departure != destination){
                    researchTicket(catalog, departureDestination.get(departure), departureDestination.get(destination));
                }
            }
        }
    }
    public boolean avoidDuplicateTicket(Ticket ticket){
        boolean isNotDuplicate = true;
        for (int i = 0; i< catalogTicket.size(); i++){
            if (ticket.equals(catalogTicket.get(i))){
                isNotDuplicate = false;
            }
        }
        return isNotDuplicate;
    }
    // Service
    public void researchTicket(ArrayList<JSONObject> catalog, City departure, City destination){
        
        Random r = new Random();
        

        Ticket tmp ;        
        if (isDirectTicketPossible(catalog, departure.toString(), destination.toString())){
            int priceInitial = r.nextInt(150);
            tmp = new Ticket((City)departure, (City)destination, priceInitial);
            if (avoidDuplicateTicket(tmp)){
                catalogTicket.add(tmp);
            }
        }
        ArrayList<String> stopovers = initStopover(catalog, departure.toString(), destination.toString());
        for(int stopover = 0; stopover < stopovers.size(); stopover++){
            int priceInitial = r.nextInt(300);
            String tmp2 =  stopovers.get(stopover);
            City transit = new City(tmp2);
            tmp = new Ticket((City)departure, transit,(City)destination,priceInitial*=2.5);
            catalogTicket.add(tmp);
        }

    }

    //Service
    public void addHotel(){
        catalogHotel.add(new Hotel("Hotel du CROUS"));
        catalogHotel.add(new Hotel("Hotel du Quartier"));
        catalogHotel.add(new Hotel("Hotel de la Plage"));
        catalogHotel.add(new Hotel("Hotel des Petits Pois"));
    }
    //Service
    public void addCar(){
        catalogCar.add(new RentalCar("Voiture2000"));
        catalogCar.add(new RentalCar("Roue-Roue"));
        catalogCar.add(new RentalCar("AMG Turbo Feu"));
        catalogCar.add(new RentalCar("Automobile"));
    }


    public ArrayList<JSONObject> parseCatalog() {
        JSONParser parser = new JSONParser();
        ArrayList<JSONObject> catalog = new ArrayList<>();
        try {
            Reader reader = new FileReader("src/domain/catalog.json");
            Object jsonObj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) jsonObj;
            catalog = (ArrayList<JSONObject>) jsonObject.get("catalog");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public boolean isDirectTicketPossible(ArrayList<JSONObject> catalog, String departure, String destination) {
        boolean isPossible = false;
        if (departureHasDestination(catalog, departure, destination)) {
            isPossible = true;
        }
        return isPossible;
    }

    public boolean departureHasDestination(ArrayList<JSONObject> catalog, String departure, String destination) {
        boolean hasDestinaton = false;
        for (int i = 0; i < catalog.size(); i++) {
            JSONObject city = (JSONObject) catalog.get(i);
            if (city.get("departure").toString().equals(departure)) {
                ArrayList<String> destinations = (ArrayList<String>) city.get("destination");

                for (int e = 0; e < destinations.size(); e++) {
                    if (destinations.get(e).toString().equals(destination)) {
                        hasDestinaton = true;
                    }
                }
            }
        }
        return hasDestinaton;
    }
    
    public ArrayList<String> initStopover(ArrayList<JSONObject> catalog, String departure, String destination) {
        ArrayList<String> stopovers = new ArrayList<String>();
        for (int i = 0; i < catalog.size(); i++) {
            JSONObject city = (JSONObject) catalog.get(i);
            if (city.get("departure").toString().equals(departure)) {
                ArrayList<String> destinations = (ArrayList<String>) city.get("destination");
                for (int e = 0; e < destinations.size(); e++) {
                    String stopover = destinations.get(e).toString();
                    if (departureHasDestination(catalog, stopover, destination)) {
                        stopovers.add(stopover);
                    }
                }
            }
        }
        return stopovers;
    }
}