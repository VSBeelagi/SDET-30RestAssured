package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParameterTest_ForGit {
	
	@Test
	public void parametersTest()
	{
		baseURI = "http://api.github.com";
		
		given()
			.pathParam("username", "VSBeelagi")
			.queryParam("per_Page", 30)
			.queryParam("page", 1)
			
			.when()
				.get("/users/{username}/repos")
				
			.then().assertThat().statusCode(200).log().all();
	}

}
