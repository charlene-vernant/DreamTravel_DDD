package domain;

import java.time.LocalDate;

public class Flight {
    // ValueObject
    private final City departure;
    private final City destination;
    private final int classe;
    private final float price;
    private final LocalDate date;

    Flight(City departure, City destination, int classe, float price, LocalDate date) {
        this.departure = departure;
        this.destination = destination;
        this.classe = classe;
        if (classe == 1) {
            this.price = price *= 1.3;
        } else {
            this.price = price;
        }
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public int getClasse() {
        return classe;
    }

    public City getDeparture() {
        return departure;
    }

    public City getDestination() {
        return destination;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object obj){
            if (obj != null
            && this.getClass()==obj.getClass()
            && this.getPrice()==(( (Flight) obj).getPrice())
            && this.getDeparture().equals(((Flight) obj).getDeparture())
            && this.getClasse()==(((Flight) obj).getClasse())
            && this.getDestination().equals(((Flight) obj).getDestination())) return true;
            return false;
        }
    @Override 
    public String toString() {
        String chain = "";
        chain += "Départ : " + departure + " | Destination : " + destination + " | Classe : " + classe+ " | Prix : "+price+" | Date : " + date;
        return chain;
    }
}
