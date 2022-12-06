import java.util.UUID;

class ID {
    //Value Object
    private final String id;

    ID(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
