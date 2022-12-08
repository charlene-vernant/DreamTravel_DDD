package domain;

public class Flight {
    // ValueObject
    private final City departure;
    private final City destination;
    private final int classe;
    
    Flight(City departure, City destination, int classe) {
        this.departure = departure;
        this.destination = destination;
        this.classe = classe;
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

    public String toString() {
        String chain = "";
        chain += "Départ : " + departure + "--Destination : " + destination +"classe : "+classe;
        return chain;
    }
}
