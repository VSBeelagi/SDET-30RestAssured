package ResponseValidation;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.mysql.cj.log.Log;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;


public class Response_TimeValidation {
	
	@Test
	
	public void response_TimeValidation()
	{
		
		//prerequisites
		baseURI = "http://localhost";
		port = 8084;
		
		//Action
		Response resp = when()
			.get("/projects");
			
		//Validate
		resp.then()
			.assertThat().time(Matchers.lessThan(4293L),TimeUnit.MILLISECONDS)
			.log().all();
			long ti = resp.time();
			System.out.println(ti);
			
	
	
	}

}
