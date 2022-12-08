package domain;

public class Flight {
    // ValueObject
    private final City departure;
    private final City destination;
    private final int classe;
    private final int price;

    Flight(City departure, City destination, int classe, int price) {
        this.departure = departure;
        this.destination = destination;
        this.classe = classe;
        if (classe == 1) {
            this.price = price *= 1.3;
        } else {
            this.price = price;
        }
    }

    public int getPrice() {
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
        chain += "Départ : " + departure + "--Destination : " + destination + "classe : " + classe;
        return chain;
    }
}
