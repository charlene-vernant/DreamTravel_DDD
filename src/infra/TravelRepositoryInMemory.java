package infra;

import java.util.HashMap;
import java.util.Map;

import domain.ID;
import domain.Travel;
import domain.TravelRepository;

public class TravelRepositoryInMemory implements TravelRepository {
    private Map<ID, Travel> memory;
    public TravelRepositoryInMemory(){
        memory = new HashMap<>();
    }
    @Override
    public void addTravel(Travel travel) {
        ID travelID = travel.getId();  
        if (!memory.containsKey(travelID)){
            memory.put(travelID,travel);
        }   
    }

    @Override
    public Travel findTravelById(ID id) {
        return memory.get(id);
    }
    

    
    
}
