package DifferentWaysToPost;

import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJO {
	
	@Test
	public void createProject()
	{
		JavaLibrary jLib = new JavaLibrary();
		baseURI= "http://localhost";
		port= 8084;
		
		//step1: create pre requisite
		ProjectLibrary pLib= new ProjectLibrary("VSBeelagi", "Hubli"+jLib.getRandomNumber(), "Completed", 15);
				
		given()
			.body(pLib)
			.contentType(ContentType.JSON)
			
		.when()
			.post("/addProject")
			
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}

}
