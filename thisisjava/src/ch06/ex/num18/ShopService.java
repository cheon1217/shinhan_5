package ch06.ex.num18;

public class ShopService {
	private static ShopService shopser = new ShopService();
	
	private ShopService() {
		
	}
	
	public static ShopService getInstance() {
		return shopser;
	}
	
}
