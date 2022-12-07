package domain;
import java.util.ArrayList;

class Hotel {
    // Entity
    private final ID id;
    private final String hotelName;
    private final City cityHotel;
    //ArrayList<Room> rooms;

    Hotel(ID id, String hotelName,City cityHotel) {
        this.id = new ID();
        this.hotelName = hotelName;
        this.cityHotel=cityHotel;
        //this.rooms = rooms;
    }

    public ID getId() {
        return id;
    }

    public String getHotelName() {
        return hotelName;
    }
    public City getCityHotel(){
        return cityHotel;
    }
    /*
    public ArrayList<Room> getRooms() {
        return rooms;
    }*/
}
