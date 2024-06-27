import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest {
    RestaurantService service = new RestaurantService();
    Restaurant restaurant;

    @BeforeEach
    public void setup() {
        restaurant = service.addRestaurant("Amelie's cafe", "Chennai", LocalTime.of(9, 0), LocalTime.of(22, 0));
        restaurant.addToMenu("Sweet corn soup", 119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }

    @Test
    public void searching_for_existing_restaurant_should_return_expected_restaurant_object() {
        assertNotNull(service.findRestaurantByName("Amelie's cafe"));
    }

    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception() {
        assertNull(service.findRestaurantByName("Non-existing cafe"));
    }
}
