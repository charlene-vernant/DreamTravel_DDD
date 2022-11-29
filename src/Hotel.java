import java.util.ArrayList;

public class Hotel {
    ID id;
    String name;
    //ArrayList<Room> rooms;

    Hotel(ID id, String name, ArrayList<Room> rooms) {
        this.id = id;
        this.name = name;
        //this.rooms = rooms;
    }

    public ID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*
    public ArrayList<Room> getRooms() {
        return rooms;
    }*/
}
