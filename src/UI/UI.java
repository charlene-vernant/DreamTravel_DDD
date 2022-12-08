package UI;

import domain.*;
import infra.TravelRepositoryInMemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UI {
    Catalog catalog = new Catalog(); // voir ou le mettre
    Travel travel; // Voir ou le mettre
    TravelRepository repository = new TravelRepositoryInMemory(); // voir ou le mettre
    public UI() {
        displayHomeUser();
    }

    //BUG
    public void displayTravelByID(TravelRepository travel, String id) {
        ID newID = new ID(id);
        System.out.println("Votre voyage : ");
        travel.findTravelById(newID);
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
                    displayDestinationDeparture(); // affiche la liste des destination/depart
                    displayCreateTravel(); // va afficher la liste des vols
                    displayService();// affiche les services : hotel, voiture
                    displayTravel();
                    AddTravelToRepository(repository, travel);
                    //this.repository.findTravelById(id);
                }
                    break;
                case 2: {
                    System.out.println("ID du voyage : ");
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
        travel.toString();
        repository.addTravel(travel);
        
    }
    //bug
    public void GetTravelFromRepository(TravelRepository repository, ID id){
        repository.findTravelById(id);
    }
    public String menuNewClient() {
        System.out.println("Veuillez entrez votre nom : ");
        String currentName = saisieChaine();
        System.out.println("Parfait " + currentName + " maintenant tu vas choisir un vol batar");
        return currentName;
    }

    public void displayDestinationDeparture() {
        System.out.println("Voici la listes des départs et destinations possibles : ");
        catalog.addCity();
        catalog.displayCity();

    }

    public void displayCreateTravel() {
        System.out.println(">>> Commencez par indiquer votre destination : ");
        int choiceDestination = saisieEntier();
        City destination = catalog.getDepartureDestination().get(choiceDestination);
        System.out.println(">>> D'où souhaitez vous partir ? : ");
        int choiceDeparture = saisieEntier();
        City departure = catalog.getDepartureDestination().get(choiceDeparture);
        displayCatalog(departure, destination);

    }

    public void displayCatalog(City departure, City destination) {
        // Listes de vols
        System.out.println(">>> Voici la liste des vols disponibles");
        catalog.researchTicket(departure, destination);
        catalog.displayTicketCatalog();
        System.out.println(">>>> Quel est votre choix ? ");
        int choiceTicket = saisieEntier();
        int classe = choiceClass();
        // creer nouveau vol
        Ticket ticket = catalog.getCatalogTicket().get(choiceTicket);
        createFlight(ticket, classe);
    }

    public void createFlight(Ticket ticket, int classe) {
        if (ticket.getTransit() != null) {
            System.out.println("vol multiple");
            travel.addFlight(ticket.getDeparture(), ticket.getTransit(), classe);
            travel.addFlight(ticket.getTransit(), ticket.getDestination(), classe);
        } else {
            System.out.println("vol direct");
            travel.addFlight(ticket.getDeparture(), ticket.getDestination(), classe);
        }
    }

    public int choiceHotel() {
        return 0;
    }

    public int choiceCar() {
        return 0;
    }

    public int choiceClass() {
        System.out.println(">>> 1 : Première classe");
        System.out.println(">>> 2 : Classe éco");
        int flag = 0;
        int intClass = saisieEntier();
        if (intClass == 1) {
            flag = 1;
            System.out.println("Vous avez selectionné un vol en première classe, majoration de 30%");
        } else if (intClass == 2) {
            flag = 2;
            System.out.println("Vous avez selectionné un vol en classe eco,  vous êtes pauvre");
        } else {
            System.out.println("[ERREUR] choix invalide");
            choiceClass();
        }
        return flag;
    }

    public void displayTravel() {
        System.out.println("display qui marche pas");
        System.out.println(travel.toString());
    }

    public void displayService(){
        ; 
        // retirer les service du catalogue et placer le tout dans service directement ?
    }
    public void displayChoiceService() {
        System.out.println(">>> 1 : Sans service");
        System.out.println(">>> 2 : Avec service");
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
            System.out.println(" impossible de travailler" + e);
            return null;
        }
    }
}
