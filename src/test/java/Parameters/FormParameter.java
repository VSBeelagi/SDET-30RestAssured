package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormParameter {
	
	@Test
	public void createProjectUsing_FormParameter()
	{
		//pre requisites
		baseURI = "http://localhost";
		port = 8084;
		
		given()
			.formParam("createdBy", "VSB")
			.formParam("projectName", "TYSS")
			.formParam("status", "Completed")
			.formParam("teamSize", 8)
			
		//Action
		.when()
			.post("/addProject")
			
		//Validation
		.then().log().all();
	}

}
