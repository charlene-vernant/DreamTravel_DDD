package domain;

import java.util.ArrayList;
import java.util.Random;

class Hotel {
    // Entity
    private final ID id;
    private String hotelName;
    ArrayList<Room> roomList;

    Hotel(String hotelName) {
        this.id = new ID();
        this.hotelName = hotelName;
        this.roomList = new ArrayList<Room>();
        InitRoom();
        // Ajoute automatiquement une liste de 2 type de chambre
        // roomList.add(new Room("Chambre Pas chère", 50));
        // roomList.add(new Room("Chambre très chère", 100));

    }

    public ID getId() {
        return id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public void InitRoom() {
        Random r = new Random();
        int priceInitial = r.nextInt(50);
        roomList = getRoomList();
        roomList.add(new Room("Chambre Simple", priceInitial));
        roomList.add(new Room("Chambre Luxe", priceInitial *= 1.3));

    }

    @Override
    public boolean equals(Object o) {
        if (o != null
                && o.getClass() == this.getClass()
                && this.getId() == ((Hotel) o).getId())
            return true;
        return false;
    }
}
