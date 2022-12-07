package domain;

import java.util.Objects;

class Flight {
    // ValueObject 
    private final City departure;
    private final City destination;
    private final String classe;

    Flight(City departure, City destination, String classe) {
        this.departure = departure;
        this.destination = destination;
        this.classe = classe;
    }

    public City getDestination() {
        return destination;
    }

    public City getDeparture() {
        return departure;
    }
    public String getClasse() {
        return classe;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Flight)) return false;
        Flight otherFlight = (Flight) other;
        boolean sameDeparture = this.departure == otherFlight.getDeparture();
        boolean sameDestination = this.destination == otherFlight.getDestination();
        boolean sameClasse = this.classe == otherFlight.getClasse();
        return sameDeparture && sameDestination && sameClasse ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination,departure, classe);
    }
}
