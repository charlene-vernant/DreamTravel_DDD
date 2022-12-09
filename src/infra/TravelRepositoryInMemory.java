package infra;

import java.util.HashSet;
import java.util.Set;
import domain.ID;
import domain.Travel;
import domain.TravelRepository;

public class TravelRepositoryInMemory implements TravelRepository {
    private Set<Travel> memory;

    public TravelRepositoryInMemory() {
        this.memory = new HashSet<>();
    }

    @Override
    public void addTravel(Travel travel) {
        this.memory.add(travel);
    }



    @Override
    public Travel findTravelById(String id) {
        for (Travel travel : this.memory){
            ID tmp = travel.getId();
            if(tmp.toString().equals(id)){
                System.out.println(travel);
                return travel;
            }
        }
        System.out.println("Erreur : mauvais identifiant ou inexistant");         
        return null;
    }
   
}
