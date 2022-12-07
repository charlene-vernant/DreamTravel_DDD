package UI;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import domain.*;

public class UI {
    Catalog catalog = new Catalog();
    Travel travel;

    public UI() {
        displayHomeUser();
    }

    public void displayTravelByID(int ID) {
        System.out.println("Votre voyage : ....."); // TODO0

    }

    public void displayHomeUser() {
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
                displayTravel();
            }
                break;
            case 2: {
                displayTravelByID(1);
            }
                break;
            default:
                System.out.println(">>> [ERREUR] choix invalide");

        }
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
        System.out.println("fdp");
        travel.toString();
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
