package CRUDOperationsWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest {
	
	@Test
	
	public void getSingleProject()
	{
		//step1: create pre requisites
		//step2: perform action
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_628");
		
		//step3: Validation
		resp.then().log().all();
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(actStatus, 200);
	}

}
