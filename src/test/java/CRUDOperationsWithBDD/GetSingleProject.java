package CRUDOperationsWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class GetSingleProject {
	
	@Test
	
	public void getSingleProject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		when()
			.get("/projects/TY_PROJ_627")
			
		.then()
			.log().all();
	}

}
