package domain;
import java.util.ArrayList;

class Hotel {
    // Entity
    private final ID id;
    private String hotelName;
    ArrayList<Room> roomList;

    Hotel(String hotelName) {
        this.id = new ID();
        this.hotelName = hotelName;
        this.roomList = new ArrayList<Room>();
        // Ajoute automatiquement une liste de 2 type de chambre
        roomList.add(new Room("Chambre Pas chère", 10));
        roomList.add(new Room("Chambre très chère", 100)); //+20%
       
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

    // Voir comment je peux l'utiliser
    public void addRoom(){
        roomList = getRoomList();
        roomList.add(new Room("Chambre Pas chère", 10));
        roomList.add(new Room("Chambre très chère", 100));

    }
}
