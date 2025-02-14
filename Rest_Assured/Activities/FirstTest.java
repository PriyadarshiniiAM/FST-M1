package examples;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

//baseUri   constant part of the request(Url) 
//header  the details giving is in JSON format.

public class FirstTest {
	// GET https://petsroe.swagger.io/v2/pet/findByStatus?status=alive
	
	@Test
	public void getRequestWithQueryParam() {
		// Create a response object
		Response response = 
		given(). // Request specifications
				baseUri("https://petstore.swagger.io/v2/pet").   //constant part of the request(Url) 
				header("Content-Type", "application/json").   //the details giving is in JSON format
				queryParam("status", "alive"). 
		when(). // send request and receive response
				get("/findByStatus");
		
		//Print the status code
		System.out.println(response.getStatusCode());
		// Print the response body
		System.out.println(response.getBody().asString());
		System.out.println(response.getBody().asPrettyString()); 
		//Print the response Header
		System.out.println(response.getHeaders().asList());
		//Extract the values from the response
		String petStatus = response.then().extract().path("[0].status");
		//Print and assert the pet status
		assertEquals(petStatus, "alive");
		
		//RESTAssured Assertion
		response.then().statusCode(200).body("[0].status", equalTo("alive"));
		
	}
	
	//https://petstore.swagger.io/v2/pet/{petId}
	@Test
	public void getRequestWithPathParam()
	{
		//Send request, receive response and perform assertions
		given().
			baseUri("https://petstore.swagger.io/v2/pet").
			header("Content-Type", "application/json").
			pathParam("petId", 77232).
			log().all().   //to print response 
		when().
			get("/{petId}").    //name in pathparam and get should be same (petId).
		then().
			statusCode(200).
			body("name", equalTo("Hansel")).
			log().all();   //to print response
			
	}
}
