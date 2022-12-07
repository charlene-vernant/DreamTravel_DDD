package domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Flight)) return false;
        Flight otherFlight = (Flight) other;
        boolean sameDeparture = this.departure == otherFlight.getDeparture();
        boolean sameDestination = this.destination == otherFlight.getDestination();
        return sameDeparture && sameDestination ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination,departure);
    }
}
