package API.functions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import API.tests.BaseTestAPI;
import Common.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIFunctions extends BaseTestAPI{
	
	public APIFunctions() 
	{}

	
	public static Response Put(String url, String body) 
	{
		System.out.println("put "+url+" "+body);
		
		Response response = RestAssured.given()
		         .header("Content-Type", "application/json")
		         .cookie(adminjsCookie)
		         .body(body)
		         .when()
		         .put(url)
		         .then()
		         .extract().response();
		 return response;
	}
	
	public static Response Delete(String URL)
	{	
		System.out.println("DELETE "+URL);

		Response response = RestAssured.given()
				.cookie(adminjsCookie)
                .header("Content-Type", "application/json")
                .when()
                .post(URL)
                .then()
                .extract().response();
			return response;
	}
	
	
	public static Response Get(String APIRequestName) 
	{
		System.out.println("GET "+APIRequestName);
	 
			Response response = RestAssured.given()
				 .cookie(adminjsCookie)
		         .header("Content-Type", "application/json")
		         .when()
		         .get(APIRequestName)
		         .then()
		         .extract().response();
			 return response;
	}
	
	public static Response Post(String APIRequestURL, String requestBody) 
	{
		System.out.println("POST "+APIRequestURL+" "+requestBody);
		
		Response response = RestAssured.given()
					.cookie(adminjsCookie)
	                .header("Content-Type", "application/json")
	                .body(requestBody)
	                .when()
	                .post(APIRequestURL)
	                .then()
	                .extract().response();
		 return response;
	}
	
	public static <T> String convertObjectToJson(T object) throws JsonProcessingException {
	    ObjectMapper mapper = new ObjectMapper();
	    
	    try {
	        // convert object to json string and return it
	        return mapper.writeValueAsString(object);
	    } catch (JsonProcessingException e) {
	        // catch errors
	        e.printStackTrace();
	        throw e; // rethrow the exception
	    }
	}



	
}
