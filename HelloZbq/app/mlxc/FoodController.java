package mlxc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utils.JsonUtils;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import mlxc.FoodsRequestModel;

public class FoodController extends Controller {
	public static Result allFoods() {
	    List<FoodModel> foods = FoodModel.findAll();
	    
	    Map<String, Object> response = new HashMap<String, Object>();
	    
	    response.put("code", "200");
	    response.put("message", "success");
	    response.put("data", foods);
	    
	    String foodsJsonString = JsonUtils.toJsonString(response);
	    
	    return ok(foodsJsonString);
	}
	
	public static Result getFoods() {
		FoodsRequestModel requestModel = Form.form(FoodsRequestModel.class).bindFromRequest().get();
		String restaurantId = requestModel.restaurantId;
	    List<FoodModel> foods = FoodModel.findByRestaurantId(restaurantId);
	    
	    Map<String, Object> response = new HashMap<String, Object>();
	    
	    response.put("code", "200");
	    response.put("message", "success");
	    response.put("data", foods);
	    
	    String foodsJsonString = JsonUtils.toJsonString(response);
	    
	    return ok(foodsJsonString);
	}
}
