package DifferentWaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateProjectUsingJSONFile {
	
	@Test
	public void createProject()
	{
		//step1: create pre requisites
		File file = new File(".\\Data.json");
		baseURI= "http://localhost";
		port= 8084;
		
		given()
			.body(file)
			.contentType(ContentType.JSON)
			
			
		.when()			//step2: perform action
			.post("/addProject")
			
			
		.then()			//step3: Validation
			.assertThat().statusCode(201)
			.log().all();
	}


	
}
