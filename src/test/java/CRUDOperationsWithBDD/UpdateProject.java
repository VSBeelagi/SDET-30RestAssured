package CRUDOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
	
	@Test
	
	public void updateProject()
	{
		//step1: create pre requisites
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "VSBeelagi");
		jObj.put("projectName", "spider");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 22);
		
		baseURI = "http://localhost";
		port = 8084;
		
	given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
	.when()		//step2: actions
		.put("/projects/TY_PROJ_630")
		
	.then()		//step3: Validate
	.assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	}

}
