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
    

      try {
        JSONParser parser = new JSONParser();
		Reader reader = new FileReader("src/catalog.json");

		Object jsonObj = parser.parse(reader);

		JSONObject jsonObject = (JSONObject) jsonObj;

		String departure = (String) jsonObject.get("departure");
		System.out.println("dep = " + departure);

		

		JSONArray cities = (JSONArray) jsonObject.get("destination");
		
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
    }
    //new UI();}
}

