package com.MeSolutions.API_Testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

@Test
public class GetCall {
	
	   Properties pro = new Properties();
	

  public void getData() throws IOException {
		
		FileInputStream fis = new FileInputStream("config.properties");
		pro.load(fis);
		
		
	}
	
	 
	
	public void getValuePosts(){
		
	    RestAssured.baseURI= pro.getProperty("URL");
		System.out.println("dhanashree-------------");
	
	    Response res = (Response) given().
				                   when().
				                   get("/posts").
				                   then().
				                   assertThat().statusCode(200).
				                   and().contentType(ContentType.JSON).
				                   and().body("array[0].id",equalTo("2")).extract();

	    String s= res.asString();
		System.out.println("Status code is :"+ s);
	}
	
	public void getValuecomments() {
		
		    RestAssured.baseURI= pro.getProperty("URL");
			System.out.println("dhanashree-------------");
		
		    Response res = (Response) given().
					                   when().
					                   get("/comments").
					                   then().
					                   assertThat().statusCode(200).
					                   and().contentType(ContentType.JSON);
//					                  . extract();

		
		    String s= res.asString();
			System.out.println("Status code is :"+ s);
		
		
		
		
	}
	
	public void getValueUsers() {
		   
		RestAssured.baseURI= pro.getProperty("URL");
			System.out.println("dhanashree-------------");
		
		    Response res = (Response) given().
					                   when().
					                   get("/users").
					                   then().
					                   assertThat().statusCode(200).
					                   and().contentType(ContentType.JSON);
//					                   extract();

		    String s= res.asString();
			System.out.println("Status code is :"+ s);
		
	}

}
