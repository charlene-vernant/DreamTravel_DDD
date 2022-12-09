package domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Ticket {
    // ValueObject
    private final City departure;
    private final City destination;
    private final City transit;
    private final float price;
    private final LocalDate date;

    Ticket(City departure, City destination, float price) {
        this.departure = departure;
        this.destination = destination;
        transit = null;
        this.price = price;
        this.date=initDate();
    }

    Ticket(City departure, City transit, City destination, int price) {
        this.departure = departure;
        this.destination = destination;
        this.transit = transit;
        this.price = price;
        this.date=initDate();
    }

    public LocalDate initDate(){
        Random r = new Random();
        int days = r.nextInt(7);
        LocalDate localDate = LocalDate.now().plusDays(days);
        return localDate;
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
    public float getPrice(){
        return price;
    }

    public LocalDate getDate() {
        return date;
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
            chain = "Départ : " + departure + " -- Transit : " + transit + " --Destination : " + destination +" Tarif (pour 1 vol) : "+price+" Date: "+this.date;
        } else
            chain = "Départ : " + departure + " -- Destination : " + destination+" Tarif : "+price+" Date: "+this.date;

        return chain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, departure);
    }
}
