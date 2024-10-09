package api.test;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endPoints.Routes;
import api.endPoints.UserEndPoints;
import api.payLoad.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {



	@Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)

	public void testPostUser(String userID, String userName,String fname,String lname,String useremail,String psw,String ph) {



		User userPayload=new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(psw);
		userPayload.setPhone(ph);

		Response res = UserEndPoints.createUser(userPayload);

		//res.then().log().all();

		AssertJUnit.assertEquals(res.statusCode(), 200);


	}

	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)

	public void testPostUser(String userName) {

		Response res = UserEndPoints.deleteUser(userName);
		AssertJUnit.assertEquals(res.statusCode(), 200);
	}

}
