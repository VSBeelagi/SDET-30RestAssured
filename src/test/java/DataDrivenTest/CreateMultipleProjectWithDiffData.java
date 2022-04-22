package DataDrivenTest;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjectWithDiffData {
	
	@Test(dataProvider = "getData")
	
	public void createProject(String createdBy, String projectName, String status, int teamSize)
	{
		
		//pre requisite
		JavaLibrary jLib = new JavaLibrary();
		ProjectLibrary pLib = new ProjectLibrary(createdBy, projectName+jLib.getRandomNumber(), status, teamSize);
		baseURI = "http://localhost";
		port = 8084;
		
		given()
			.body(pLib)
			.contentType(ContentType.JSON)
			
		//Action
			.when()
				.post("/addProject")
				
		//Validation
			.then().log().all();
	}
		
		@DataProvider(name="getData")
		public Object[][] data()
		{
			Object[][] data = new Object[3][4];
			
			data[0][0] = "Chaitra";
			data[0][1] = "Dell";
			data[0][2] = "Completed";
			data[0][3] = 12;
							
			data[1][0] = "Prakah";
			data[1][1] = "TYSS";
			data[1][2] = "On Going";
			data[1][3] = 18;
			
			data[2][0] = "Adarsh";
			data[2][1] = "HP";
			data[2][2] = "Created";
			data[2][3] = 20;
			return data;
		}
		
		
	}


