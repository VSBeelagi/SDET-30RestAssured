package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0 {
	
	@Test
	public void oauth2_0()
	{
		//create a request to generate access token
		Response resp = given()
		.formParam("client_id", "SDET-30_CoopPractice")
		.formParam("client_secret", "55570dea9ec034492af01821793a6976")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authentication_code")
		
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
			
		//Capture the access token from the response of request
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//create another request and use the token to access the APIs
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID",3131)
			
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")	
		
		.then().log().all();
		
	}

}
