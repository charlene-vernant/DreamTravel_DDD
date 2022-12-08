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
        roomList.add(new Room("Chambre Pas chère", priceInitial));
        roomList.add(new Room("Chambre très chère", priceInitial *= 1.2));

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
