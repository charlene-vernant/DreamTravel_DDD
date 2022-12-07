package domain;
import java.util.Objects;
import java.util.UUID;

public class ID {
    //Value Object
    private final String id;

    ID(){
        this.id = UUID.randomUUID().toString();
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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
