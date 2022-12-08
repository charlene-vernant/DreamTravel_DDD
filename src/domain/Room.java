package domain;

import java.util.Objects;


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
    public boolean equals(Object obj){
            if (obj != null
            && this.getClass()==obj.getClass()
            && this.getRoomPrice()==(( (Room) obj).getRoomPrice())
            && this.getroomName().equals(((Room) obj).getroomName())) return true;
            return false;
        }

    @Override
    public int hashCode() {
        return Objects.hash(roomName,roomPrice);
    }

    
}
