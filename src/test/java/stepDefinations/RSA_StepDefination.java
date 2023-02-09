package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import Pojo.Location;
import Pojo.Place;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RSA_StepDefination 
{
	Response addPlaceResponse;
	RequestSpecification addPlaceReq;
	ResponseSpecification res;
	
	@Given("add place payload")
	public void add_place_payload() {
		
		Place p = new Place();
		p.setAccuracy("50");
		p.setName("Tathagat Wasnik");
		p.setPhone_number("(+91) 9767331234");
		p.setAddress("29, Rekha colony, Amt");
		p.setWebsite("http://google.com");
		p.setLanguage("French-IN");
		
		Location l = new Location();
		l.setLat("-38.383494");
		l.setLng("33.427362");
		p.setLocation(l);
		
		List<String> a = new ArrayList<String>();
		a.add("shoe park");
		a.add("shop");
		p.setTypes(a);
		
		
		
		//Restassured test
		
		//Request Spec Builder				
		RequestSpecification req = new RequestSpecBuilder()				
		.setBaseUri("https://rahulshettyacademy.com" )				
		.addQueryParam ("key", "qaclick123")						
		.setContentType(ContentType.JSON)
		.build();
		
		//Responce Spec Builder
		 res = new ResponseSpecBuilder()
				.expectStatusCode(200)		
				.expectContentType(ContentType.JSON)
				.build();
		
		 addPlaceReq = given()				
				.log().all()				
				.spec(req)				
				.body (p);	
		
	}

	@When("user hits {string} with post request")
	public void user_hits_with_post_request(String string) 
	{
	   
		 addPlaceResponse =  addPlaceReq				
				.when()				
				.post("/maps/api/place/add/json")				
				.then()				
				.spec(res)	
				.extract().response();
		
	}

	@Then("response get succesfull with status code is {int}")
	public void response_get_succesfull_with_status_code_is(Integer int1)
	{
		assertEquals(addPlaceResponse.getStatusCode(),200);
	}

	@Then("{string} should be {string}")
	public void should_be(String KeyValue, String ExpValue)
	{
		String addplace=addPlaceResponse.asString();
		JsonPath js = new JsonPath(addplace);
		assertEquals(js.get(KeyValue).toString(),ExpValue);
	}
}
