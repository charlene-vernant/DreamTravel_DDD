package domain;
import java.util.Objects;
import java.util.UUID;

public class ID {
    //Value Object
    
    private final String id;

    ID(){
        this.id = UUID.randomUUID().toString();
    }
    public ID(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof ID)) return false;
        ID otherID = (ID) other;
        boolean sameId = this.id == otherID.getId();
        return sameId ;
    }
    public String toString() {
        String chain = "" + id;
        return chain;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
