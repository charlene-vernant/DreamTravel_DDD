import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        displayHomeUser();
        int choice = saisieEntier();
        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1: {displayCreateTravel();
            }
                break;
            case 2:
                break;
            default:
                System.out.println(">>> [ERREUR] choix invalide");

        }
    }

    public static void displayHomeUser() {
        System.out.println(">>> 1 : Créer un nouveau voyage");
        System.out.println(">>> 2 : Afficher un voyage à partir de l'ID de commande");
        System.out.println(">>> 0 : Quitter l'application");
    }

    public static void displayCreateTravel() {
        Client currentClient = createUser();
        System.out.println(currentClient);
        
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
    public static Client createUser(){
        System.out.println(">>> Quel est votre nom ? : ");
        String currentName = saisieChaine();
        Client currentClient = new Client(currentName);
        return currentClient;
    }
    public static void createFlight() {
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
            //int flight2 = displayEscaleCatalog(); // rentrer un parametre pour afficher le bon catalogue
            // TODO faire la suite
        } else {
            System.out.println("[ERREUR] choix invalide");
            createFlight();;
        }
        ;
    }
    public static int choiceHotel(){return 0;}
    public static int choiceCar(){return 0;}
    public static int choiceClass(){
        System.out.println(">>> 1 : Première classe");
        System.out.println(">>> 2 : Classe éco");
        int flag = 0;
        int intClass = saisieEntier();
        if (intClass == 1) {
            flag = 1;
        } else if (intClass == 2) {
            flag = 2;
        } else {
            System.out.println("[ERREUR] choix invalide");
            choiceClass();
        }
        return flag;
    }

    public static void displayChoiceService(){
        System.out.println(">>> 1 : Sans service");
        System.out.println(">>> 2 : Avec service");
    }

    public static int displayCatalog(){
        //retourne un int avec le choix du voyage 
        // demander 1er ou deuxieme classe;
        return 0;
    }
    public static int displayEscaleCatalog(){
        //retourne un int avec le choix des escales en fonction de ce qui est renté en parametre
        
        return 0;
    }
    public static int saisieEntier() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            int num = Integer.parseInt(chaine);
            return num;
        } catch (IOException e) {
            return 0;
        }
    }

    public static String saisieChaine() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            return chaine;
        } catch (IOException e) {
            System.out.println(" impossible de travailler" + e);
            return null;
        }
    }
    public static void finalComand(){
        System.out.println("le prix de la commande est prix");
    }
}