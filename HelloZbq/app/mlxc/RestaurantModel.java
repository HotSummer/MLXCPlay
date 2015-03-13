package mlxc;

import java.util.List;

import javax.persistence.Entity;

import play.db.ebean.Model.Finder;

@Entity
public class RestaurantModel {
	public String restaurantId;
	
	public String restaurantName;
	public String restaurantPrice;
	public String restaurantPhone;
	public String restaurantAddress;
	public String restaurantSmallImageUrl;
	
	//Query
	public static Finder<Integer,RestaurantModel> find = new Finder<Integer,RestaurantModel>(Integer.class, RestaurantModel.class);
	
	public static List<RestaurantModel> findAll() {
		return find.all();
	}
	
	public static RestaurantModel findById (String id){
		return find.where().eq("restaurantId", id).findUnique();
	}
}
