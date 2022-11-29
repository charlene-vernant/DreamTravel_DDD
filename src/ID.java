import java.util.UUID;

public class ID {
    //Value Object
    String id;

    ID(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
