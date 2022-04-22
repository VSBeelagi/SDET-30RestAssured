package CRUDOperationsWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DeleteProject {
	
	@Test
	
	public void deleteProject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		when()
			.delete("/projects/TY_PROJ_627")
			
		.then()
			.assertThat()
			.statusCode(204)
			.log().all();
	}

}
