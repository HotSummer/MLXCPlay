package mlxc;

import java.util.ArrayList;
import java.util.List;

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
//	RestaurantModel restaurant = Form.form(RestaurantModel.class).bindFromRequest().get();
	
	public static Result sayHello() {
		RestaurantModel model1 = new RestaurantModel();
		model1.restaurantId = "11102";
		model1.restaurantName = "东北水饺";
		model1.restaurantPrice = "15个/10元";
		model1.restaurantPhone = "13205178165";
		model1.restaurantAddress = "美丽星城101号";
		model1.restaurantSmallImageUrl = "http://img0.bdstatic.com/img/image/4477414b48e0b8d5686712a009fa3c911408337942.jpg";
		
		RestaurantModel model2 = new RestaurantModel();
		model2.restaurantId = "11103";
		model2.restaurantName = "福建混沌";
		model2.restaurantPrice = "15个/9元";
		model2.restaurantPhone = "13205178165";
		model2.restaurantAddress = "美丽星城102号";
		model2.restaurantSmallImageUrl = "http://img0.bdstatic.com/img/image/63b2ef359345929635a54b877a03074a1409131582.jpg";
		
//		String restaurant1JsonString = JsonUtils.toJsonString(model1);
//		String restaurant2JsonString = JsonUtils.toJsonString(model2);
//		
		ArrayList<RestaurantModel> list = new ArrayList<RestaurantModel>(); 
		list.add(model1);
		list.add(model2);
		
		String restaurantsJsonString = JsonUtils.toJsonString(list);
		
//		result.put("model1", restaurant1JsonString);
//		result.put("model2", restaurant2JsonString);
		return ok(restaurantsJsonString);
	}
	
//	public Promise<Result> getRestaurants() {
//		
////		RestaurantModel restaurant = Form.form(RestaurantModel.class).bindFromRequest().get();
////		return ok("restaurant");
//	}
	
	public static Result allRestaurants() {
	    List<RestaurantModel> restaurants = RestaurantModel.findAll();
	    
	    String restaurantsJsonString = JsonUtils.toJsonString(restaurants);
	    
	    return ok(restaurantsJsonString);
	}
	
	public static Result addRestaurant() {
		RestaurantModel p1 = new RestaurantModel();
		p1.restaurantId = "10001";
		p1.save();
	    return ok("Saved");
	}
}
