package activities;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Activity1 {
	//POST: https://petstore.swagger.io/v2/pet
	//GET and DELETE https://petstore.swagger.io/v2/pet/{petId}
	
	@Test
	public void addNewPet() {
		HashMap<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 77141);
		reqBody.put("name", "rainbow");
		reqBody.put("status", "alive");
		
		Response response = given()
				.baseUri("https://petstore.swagger.io/v2/pet") // Set base URI
				.header("Content-Type", "application/json") // Set headers
				.body(reqBody) // Add request body
				.when().post(); // Send POST request
		
		// Assertion
				response.then().body("id", equalTo(77141));
				response.then().body("name", equalTo("rainbow"));
				response.then().body("status", equalTo("alive"));
	}

	@Test(priority = 2)
	public void getPetInfo() {
		// Create a response object
		Response response = 
		given(). // Request specifications
				baseUri("https://petstore.swagger.io/v2/pet").   //constant part of the request(Url) 
				header("Content-Type", "application/json").   //the details giving is in JSON format
				pathParam("petId", "77141"). 
		when(). // send request and receive response
				get("/{petId}");
		
		// Assertion
		response.then().body("id", equalTo(77141));
		response.then().body("name", equalTo("rainbow"));
		response.then().body("status", equalTo("alive"));
	}
	
	@Test(priority = 3)
	public void deletePet() {
		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/pet") // Set base URI
			.header("Content-Type", "application/json") // Set headers
			.when().pathParam("petId", 77141) // Set path parameter
			.delete("/{petId}"); // Send DELETE request
 
		// Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("77141"));
	}
}
		
