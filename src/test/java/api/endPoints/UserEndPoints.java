package api.endPoints;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.payLoad.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

///should add manually 
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.*; 

import java.util.HashMap;
import java.util.Map;




//userend points.java
//created for perform create,read.update,dlete request the user API

public class UserEndPoints {





	public static Response createUser(User payload) {


		Response response= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		.when()
			.post(Routes.post_url);

		return response;
	}

	public static Response readUser(String userName) {


		Response response= given()
				.pathParam("username", userName)
		.when()
			.get(Routes.get_url);

		return response;
	}

	public static Response updateUser(String userName,User payload) {


		Response response= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
		.when()
			.put(Routes.update_url);

		return response;
	}
	
	
	public static Response deleteUser(String userName) {


		Response response= given()
				.pathParam("username", userName)
		.when()
			.delete(Routes.delete_url);

		return response;
	}

}
