package domain;

import java.util.Objects;
import java.util.Random;

class Room {
    // ValueObject
    private final String roomName;
    private final int roomPrice;
    Room(String roomName, int roomPrice){
        this.roomName=roomName;
        this.roomPrice=roomPrice;
    }

    public String getroomName() {
        return roomName;
    }
    public int getRoomPrice() {
        return roomPrice;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Room)) return false;
        Room otherRoom= (Room) other;
        boolean sameName = this.roomName == otherRoom.getroomName();
        boolean samePrice = this.roomPrice == otherRoom.getRoomPrice();
        return sameName && samePrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomName,roomPrice);
    }

    
}
