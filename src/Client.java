class Client {
    private final ID id;
    private final String clientName;

    Client(String clientName){
        this.id = new ID();
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }
    public ID getId() {
        return id;
    }
}
