package api.endPoints;



//https://petstore.swagger.io/v2/swagger.json
/*
 * 
 * get:  https://petstore.swagger.io/v2/user/r
 * 
 * post:   https://petstore.swagger.io/v2/user
 * 
 * Put:  https://petstore.swagger.io/v2/user/mckinley.sporer'
 * 
 * delete:   https://petstore.swagger.io/v2/user/coletta.oconnell
 * 
 * */

public class Routes {
	
	
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User module
	
	public static String post_url=base_url+"/user";
	
	public static String get_url=base_url+"/user/{username}";
	
	public static String update_url=base_url+"/user/{username}";
	
	public static String delete_url=base_url+"/user/{username}";
	
	
	
	
	//store module
	
	
	
	//pet module
	

}