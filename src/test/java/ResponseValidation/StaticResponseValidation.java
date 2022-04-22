package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
	
	@Test
	public void staticResponseValidation()
	{
		JavaLibrary jLib = new JavaLibrary();
		
		baseURI = "http://localhost";
		port = 8084;
		
		ProjectLibrary pLib = new ProjectLibrary("Vijayalaxmi", "Infosys"+jLib.getRandomNumber(), "Completed", 10);
		
		Response resp = given()
			.body(pLib)
			.contentType(ContentType.JSON)
			
		.when()
			.post("/addProject");
		
		String actData = resp.jsonPath().get("projectId");
		
		Assert.assertEquals(actData, "TY_PROJ_1414");
		System.out.println(actData);
		resp.then().log().all();
			
	}

}
