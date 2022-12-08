package domain;

public interface TravelRepository {
    
    public void addTravel(Travel travel);
    public Travel findTravelById(String id);
}
