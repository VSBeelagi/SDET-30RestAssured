package CRUDOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {
	
	@Test
	
	public void deleteProjectTest()
	{
		//step1: create pre requisites
		
		//step2: action
		
		Response rest = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_628");
		
		//step3: Validation
		rest.then().log().all();
		int actStatus = rest.getStatusCode();
		Assert.assertEquals(actStatus, 204);

		
		
	}

}
