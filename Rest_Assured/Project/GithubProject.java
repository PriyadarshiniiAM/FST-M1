package Project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GithubProject {

	public String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHpcnzur8PHS3dEHYw5j1Dm3/mvBkXAN0pTL7Nyj4j8O";
	public int sshKeyId;
	public RequestSpecification requestSpec;
	public ResponseSpecification responseSpec;

	@BeforeClass
	public void setUp() {
	// Create request specification
	requestSpec = new RequestSpecBuilder()
			// Set base URL
			.setBaseUri("https://api.github.com/user/keys")
			.addHeader("Authorization", "token")
			// Set content type
			.addHeader("Content-Type", "application/json")
	
			// Build request specification
			.build();

	// Response Specification
	 responseSpec = new ResponseSpecBuilder()
			.expectResponseTime(lessThan(4000L))
			.expectBody("key", equalTo(sshKey))
			.expectBody("title", equalTo("TestAPIKey"))
			.build();
	}

	@Test(priority = 1)

	public void postRequestTest() {
		// path:https://api.github.com/user/keys
		// Request body
		HashMap<String, Object> reqBody = new HashMap<>();
		reqBody.put("title", "TestAPIKey");
		reqBody.put("key", sshKey);

		// Generate Response
		Response response = given()
				//.baseUri("https://api.github.com/user/keys/{keyId}") // Set base URI
				.spec(requestSpec) // Use requestSpec
				.body(reqBody) // Send request body
				.when().post();// Send POST request
		

		// Extract the id
		sshKeyId = response.then().extract().path("id");

		// Assertion
		response.then().spec(responseSpec).statusCode(201);
	}

	@Test(priority = 2)

	public void getRequestTest() {
		// path : https://api.github.com/user/keys/{keyId}
		// Generate Response
		// Assert
		given()
		.spec(requestSpec)
		.pathParam("keyId", sshKeyId)
		.when().get("/{keyId}")
		.then().spec(responseSpec).statusCode(200);

	}

	@Test(priority = 3)

	public void deleteRequestTest() {
		given().spec(requestSpec)
		.pathParam("keyId", sshKeyId)
		.when().delete("/{keyId}")
		.then().statusCode(204);
		

	}

}

