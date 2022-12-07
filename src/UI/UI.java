package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import domain.*;
public class UI {
    public UI(){displayHomeUser();}
    
    public  void displayTravelByID(int ID){
        System.out.println("Votre voyage : ....."); // TODO0

    }

    public  void displayHomeUser() {
        System.out.println(">>> 1 : Créer un nouveau voyage");
        System.out.println(">>> 2 : Afficher un voyage à partir de l'ID de commande");
        System.out.println(">>> 0 : Quitter l'application");
        int choice = saisieEntier();
        switch(choice){
                case 0:
                    System.exit(0);
                    break;
                case 1: {displayCreateTravel();
                }
                    break; 
                case 2:{displayTravelByID(1);}
                    break;
                default:
                    System.out.println(">>> [ERREUR] choix invalide");
    
            }
    }

    public  void displayCreateTravel() {
        //Client currentClient = createUser();
        //System.out.println(currentClient);

        System.out.println(">>> 1 : Vol direct");
        System.out.println(">>> 2 : Vol avec escale");
        int intChoice = saisieEntier();
        if (intChoice == 1) {
            createFlight();
        } else if (intChoice == 2) {
            createFlight();
        } else {
            System.out.println("[ERREUR] choix invalide");
            displayCreateTravel();
        }
    }

    /*public Client createUser() {
        System.out.println(">>> Quel est votre nom ? : ");
        String currentName = saisieChaine();
        Client currentClient = new Client(currentName);
        return currentClient;
    }*/

    public  void createFlight() {
        displayChoiceService();
        int choiceService = saisieEntier();
        if (choiceService == 1) {
            int flight = displayCatalog();
            int flightClass = choiceClass();
            finalComand(); // TODO : calculer le prix et enregister le vol et display le recap du vol

        } else if (choiceService == 2) {
            int flight = displayCatalog();
            int choiceCar = choiceCar();
            int choiceHotel = choiceHotel();
            // int flight2 = displayEscaleCatalog(); // rentrer un parametre pour afficher
            // le bon catalogue
            // TODO faire la suite
        } else {
            System.out.println("[ERREUR] choix invalide");
            createFlight();
            ;
        }
        ;
    }

    public  int choiceHotel() {
        return 0;
    }

    public  int choiceCar() {
        return 0;
    }

    public  int choiceClass() {
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

    public  void displayChoiceService() {
        System.out.println(">>> 1 : Sans service");
        System.out.println(">>> 2 : Avec service");
    }

    public  int displayCatalog() {
        // retourne un int avec le choix du voyage
        // demander 1er ou deuxieme classe;
        System.out.println("Catalogue des voyages sans escale, Faire un choix int : ");
        int choiceCatalog = saisieEntier();
        System.out.println("Vous avez choisi le vol : " + choiceCatalog);
        return choiceCatalog;
    }

    public  int displayEscaleCatalog() {
        // retourne un int avec le choix des escales en fonction de ce qui est renté en
        // parametre
        System.out.println("Catalogue des voyages avec escale, Faire un choix int : ");
        int choiceCatalog = saisieEntier();
        System.out.println("Vous avez choisi le vol : " + choiceCatalog);
        return choiceCatalog;
    }

    public  int saisieEntier() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            int num = Integer.parseInt(chaine);
            return num;
        } catch (IOException e) {
            return 0;
        }
    }

    public  String saisieChaine() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            return chaine;
        } catch (IOException e) {
            System.out.println(" impossible de travailler" + e);
            return null;
        }
    }

    public  void finalComand() {
        System.out.println("le prix de la commande est prix");
    }
}
