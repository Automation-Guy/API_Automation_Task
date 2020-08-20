package org.coderbyte.API;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class Football {
	
	int squadSize = 20;
	
	@Test(priority = 1)
	public void getSuccessFul() {
		
		given()
		.auth()
		.oauth2("e051043b86624518a57a263f9388d198")
		.when()
		  .get("https://api.football-data.org/v2/teams/12")
		.then()
		.assertThat()
		.statusCode(200);
	}
	
	@Test(priority = 2)
	public void getFailure() {
		
		given()
		.when()
		  .get("https://api.football-data.org/v2/teams/12")
		.then()
		.assertThat()
		.statusCode(200);
	}
	
	@Test(priority = 2)
	public void getResponse() {
		
		given()
		.auth()
		.oauth2("e051043b86624518a57a263f9388d198")
		.when()
		  .get("https://api.football-data.org/v2/teams/12")
		.then()
		  .assertThat()
		  .body("squad.id",hasSize(squadSize));
	}


}
