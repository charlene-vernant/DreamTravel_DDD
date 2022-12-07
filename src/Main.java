import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import UI.UI;

//Le main appelle l'interface utilisateur

public class Main {
   
        public static void main(String[] args) {
            System.out.println("Catalogue des voyages sans escale, Faire un choix int : ");
            //int choiceCatalog = saisieEntier();
            //System.out.println("Vous avez choisi le vol : " + choiceCatalog);
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
                    System.out.println("City = " + it.next());
                }
            }catch(FileNotFoundException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            
            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
            String departure = "Bordeaux";
            String destination = "Paris";
            
            
            System.out.println("end function" + catalogHasDeparture(departure));
            System.out.println("end 2 fonction " + catalogHasDestination(departure, destination));
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
    
        public static boolean catalogHasDeparture(String departure){
            boolean hasDeparture = false;
            ArrayList catalog = parseCatalog();
            for (int i = 0; i < catalog.size(); i++){
                JSONObject city = (JSONObject) catalog.get(i);
                if (city.get("departure").toString().equals(departure)){
                    hasDeparture = true;
                    System.out.println("test departure"+hasDeparture);
                }
            }
            return hasDeparture;
        }
    
        public static boolean catalogHasDestination(String departure,String destination){
            boolean hasDestinaton = false;
            ArrayList catalog = parseCatalog();
            for (int i = 0; i < catalog.size(); i++){
                System.out.println("dans le for");
                JSONObject city = (JSONObject) catalog.get(i);
                if (catalogHasDeparture(departure)){
                    System.out.println("'dans le if 1'");
                    ArrayList<String> destinations = (ArrayList<String>) city.get("destination");
                    for (int e = 0; e < destinations.size(); e++){
                        if (destinations.get(e).toString().equals(destination)){
                            hasDestinaton = true;
                            System.out.println("yay"+hasDestinaton);
                        }
                    }
                }
            }
            return hasDestinaton;
        }

}
