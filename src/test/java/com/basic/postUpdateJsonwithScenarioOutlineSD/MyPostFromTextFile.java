package com.basic.postUpdateJsonwithScenarioOutlineSD;

import static org.hamcrest.Matchers.notNullValue;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MyPostFromTextFile {
	 
	Response resp ;
	
	@Given("^user hit the rest asured test$")
	public void user_hit_the_rest_asured_test() throws Throwable {
	   
		System.out.println("Starting of the GET script");
	}
	
	@Then("^user checks data at path \"([^\"]*)\" having value \"([^\"]*)\" in jason$")
	public void user_checks_data_at_path_having_value_in_jason(String username, String role) throws Throwable {
		
		//String actualLiming = resp.body().jsonPath().getString(username);
		//Assert.assertTrue(actualLiming.equals(role));
		//Read data from file
				String data = ""; 
			    data = new String(Files.readAllBytes(Paths.get("src/test/java/com/basic/postUpdateJsonwithScenarioOutlineSD/user.json"))); 
			    System.out.println("json in String ==== " +data);
			    
		
	    //Update the data
	    JSONObject object=new JSONObject(data);
	    object.put("name", username);
	    object.put("job", role);
	    String newJsonStr = object.toString();
	    System.out.println("json in String ==== " +newJsonStr);
	    
	    //Do POST request
	    resp = RestAssured.given().accept(ContentType.JSON).relaxedHTTPSValidation().
				when().body(newJsonStr).post("https://reqres.in/api/users");
	}
	@Then("user validate the id is not null")
	public void user_validate_the_id_is_not_null(){
		
		//Check id is not null
		resp.then().assertThat().body("id", notNullValue());
		
		//check id is greater than zero
		String idValue = resp.getBody().jsonPath().get("id");
		int idInt = Integer.parseInt(idValue);
		Assert.assertTrue(idInt > 0);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
 