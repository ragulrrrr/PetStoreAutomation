package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import api.endPoints.UserEndPoints;
import api.payLoad.User;
import api.utilities.ExtentReport;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

///should add manually 
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.*; 

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;


//https://petstore.swagger.io/#/user/createUser

public class UserTest {


	Faker facker;

	User userPayload;
	
	public Logger logger;
	ExtentReport e;

	@BeforeClass
	public void serupData() {

		facker=new Faker();
		userPayload=new User();


		userPayload.setId(facker.idNumber().hashCode());
		userPayload.setUsername(facker.name().username());
		userPayload.setFirstName(facker.name().firstName());
		userPayload.setLastName(facker.name().lastName());
		userPayload.setPhone(facker.phoneNumber().cellPhone());
		userPayload.setEmail(facker.internet().emailAddress());
		userPayload.setPassword(facker.internet().password(5,10));
		
		
		//logs
		
		
		
		logger=LogManager.getLogger(this.getClass());
		//logger=LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName() );

	}

	@Test(priority = 1)
	public void testPostUser(){

		logger.info("************* Creating user   *****************");
		e.getTest().log(Status.INFO, "************* Creating user   *****************");
		
		Response res = UserEndPoints.createUser(userPayload);

		res.then().log().all();

		AssertJUnit.assertEquals(res.statusCode(), 200);


	}



	@Test(priority = 2)
	public void testGetUserData(){
		logger.info("************* get user   *****************");
		e.getTest().log(Status.INFO, "************* get user   *****************");

		Response res = UserEndPoints.readUser(this.userPayload.getUsername());

		res.then().log().all();

		AssertJUnit.assertEquals(res.statusCode(), 200);


	}


	@Test(priority = 3)
	public void testUpsateUserDataByName(){
		
		logger.info("************* update user   *****************");
		e.getTest().log(Status.INFO, "************* update user   *****************");

		//update data using payload name

		userPayload.setFirstName(facker.name().firstName());
		userPayload.setLastName(facker.name().lastName());
		userPayload.setPhone(facker.phoneNumber().cellPhone());


		Response res = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);

		res.then()
		.log().all()
		.log().body().statusCode(200);// another wayof assertion, this is restasure assersion

		AssertJUnit.assertEquals(res.statusCode(), 200);


		//cheking data after update

		Response resAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());

		resAfterUpdate.then().log().all();

		AssertJUnit.assertEquals(res.statusCode(), 200);

	}


	@Test(priority = 4)
	public void testdeleteUser(){

		logger.info("************* delete user   *****************");
		e.getTest().log(Status.INFO, "************* delete user   *****************");
		
		Response res = UserEndPoints.deleteUser(this.userPayload.getUsername());

		res.then().log().all();

		AssertJUnit.assertEquals(res.statusCode(), 200);


	}



}
