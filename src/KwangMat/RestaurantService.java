package KwangMat;

public class RestaurantService {
	private RestaurantDao restaurantDao;
	
	public RestaurantService() {
		restaurantDao = RestaurantDao.getInstance();
	}
	
	
}
