package CRUDOperationsWithoutBDD;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest {

	@Test
	
	public void getAllProjects()
	{
		//step1: create a pre requisites
		//step2: perform  the action
		
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//step3: provide Validation
		resp.then().log().all();
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(200, actStatus);
		
		
	}
}
