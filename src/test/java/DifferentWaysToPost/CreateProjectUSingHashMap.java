package DifferentWaysToPost;

import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUSingHashMap {
	
	@Test
	
	public void createProjectUSingHashMap()
	{
		JavaLibrary jLib = new JavaLibrary();
		baseURI= "http://localhost";
		port= 8084;
		
		HashMap map = new HashMap();
		map.put("createdBy", "VijayaB");
		map.put("projectName", "XYZ"+jLib.getRandomNumber());
		map.put("status", "Completed");
		map.put("teamSize", 10);
		
		given()
			.body(map)
			.contentType(ContentType.JSON)
		
		.when()
			.post("/addProject")
			
		.then()
			.assertThat().statusCode(201)
			.log().all();
		
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
