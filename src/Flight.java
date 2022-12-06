
class Flight {
    // ValueObject 
    private final City departure;
    private final City destination;

    Flight(City departure, City destination) {
        this.departure = departure;
        this.destination = destination;
    }

    public City getDestination() {
        return destination;
    }

    public City getDeparture() {
        return departure;
    }
}
