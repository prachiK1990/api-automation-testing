package stepDefinition;



import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TaxdooApiSteps {
	
	
	@Given("User calls the Rest api")
	public void  callApiandCheckResponse(){

		System.out.println("Inside Step - callApiandCheckResponse");

		Response response = RestAssured.get("https://gorest.co.in/public/v2/users");
		System.out.println(response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());

		int statusCode = response.getStatusCode();
		Assert.assertEquals("HTTP Status code in not 200 ",200, statusCode);
	
	}

	
	@Then("Send create user request")	
	public void  createUser(){

		System.out.println("Inside Step - createUser");
		
		JSONObject o = new JSONObject();
		o.put("id", "58885454555");
		o.put("name", "Mr. Ashish jupta");
		o.put("email","ashidsh.8@gmail.com");
		o.put("gender","male");
		o.put("status","inactive");
		
		System.out.println(o.toString());
		
		Header contentType = new Header("Content-Type","application/json");
	    Header authorization = new Header("Authorization", "Bearer "+"a38f2839db4f5abc7e2b9e434a27ca57dff9474f7dfb7ed39065d079e120c981");
	    List<Header> headerList = new ArrayList<Header>();
	    headerList.add(contentType);
	    headerList.add(authorization);
	    Headers header = new Headers(headerList);
	    
		RestAssured.baseURI = "https://gorest.co.in/"; 
		RequestSpecification req  = RestAssured.given();
		
		req.headers(header);
		req.body(o.toJSONString()); 
		
		Response response = req.post("/public/v2/users"); 
		System.out.println("status received: " + response.statusLine());
		Assert.assertEquals("HTTP Status code in not 201 ",201, response.getStatusCode());
	
	}
}
