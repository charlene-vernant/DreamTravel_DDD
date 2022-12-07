package domain;

import java.util.Objects;

class Client {
    // ValueObject : pas de setter
    private final String clientName;

    Client(String clientName){
        
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }
    
    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Client)) return false;
        Client otherClient = (Client) other;
        boolean sameName = this.clientName == otherClient.getClientName();
        return sameName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName);
    }
}
