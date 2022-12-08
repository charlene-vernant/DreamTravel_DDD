package domain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Catalog {
    // Entity ou Agregate ? 
    private final ID id;
    private  ArrayList<Ticket> catalogTicket;
    private  ArrayList<City> departureDestination ;
    private  ArrayList<Hotel> catalogHotel ;
    private  ArrayList<RentalCar> catalogCar ;
    public Catalog() {
        this.id = new ID();
        this.catalogTicket = new ArrayList<Ticket>();
        this.departureDestination = new ArrayList<City>();
        this.catalogHotel = new ArrayList<Hotel>();
        this.catalogCar = new ArrayList<RentalCar>();
        
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
    }
    //Service
    public void addCity(){
        ArrayList catalog = new ArrayList<>();
        catalog = parseCatalog();
        City tmp;
        for (int i = 0; i < catalog.size(); i++) {
            JSONObject city = (JSONObject) catalog.get(i);
            //System.out.println(">> "+city.get("departure"));
            tmp = new City(city.get("departure").toString());
            this.departureDestination.add(tmp);

        }
    }
    // Service
    public void researchTicket(City departure, City destination){
        Ticket tmp ;        
        if (isDirectTicketPossible(departure.toString(), destination.toString())){
            tmp = new Ticket((City)departure, (City)destination);
            catalogTicket.add(tmp);
            }
            ArrayList<String> stopovers = findStopover(departure.toString(), destination.toString());
            for(int stopover = 0; stopover < stopovers.size(); stopover++){
            String transit =  stopovers.get(stopover);
            City transit1 = new City(transit); // DEgueulasse a revoir absolument
            tmp = new Ticket((City)departure, transit1,(City)destination);
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


    public ArrayList parseCatalog() {
        JSONParser parser = new JSONParser();
        ArrayList catalog = new ArrayList<>();
        try {
            Reader reader = new FileReader("src/domain/catalog.json");
            Object jsonObj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) jsonObj;
            catalog = (ArrayList) jsonObject.get("catalog");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public boolean isDirectTicketPossible(String departure, String destination) {
        boolean isPossible = false;
        if (departureHasDestination(departure, destination)) {
            isPossible = true;
        }
        return isPossible;
    }

    public boolean catalogHasDeparture(String departure) {
        boolean hasDeparture = false;
        ArrayList catalog = parseCatalog();
        for (int i = 0; i < catalog.size(); i++) {
            JSONObject city = (JSONObject) catalog.get(i);
            if (city.get("departure").toString().equals(departure)) {
                hasDeparture = true;
            }
        }
        return hasDeparture;
    }

    public boolean departureHasDestination(String departure, String destination) {
        boolean hasDestinaton = false;
        ArrayList catalog = parseCatalog();
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

    public ArrayList<String> findStopover(String departure, String destination) {
        ArrayList<String> stopovers = new ArrayList<String>();
        ArrayList catalog = parseCatalog();
        for (int i = 0; i < catalog.size(); i++) {
            JSONObject city = (JSONObject) catalog.get(i);
            if (city.get("departure").toString().equals(departure)) {
                ArrayList<String> destinations = (ArrayList<String>) city.get("destination");
                for (int e = 0; e < destinations.size(); e++) {
                    String stopover = destinations.get(e).toString();
                    if (departureHasDestination(stopover, destination)) {
                        stopovers.add(stopover);
                    }
                }
            }
        }
        return stopovers;
    }
}
