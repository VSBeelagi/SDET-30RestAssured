package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.awt.JobAttributes;

public class Bearer_Token {
	
	@Test
	public void bearerToken()
	{
		baseURI = "https://api.github.com";
		JSONObject jObj = new JSONObject();
		jObj.put("name", "SDET-30RestAssured");
		
		given()
			.auth()
			.oauth2("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")
			.body(jObj)
			.contentType(ContentType.JSON)
			
		.when()
			.post("/user/repos")
			
		.then().log().all();
	}

}
