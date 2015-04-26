package mlxc;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Table(name = "Food")
public class FoodModel extends Model {
	@Column(name="restaurantId")
	public String restaurantId;
	
	@Column(name="restaurantName")
	public String restaurantName;
	
	@Column(name="orderFoodTime")
	public String orderFoodTime;
	
	@Column(name="foodName")
	public String foodName;
	
	@Column(name="foodPrice")
	public String foodPrice;
	
	//Query
	public static Finder<Integer,FoodModel> find = new Finder<Integer,FoodModel>(Integer.class, FoodModel.class);
		
	public static List<FoodModel> findAll() {
		return find.all();
	}
		
	public static List<FoodModel> findByRestaurantId (String restaurantId){
		return find.where().eq("restaurantId", restaurantId).findList();
	}
	
//	public static FoodModel findById (String id){
//		return find.where().eq("restaurantId", id).findUnique();
//	}
}
