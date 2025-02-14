package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Activity2 {

	// POST https://petstore.swagger.io/v2/user
	// GET https://petstore.swagger.io/v2/user/{username}
	// DEL https://petstore.swagger.io/v2/user/{username}

	@Test(priority = 1)
	public void addNewUserFromFile() throws IOException {
		// Import JSON file
		FileInputStream inputJSON = new FileInputStream("src/test/java/activities/userInfo.json");

		Response response = given().baseUri("https://petstore.swagger.io/v2/user") // Set base URI
				.header("Content-Type", "application/json") // Set headers
				.body(inputJSON) // Pass request body from file
				.when().post(); // Send POST request

		inputJSON.close();
		
		// Assertion
				response.then().body("code", equalTo(200));
				response.then().body("message", equalTo("1991"));

	}

	@Test(priority = 2)
	public void getUserInfo() {
		// Import JSON file to write to
		File outputJSON = new File("src/test/java/activities/userGETResponse.json");

		// Create a response object
		Response response = given(). // Request specifications
				baseUri("https://petstore.swagger.io/v2/user"). // constant part of the request(Url)
				header("Content-Type", "application/json"). // the details giving is in JSON format
				pathParam("username", "ampriya"). // Pass request body from file
				when().get("/{username}"); // send request and receive response

		// Get response body
		String resBody = response.getBody().asPrettyString();
		try {
			// Create JSON file
			outputJSON.createNewFile();
			// Write response body to external file
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}

		// Assertion
		response.then().body("id", equalTo(1991));
		response.then().body("username", equalTo("ampriya"));
		response.then().body("firstName", equalTo("priya"));
		response.then().body("lastName", equalTo("pradeep"));
		response.then().body("email", equalTo("ampriya110@gmail.com"));
		response.then().body("password", equalTo("ampriya123"));
		response.then().body("phone", equalTo("9789152434"));
	}

	@Test(priority = 3)

	public void deleteUserInfo() throws IOException {
		Response response = given().baseUri("https://petstore.swagger.io/v2/user") // Set base URI
				.header("Content-Type", "application/json") // Set headers
				.when().pathParam("username", "ampriya") // Set path parameter
				.delete("/{username}"); // Send POST request

		// Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("ampriya"));
	}
}
