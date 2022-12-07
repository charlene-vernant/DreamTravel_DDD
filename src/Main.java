import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    

    JSONParser jsonParser = new JSONParser();
      try {
         //Parsing the contents of the JSON file
         JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/catalog.json"));
         //Forming URL
         System.out.println("Contents of the JSON are: ");
         System.out.println("depature: "+jsonObject.get("departure"));
         //Retrieving the array
         JSONArray jsonArray = (JSONArray) jsonObject.get("destination");
         System.out.println("");
         System.out.println("destination details: ");
         //Iterating the contents of the array
         Iterator<String> iterator = jsonArray.iterator();
         while(iterator.hasNext()) {
            System.out.println(iterator.next());
         }
    }catch(FileNotFoundException e){
        e.printStackTrace();
    } catch(IOException e){
        e.printStackTrace();
    
    } catch (org.json.simple.parser.ParseException e) {
        e.printStackTrace();
    }
    }
    //new UI();}
}

