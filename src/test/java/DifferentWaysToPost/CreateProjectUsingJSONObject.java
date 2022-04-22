package DifferentWaysToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingJSONObject {
	
	@Test
	public void createProject()
	{
		JavaLibrary jLib = new JavaLibrary();
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Vijayalaxmi");
		jObj.put("projectName", "abc"+jLib.getRandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 10);
		
		baseURI= "http://localhost";
		port= 8084;
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		
	.when()			//step2: perform action
		.post("/addProject")
		
		
	.then()			//step3: Validation
		.assertThat().statusCode(201)
		.log().all();
	}

}
