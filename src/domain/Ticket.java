package domain;

import java.util.Objects;

public class Ticket {
    // ValueObject
    private final City departure;
    private final City destination;
    private final City transit;


    Ticket(City departure, City destination) {
        this.departure = departure;
        this.destination = destination;
        transit = null;
    }

    Ticket(City departure, City transit, City destination) {
        this.departure = departure;
        this.destination = destination;
        this.transit = transit;

    }

    public City getDestination() {
        return destination;
    }
    public City getTransit(){
        return transit;
    }
    public City getDeparture() {
        return departure;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Ticket))
            return false;
        Ticket otherTicket = (Ticket) other;
        boolean sameDeparture = this.departure == otherTicket.getDeparture();
        boolean sameDestination = this.destination == otherTicket.getDestination();
        return sameDeparture && sameDestination;
    }

    public String toString() {
        String chain = "";
        if (transit != null) {
            chain = "Départ : " + departure + " -- Transit : " + transit + " --Destination : " + destination;
        }else chain = "Départ : " + departure + " -- Destination : " + destination;

        return chain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, departure);
    }
}
