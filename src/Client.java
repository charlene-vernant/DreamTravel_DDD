class Client {
    // ValueObject 
    private final String clientName;

    Client(String clientName){
        
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }
  
}
