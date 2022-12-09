
package UI;

import domain.*;
import infra.TravelRepositoryInMemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
    Catalog catalog = new Catalog(); 
    Travel travel; 
    TravelRepository repository = new TravelRepositoryInMemory(); 
    public UI() {
        displayHomeUser();
    }

    public void displayTravelByID(TravelRepository travel, String id) {
        System.out.println(">>> Votre voyage : ");
        travel.findTravelById(id);
    }

    public void displayHomeUser() {
        while (true) {
            System.out.println(">>> 1 : Créer un nouveau voyage");
            System.out.println(">>> 2 : Afficher un voyage à partir de l'ID de commande");
            System.out.println(">>> 0 : Quitter l'application");
            int choice = saisieEntier();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1: {
                    String name = menuNewClient();
                    travel = new Travel(name);
                    displayDestinationDeparture(); 
                    displayCreateTravel(); 
                    travel.updatePrice();
                    displayTravel();
                    AddTravelToRepository(repository, travel);
                }
                    break;
                case 2: {
                    System.out.println(">>> ID du voyage : ");
                    String input = saisieChaine();
                    displayTravelByID(repository, input);
                }
                    break;
                default:
                    System.out.println(">>> [ERREUR] choix invalide");

            }
        }
    }

    public void AddTravelToRepository(TravelRepository repository, Travel travel) {
        this.repository = repository;
        repository.addTravel(travel);
        
    }

    public String menuNewClient() {
        System.out.println(">>> Veuillez entrez votre nom : ");
        String currentName = saisieChaine();
        System.out.println(">>> Parfait " + currentName + " maintenant veuillez-choisir un vol");
        return currentName;
    }

    public void displayDestinationDeparture() {
        System.out.println(">>> Voici la listes des départs et destinations possibles : ");
        catalog.displayCity();

    }

    public void displayCreateTravel() {
        System.out.println(">>> Commencez par indiquer votre destination : \n");
        int choiceDestination = saisieEntier();
        City destination = catalog.getDepartureDestination().get(choiceDestination);
        System.out.println(">>> D'où souhaitez vous partir ? : ");
        int choiceDeparture = saisieEntier();
        City departure = catalog.getDepartureDestination().get(choiceDeparture);
        displayCatalog(departure, destination);

    }

    public void displayCatalog(City departure, City destination) {
        System.out.println(">>> Voici la liste des vols disponibles");
        catalog.displayResearchTicketCatalog(departure, destination);
        System.out.println(">>>> Quel est votre choix ? (choisir parmi les nombres à gauche)");
        int choiceTicket = saisieEntier();
        int classe = choiceClass();
        Ticket ticket = catalog.getCatalogTicket().get(choiceTicket);
        createFlight(ticket, classe);
    }

    public float usePoolTicket(float currentPrice){
        if(catalog.poolIsAvailable()){
            currentPrice = (float)(currentPrice-(0.2*currentPrice));
            catalog.usePoolTicket();
        }
        return currentPrice;
    }

    public int delayForNextFlight(City transit){
        System.out.println(">>> Combien de jours voulez vous rester à " + transit);
        int delayForNextFlight = saisieEntier();
        return delayForNextFlight;
    }

    public void createFlight(Ticket ticket, int classe) {
        if (ticket.getTransit() != null) {
            // Multiple Flight
            float tmpPrice = usePoolTicket(ticket.getPrice()); 
            int delayForNextFlight = delayForNextFlight(ticket.getTransit());         
            travel.addFlight(ticket.getDeparture(), ticket.getTransit(), classe, tmpPrice, ticket.getDate());
            travel.addFlight(ticket.getTransit(), ticket.getDestination(), classe, tmpPrice, ticket.getDate().plusDays(delayForNextFlight));
            choiceServiceMultiple();
            
            
        } else {
            // Single Flight
            float tmpPrice = usePoolTicket(ticket.getPrice());            
            travel.addFlight(ticket.getDeparture(), ticket.getDestination(), classe, tmpPrice, ticket.getDate());
            choiceServiceSimple();
        }
    }

    public int choiceClass() {
        System.out.println(">>> 1 : Première classe (prix du vol majoré à 30%)");
        System.out.println(">>> 2 : Classe éco");
        int flag = 0;
        int intClass = saisieEntier();
        if (intClass == 1) {
            flag = 1;
            System.out.println(">>> Vous avez selectionné un vol en première classe");
        } else if (intClass == 2) {
            flag = 2;
            System.out.println(">>> Vous avez selectionné un vol en classe eco");
        } else {
            System.out.println(">>> [ERREUR] choix invalide");
            choiceClass();
        }
        return flag;
    }

    public void displayTravel() {
        System.out.println(travel.toString());
    }

    public void displayService(int nombreService){
        for (int i = 0; i < nombreService; i++){
            System.out.println(">>> Choix des services pour la destination "+i+" :");
            displayHotelCatalog();
            displayCarCatalog();
        }
    }
    public void displayChoiceServiceSimple(){
        System.out.println(">>> 1 : Sans service - Aucun hotel et voiture");
        System.out.println(">>> 2 : Avec service simple - 1 hotel et 1 voiture pour la destination");
        System.out.println(">>> Quel est votre choix ? ");
    }

    public void choiceServiceSimple() {
        displayChoiceServiceSimple();
        int choiceService = saisieEntier();
        switch(choiceService){
            case 1:
                System.out.println(">>> Vous avez choisi de prendre aucun service");
                break;
            case 2:
                System.out.println(">>> Vous avez choisi de prendre 1 hotel et 1 voiture");
                displayService(1);
                break;
            default:
                System.out.println(">>> [ERREUR] choix invalide");
        }
    }
    public void displayChoiceServiceMultiple() {
        System.out.println(">>> 1 : Sans service ");
        System.out.println(">>> 2 : Avec service simple - 1 hotel et 1 voiture pour 1 seule destination");
        System.out.println(">>> 3 : Avec service deluxe - 1 hotel et 1 voiture pour les 2 destinations");
        System.out.println(">>> Quel est votre choix ? ");
    }
    public void choiceServiceMultiple(){
        displayChoiceServiceMultiple();
        int choiceService = saisieEntier();
        switch(choiceService){
            case 1:
                System.out.println(">>> Vous avez choisi de prendre aucun service");
                break;
            case 2:
                System.out.println(">>> Vous avez choisi de prendre 1 hotel et 1 voiture");
                displayService(1);
                break;
            case 3:
                System.out.println(">>> Vous avez choisi de prendre 1 hotel et 1 voiture à chaque destination");
                displayService(2);
                break;
            default:
                System.out.println(">>> [ERREUR] choix invalide");
        }
    }

    public void displayHotelCatalog(){
        System.out.println(">>> Voici la liste des hotels");
        catalog.displayHotelCatalog();
        System.out.println(">>> Quel est votre choix ? ");
        int choiceHotel = saisieEntier();
        catalog.displayRoomCatalog(choiceHotel);
        int choiceRoom = saisieEntier();
        System.out.println(catalog.getHotelID(choiceHotel));
        System.out.println(catalog.getRoom(choiceHotel, choiceRoom));
        travel.addHotel(catalog.getHotelID(choiceHotel), catalog.getRoom(choiceHotel, choiceRoom));  
    }

    public void displayCarCatalog(){
        System.out.println(">>> Voici la liste des loueurs de voitures");
        catalog.displayCarCatalog();
        System.out.println(">>> Quel est votre choix ? ");
        int choiceCar = saisieEntier();
        catalog.displayModelCatalog(choiceCar);
        int choiceModel = saisieEntier();
        travel.addRentalCar(catalog.getCarID(choiceCar), catalog.getModel(choiceCar, choiceModel));
    }

    public int saisieEntier() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            int num = Integer.parseInt(chaine);
            return num;
        } catch (IOException e) {
            return 0;
        }
    }

    public String saisieChaine() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            return chaine;
        } catch (IOException e) {
            System.out.println(">>> impossible de travailler" + e);
            return null;
        }
    }
}

