package urlReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;

public class MonMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*URL google = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Fes"+
							"&destinations=Rabat|Meknes|Casablanca"+
							"&departure_time=1541202457"+
							"&traffic_model=best_guess"+
							"&key=AIzaSyCAS81Ko8cQRtfcoqs9mB0JujnbN5utNNc");*/
        
		JsonReader reader = Json.createReader(new FileReader("testJson"));
		JsonStructure jst = reader.read();
		//JsonParser parser = Json.createParser(new StringReader(jst.toString()));
		//reader.read()
		System.out.println(jst.toString());
		
		/*while (parser.hasNext()) {
			   JsonParser.Event event = parser.next();
			   switch(event) {
			      case START_ARRAY:
			      case END_ARRAY:
			      case START_OBJECT:
			      case END_OBJECT:
			      case VALUE_FALSE:
			      case VALUE_NULL:
			      case VALUE_TRUE:
			         System.out.println(event.toString());
			         break;
			      case KEY_NAME:
			    	  if(event.toString()=="destination_addresses"){
			    		  System.out.print(event.toString() + " " +
			                          parser.getString() + " - ");
			    		  break;
			    	  }
			         
			         
			      case VALUE_STRING:
			      case VALUE_NUMBER:
			         System.out.println(event.toString() + " " +
			                            parser.getString());
			         break;
			   }
			}*/
		//navigateTree(reader, "destination_addresses");
//		BufferedReader in = new BufferedReader(
//        new InputStreamReader(google.openStream()));
//
//        String inputLine;
//        while ((inputLine = in.readLine()) != null)
//            System.out.println(inputLine);
//        in.close();
	}
	public static void navigateTree(JsonValue tree, String key) {
		   if (key != null)
		      System.out.print("Key " + key + ": ");
		   switch(tree.getValueType()) {
		      case OBJECT:
		         System.out.println("OBJECT");
		         JsonObject object = (JsonObject) tree;
		         for (String name : object.keySet())
		            navigateTree(object.get(name), name);
		         break;
		      case ARRAY:
		         System.out.println("ARRAY");
		         JsonArray array = (JsonArray) tree;
		         for (JsonValue val : array)
		            navigateTree(val, null);
		         break;
		      case STRING:
		         JsonString st = (JsonString) tree;
		         System.out.println("STRING " + st.getString());
		         break;
		      case NUMBER:
		         JsonNumber num = (JsonNumber) tree;
		         System.out.println("NUMBER " + num.toString());
		         break;
		      case TRUE:
		      case FALSE:
		      case NULL:
		         System.out.println(tree.getValueType().toString());
		         break;
		   }
		}
}
