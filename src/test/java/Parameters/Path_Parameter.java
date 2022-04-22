package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Path_Parameter {

	@Test
	public void pathParameter()
	{
		//pre requisites
		baseURI = "http://localhost";
		port = 8084;
		
		given()
			.pathParam("pid", "TY_PROJ_630")
			
		//Actions
			.when()
				.get("/projects/{pid}")
				
		//Validation
			.then()
				.log().all();
	}
}
