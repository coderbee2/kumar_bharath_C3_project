import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();
    private Map<String, Item> menu = new HashMap<>();


    public Restaurant findRestaurantByName(String restaurantName) throws Exception {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equalsIgnoreCase(restaurantName)) {
                return restaurant;
            }
        }
        throw new Exception("Restaurant with name " + restaurantName + " not found.");
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException, Exception {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if (restaurantToBeRemoved == null) {
            throw new restaurantNotFoundException("Restaurant not found: " + restaurantName);
        }
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

}
