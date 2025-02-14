package examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

//Request and Response Specification

public class SpecificationTest {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petId = 0;
	
	@BeforeClass
	public void setUp() {
		//Req Specifications
		requestSpec = new RequestSpecBuilder().
			setBaseUri("https://petstore.swagger.io/v2/pet").
			addHeader("Content-Type", "application/json").
			build();
		//Response specifications
		responseSpec = new ResponseSpecBuilder().
			expectStatusCode(200).
			expectResponseTime(lessThanOrEqualTo(3000L)).
			build();
	}
	
	//POST https://petstore.swagger.io/v2/pet
	@Test(priority = 1)
	
	public void postRequest() {
		HashMap<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 77141);
		reqBody.put("name", "rainbow");
		reqBody.put("status", "alive");
		
		Response response = given()
				.spec(requestSpec) //Add request body
				.body(reqBody) // Add request body
				.when().post(); // Send POST request
		
		//Extract the petId
		petId = response.then().extract().path("id");
		
		// Assertion
				response.then().spec(responseSpec).body("status", equalTo("alive"));
	}
	
	//GET https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 2)
	
	public void getRequest() {
		// Create a response object
				given().spec(requestSpec).pathParam("petId", petId). // Request specifications 
				when().get("/{petId}"). // send request and receive response
				then().spec(responseSpec).body("status", equalTo("alive"));
	}
	
	//DELETE https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 3)
	public void deleteRequest() {
			given().spec(requestSpec).pathParam("petId", petId).
				when().delete("/{petId}").
				then().spec(responseSpec).body("message", equalTo(""+petId));
		
	}

}
