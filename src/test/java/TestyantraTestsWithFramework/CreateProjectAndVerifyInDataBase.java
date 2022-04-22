package TestyantraTestsWithFramework;

import org.testng.annotations.Test;

import CommonLibraries.BaseAPIClass;
import CommonLibraries.ConstantsLibrary;
import CommonLibraries.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ProjectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectAndVerifyInDataBase extends CommonLibraries.BaseAPIClass{
	
	@Test
	public void createProjectVerifyInDb() throws Throwable
	{
		//Step 1: create Prerequistes
		ProjectLibrary pLib = new ProjectLibrary("Vijayalaxmi", "Amdocs "+jLib.getRandomNumber(), "Completed", 10);
		
		Response resp = given()
		                  .body(pLib)
		                  .contentType(ContentType.JSON)
		 
	                   	  .when()
		                  .post(EndPointsLibrary.CreateProject);
		
		//Step 2: Capture the project ID
		String expData = rLib.getJsonPath(resp, "projectId");
		System.out.println(expData);
		
		//Step 3: Verify the project in API response
		given()
		 .pathParam("pid", expData)
		.when()
		 .get(EndPointsLibrary.GetAllprojects+"/{pid}")
		.then().log().all();
		System.out.println("Data successfuly verifies in API response");
		
		//Step 4: Vefify the project in Database
		String query = "select * from project";
		String data = dLib.executeQueryAndGetData(query,expData, 1);
		System.out.println(data);
		System.out.println("data verifed successfully in databse");
		 
		
	}

}


