#!/bin/bash     
javac src/domain/ID.java src/domain/Client.java src/domain/City.java src/domain/Room.java src/domain/CarModel.java src/domain/Hotel.java src/domain/RentalCar.java src/domain/Flight.java src/domain/Ticket.java -cp "src/json-simple-1.1.1" src/domain/Catalog.java src/domain/Travel.java src/domain/TravelRepository.java src/infra/*.java src/UI/*.java src/Main.java
cd src
java -cp .:json-simple-1.1.1 Main
