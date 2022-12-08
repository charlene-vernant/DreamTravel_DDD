package domain;

import java.util.Objects;

public class Ticket {
    // ValueObject
    private final City departure;
    private final City destination;
    private final City transit;
    private final int price;

    Ticket(City departure, City destination, int price) {
        this.departure = departure;
        this.destination = destination;
        transit = null;
        this.price = price;
    }

    Ticket(City departure, City transit, City destination, int price) {
        this.departure = departure;
        this.destination = destination;
        this.transit = transit;
        this.price = price;

    }

    public City getDestination() {
        return destination;
    }

    public City getTransit() {
        return transit;
    }

    public City getDeparture() {
        return departure;
    }
    public int getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object obj){
            if (obj != null
            && this.getClass()==obj.getClass()
            && this.getPrice()==(( (Ticket) obj).getPrice())
            && this.getDeparture().equals(((Ticket) obj).getDeparture())
            && this.getTransit().equals(((Ticket) obj).getTransit())
            && this.getDestination().equals(((Ticket) obj).getDestination())) return true;
            return false;
        }

    public String toString() {
        String chain = "";
        if (transit != null) {
            chain = "Départ : " + departure + " -- Transit : " + transit + " --Destination : " + destination +" Tarif : "+price;
        } else
            chain = "Départ : " + departure + " -- Destination : " + destination+" Tarif : "+price;

        return chain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, departure);
    }
}
