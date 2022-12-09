package domain;

import java.util.Objects;


public class Room {
    // ValueObject
    private final String roomName;
    private final float roomPrice;
    public Room(String roomName, float roomPrice){
        this.roomName=roomName;
        this.roomPrice=roomPrice;
    }

    public String getroomName() {
        return roomName;
    }
    public float getRoomPrice() {
        return roomPrice;
    }

    @Override
    public boolean equals(Object obj){
        if (obj != null
        && this.getClass()==obj.getClass()
        && this.getRoomPrice()==(( (Room) obj).getRoomPrice())
        && this.getroomName().equals(((Room) obj).getroomName())) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Nom de la chambre : "+roomName+" prix: "+roomPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomName,roomPrice);
    }

    
}
