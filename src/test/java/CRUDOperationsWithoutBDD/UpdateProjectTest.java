package CRUDOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	
	@Test
	
	public void updateProjectTest()
	{
		
		//Step1: create pre requisites
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Vijaya");
		jObj.put("projectName", "Xylem");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 20);
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//Step2: perform action
		Response resp = req.put("http://localhost:8084/projects/TY_PROJ_628");
		
		//step3: Validation
		resp.then().log().all();
		
	}

}
