package com.MeSolutions.API_Testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Test
public class PostCall {
	

	   Properties pro = new Properties();
	

public void postData() throws IOException {
		
		FileInputStream fis = new FileInputStream("config.properties");
		pro.load(fis);
		
		
	}
	
	 
	
	public void postValuePosts(){
		
	    RestAssured.baseURI= pro.getProperty("URL");
		System.out.println("dhanashree post-------------");
		
		

		
		String b = ("{\n" + 
		         "   \"postId\": \"483\", \n" +
				"    \"userId\": \"007\",\n" + 
				"    \"title\": \"MeSolutions\",\n" + 
				"    \"body\": \"API Testing\",\n" + 
				"    \"id\": \"dhanashree\"\n" + 
				"  }");
	
	    Response res = (Response) given().body(b).
				                   when().
				                   post("/comments").
				                   then().
//				                   assertThat().statusCode(201).
//				                   and().contentType(ContentType.JSON).
				                   and().extract().response();
//				                   body("status",equalTo("OK")).extract();
        System.out.println(b);
	    String s= res.asString();
		System.out.println("Post Body is :"+ s);
		JsonPath js = new JsonPath(s);
		long id = js.get("id");
		System.out.println(id);
		
	}
 
	
	

	


	
	

}
