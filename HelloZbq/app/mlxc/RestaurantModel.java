package mlxc;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Table(name = "Restaurant")
public class RestaurantModel extends Model {
	/**
	 * 
	 */
//	@Column (name = "C_ID") 
	@Column(name="restaurantId")
	public String restaurantId;
	
	@Column(name="restaurantName")
	public String restaurantName;
	
	@Column(name="restaurantPrice")
	public String restaurantPrice;
	
	@Column(name="restaurantPhone")
	public String restaurantPhone;
	
	@Column(name="restaurantAddress")
	public String restaurantAddress;
	
	@Column(name="restaurantSmallImageUrl")
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
