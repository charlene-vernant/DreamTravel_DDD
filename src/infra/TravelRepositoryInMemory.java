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

    public void updateTRavel(Travel travel) {
        this.memory.add(travel);
    }

    @Override
    public Travel findTravelById(ID id) {
        for (Travel travel : this.memory){
            System.out.println(travel.getId());
            if(travel.getId()==(id)){
                System.out.println("Found"); //
                System.out.println(travel);
                return travel;
            }
        }
        System.out.println("Erreur : mauvais identifiant ou inexistant");         
        return null;
    }
   
}
