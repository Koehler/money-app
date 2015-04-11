package de.koehler.money;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.koehler.money.entity.Account;

public class PoorMansHelper {

	public static void main(String[] args) {
		callRestClient();
	}
	
	private static final String REST_SERVICE_URL = "http://localhost:8081/money-server/resources/";
	
	private static final void craeteJSon(){
		Account obj = new Account();
		obj.setName("DKB");
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		 
		// convert java object to JSON format,
		// and returned as JSON formatted string
		String json = gson.toJson(obj);
		System.out.println(json);
	}
	
	
	private static final void callRestClient(){
		try {

			Account st = new Account();
			st.setName("DKB");
			
			
			Client client = ClientBuilder.newClient(new ClientConfig());
		    WebTarget target = client.target(REST_SERVICE_URL);
		    Response response = target.request().buildPost(Entity.entity(st, MediaType.APPLICATION_JSON)).invoke();

			

			Object output = response.getEntity();

			System.out.println("Server response .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
