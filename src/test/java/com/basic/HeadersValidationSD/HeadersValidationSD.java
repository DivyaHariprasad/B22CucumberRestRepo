package com.basic.HeadersValidationSD;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersValidationSD {
	
	Response res;
	
	@Given("^user start the rest asured test$")
	public void user_start_the_rest_asured_test() throws Throwable {
		System.out.println("Starting of the GET script");
	}

	@Then("^user checks headers at path \"([^\"]*)\" have \"([^\"]*)\" in Json$")
	public void user_checks_headers_at_path_have_in_Json(String header, String value) throws Throwable {
		String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get("src/test/java/com/basic/HeadersValidationSD/value.json"))); 
	    System.out.println("json in String ==== " +data);
	    JSONObject object=new JSONObject(data);
	    object.put("name", header);
	    object.put("job", value);
	    res = RestAssured.given().relaxedHTTPSValidation().get("https://ergast.com/api/f1/2017/circuits.json");
		String completeResponse = res.asString();
		System.out.println("================="+completeResponse);
	
		//get all headers
		Headers heds = res.getHeaders();
		String actualHeaderValue = heds.getValue(header);
		Assert.assertTrue(actualHeaderValue.equals(value));
	}
	

}
