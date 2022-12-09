package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Agregate 
public class Travel {
    private ID id;
    private ArrayList<Flight> flightList;
    private Map<ID, ArrayList<Room>> rooms;
    private Map<ID, ArrayList<CarModel>> cars;
    private float price;
    private Client client;

    public Travel(String clientName) {
        this.id = new ID();
        this.flightList = new ArrayList<Flight>();
        this.rooms = new HashMap<>();
        this.cars = new HashMap<>();
        this.price = 0;
        this.client = new Client(clientName);

    }

    public void updatePrice() {
        for (int flight = 0; flight < flightList.size(); flight++) {
            this.price += flightList.get(flight).getPrice();
            System.out.println(flightList.get(flight).getPrice());
        }
        for (ArrayList<Room> roomList : rooms.values()) {
            for (Room room : roomList) {
                this.price += room.getRoomPrice();
                System.out.println(room.getRoomPrice());
            }
        }
        for (ArrayList<CarModel> carModelList : cars.values()) {
            for (CarModel carModel : carModelList) {
                this.price += carModel.getCarPrice();
                System.out.println(carModel.getCarPrice());
            }
        }
    }

    public ID getId() {
        return this.id;
    }

    public ArrayList<Flight> getFlightList() {
        return this.flightList;
    }

    public float getPrice() {
        return this.price;
    }

    public Client getClient() {
        return this.client;
    }

    public void addFlight(City departure, City destination, int classe, float price, LocalDate date) {
        Flight flight = new Flight(departure, destination, classe, price, date);
        flightList.add(flight);
    }

    public void addHotel(ID hotelID, Room room) {
        if (rooms.get(hotelID) == null) {
            rooms.put(hotelID, new ArrayList<Room>());
        }
        rooms.get(hotelID).add(room);

    }

    public void addRentalCar(ID rentalCarID, CarModel carModel) {
        if (cars.get(rentalCarID) == null) {
            cars.put(rentalCarID, new ArrayList<CarModel>());
        }
        cars.get(rentalCarID).add(carModel);
    }

    @Override
    public String toString() {
        String hotel = "";
        String rentalCar = "";

        if (rooms.size() != 0) {
            hotel += "\n\tListe des Hotels: ";
            for (ID hotelID : rooms.keySet()) {
                hotel += "\n\tHotel ID : " + hotelID.toString();
                for (Room room : rooms.get(hotelID)) {
                    hotel += "\n\t - Room : " + room.toString();
                }
            }
            rentalCar += "\n\tListe des Loueurs de voitures : ";
            for (ID rentalCarId : cars.keySet()) {
                rentalCar += "\n\tLoueur ID : " + rentalCarId.toString();
                for (CarModel carModel : cars.get(rentalCarId)) {
                    rentalCar += "\n\t - Voiture : " + carModel.toString();
                }
            }
        } else {
            hotel += "\n\tAucun hotel";
            rentalCar += "\n\tAucun loueur de voiture";
        }
        String flights = "";
        for (Flight flight : flightList) {
            flights += "\n\t" + flight.toString();
        }
        String wrap = "\n----------------------------------------------";
        String chain = wrap + "\nRecapitulatif : " + "\n>>> id : " + this.id + " \n>>> client : " + this.client
                + " \n>>> vols : " + flights + "\n>>> Services : " + hotel + rentalCar + "\n>>> prix total: "
                + this.price + wrap;
        return chain;
    }

}
