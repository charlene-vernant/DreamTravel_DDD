class Room {
    // a voir si on a besoin
    private final int roomNumber;
    private final int roomPrice;
    Room(int roomNumber, int roomPrice){
        this.roomNumber=roomNumber;
        this.roomPrice=roomPrice;
    }

    public int getroomNumber() {
        return roomNumber;
    }
    public int getRoomPrice() {
        return roomPrice;
    }
}
