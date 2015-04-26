package mlxc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;

import play.*;
import play.mvc.*;
import play.data.Form;
import play.libs.Json;
import play.libs.ws.*;
import play.mvc.Controller;
import play.twirl.api.Content;
import mlxc.RestaurantModel;
import Utils.JsonUtils;
import play.api.libs.concurrent.Promise;

public class ResturantController extends Controller {
	
	public static Result allRestaurants() {
	    List<RestaurantModel> restaurants = RestaurantModel.findAll();
	    
	    Map<String, Object> response = new HashMap<String, Object>();
	    
	    response.put("code", "200");
	    response.put("message", "success");
	    response.put("data", restaurants);
	    
	    String restaurantsJsonString = JsonUtils.toJsonString(response);
	    
	    return ok(restaurantsJsonString);
	}
	
	public static Result getFoods(String restaurntId) {
	    List<FoodModel> foods = FoodModel.findAll();
	    
	    Map<String, Object> response = new HashMap<String, Object>();
	    
	    response.put("code", "200");
	    response.put("message", "success");
	    response.put("data", foods);
	    
	    String foodsJsonString = JsonUtils.toJsonString(response);
	    
	    return ok(foodsJsonString);
	}
	
}
