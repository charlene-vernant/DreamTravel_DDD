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
                displayDestinationDeparture();
                displayCreateTravel();
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

    public void displayDestinationDeparture() {
        System.out.println("Voici la listes des départs et destinations possibles : ");
        // Liste qui va contenir la liste des villes contenues dans le fichier JSON
        ArrayList<String> cities = new ArrayList<String>();
        JSONParser parser = new JSONParser();
        ArrayList catalog = new ArrayList<>();
        try {
            Reader reader = new FileReader("src/catalog.json");
            Object jsonObj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) jsonObj;
            catalog = (ArrayList) jsonObject.get("catalog");
            for (int i = 0; i < catalog.size(); i++) {
                JSONObject city = (JSONObject) catalog.get(i);
                cities.add((String)city.get("departure"));
            }
            
            @SuppressWarnings("unchecked")
            Iterator<String> it = cities.iterator();
            while (it.hasNext()) {
                System.out.println(">> " + it.next());
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        
    }
    
    public void displayCreateTravel() {
        // Client currentClient = createUser();
        // System.out.println(currentClient);
        System.out.println(">>> Commencez par indiquer votre destination : ");
        String destination = saisieChaine();
        System.out.println(">>> D'où souhaitez vous partir ? : ");
        String departure = saisieChaine();
        displayCatalog(departure,destination);
        
    }
    public void displayCatalog(String departure,String destination){
        System.out.println(">>> Voici la liste des vols disponibles");
        // Fonction de vols

        



        System.out.println(">>>> Vol direct :");
        System.out.println(">>>> Vol avec escale :");
        System.out.println(">>>> Quel est votre choix ? ");
        int choice = saisieEntier();
    }
    /*
     * public Client createUser() {
     * System.out.println(">>> Quel est votre nom ? : ");
     * String currentName = saisieChaine();
     * Client currentClient = new Client(currentName);
     * return currentClient;
     * }
     */
        /* String departure = "Tokyo";
        String destination = "Delhi";
        
        for (int i = 0; i < catalog.size(); i++){
            JSONObject city = (JSONObject) catalog.get(i);
            if (city.get("departure").toString().equals(departure)){
                ArrayList<String> destinations = (ArrayList<String>) city.get("destination");

                for (int e = 0; e < destinations.size(); e++){
                    //System.out.println(destinations.get(e));
                    if (destinations.get(e).toString().equals(destination)){
                        //System.out.println("yay");
                    }
                }
            }
        }
        ArrayList<String> stopovers= findStopover(departure, destination);
        for(int stopover=0; stopover<stopovers.size(); stopover++){
            System.out.println(stopovers.get(stopover));
        }
    } */
    public void createFlight() {
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

    public void displayChoiceService() {
        System.out.println(">>> 1 : Sans service");
        System.out.println(">>> 2 : Avec service");
    }

    

    public int displayEscaleCatalog() {
        // retourne un int avec le choix des escales en fonction de ce qui est renté en
        // parametre
        System.out.println("Catalogue des voyages avec escale, Faire un choix int : ");
        int choiceCatalog = saisieEntier();
        System.out.println("Vous avez choisi le vol : " + choiceCatalog);
        return choiceCatalog;
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

    public void finalComand() {
        System.out.println("le prix de la commande est prix");
    }

    
        

    public static ArrayList parseCatalog(){
        JSONParser parser = new JSONParser();
        ArrayList catalog = new ArrayList<>();
        try {
            Reader reader = new FileReader("src/catalog.json");
            Object jsonObj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) jsonObj;
            catalog = (ArrayList) jsonObject.get("catalog");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public static boolean isDirectFlightPossible(String departure, String destination) {
        boolean isPossible = false;
        if (departureHasDestination(departure, destination)){
            isPossible = true;
        }
        return isPossible;
    }

    public static boolean catalogHasDeparture(String departure){
        boolean hasDeparture = false;
        ArrayList catalog = parseCatalog();
        for (int i = 0; i < catalog.size(); i++){
            JSONObject city = (JSONObject) catalog.get(i);
            if (city.get("departure").toString().equals(departure)){
                hasDeparture = true;
            }
        }
        return hasDeparture;
    }

    public static boolean departureHasDestination(String departure,String destination){
        boolean hasDestinaton = false;
        ArrayList catalog = parseCatalog();
        for (int i = 0; i < catalog.size(); i++){
            JSONObject city = (JSONObject) catalog.get(i);
            if (city.get("departure").toString().equals(departure)){
                ArrayList<String> destinations = (ArrayList<String>) city.get("destination");

                for (int e = 0; e < destinations.size(); e++){
                    if (destinations.get(e).toString().equals(destination)){
                        hasDestinaton = true;
                    }
                }
            }
        }
        return hasDestinaton;
    }

    public static ArrayList<String> findStopover(String departure, String destination) {
        ArrayList<String> stopovers = new ArrayList<String>();
        ArrayList catalog = parseCatalog();
        for (int i = 0; i < catalog.size(); i++){
            JSONObject city = (JSONObject) catalog.get(i);
            if (city.get("departure").toString().equals(departure)){
                ArrayList<String> destinations = (ArrayList<String>) city.get("destination");
                for (int e = 0; e < destinations.size(); e++){
                    String stopover = destinations.get(e).toString();
                    if (departureHasDestination(stopover, destination)){
                        stopovers.add(stopover);
                    }
                }
            }
        }
        return stopovers;
    }



}
