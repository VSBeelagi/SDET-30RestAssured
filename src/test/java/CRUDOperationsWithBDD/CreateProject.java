package CRUDOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	
	@Test
	
	public void createProject()
	{
		//step1: create pre requisites
				JSONObject jObj = new JSONObject();
				jObj.put("createdBy", "VSB");
				jObj.put("projectName", "spider");
				jObj.put("status", "On Going");
				jObj.put("teamSize", 18);
				
				baseURI = "http://localhost";
				port = 8084;
				
			given()
				.body(jObj)
				.contentType(ContentType.JSON)
				
			.when()		//step2: actions
				.post("/addProject")
				
			.then()		//step3: Validate
			.assertThat()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
			
				
		
		
	}

}
