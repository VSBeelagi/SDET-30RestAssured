package RequestChaining;

import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreatePRojectAndDeleteProject {
	
	@Test
	public void createPRojectAndDeleteProject()
	{
		//step1: pre requisites
				JavaLibrary jLib= new JavaLibrary();
				ProjectLibrary pLib= new ProjectLibrary("Geetha", "Chrome"+jLib.getRandomNumber(), "Completed", 15);
				
				baseURI = "http://localhost";
				port = 8084;
				
				Response resp = given()
					.body(pLib)
					.contentType(ContentType.JSON)
				.when()
					.post("/addProject");
				
				//Capture the project ID
				String proId = resp.jsonPath().get("projectId");
				System.out.println(proId);
				resp.then().log().all();
				
				//create a get request and pass proId as path parameter
				given()
					.pathParam("pid", proId)
					
				.when()
					.delete("/projects/{pid}")
					
				.then()
					.assertThat().statusCode(204).log().all();
	}

}
