import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restaurant;

    @BeforeEach
    public void setup() {
        restaurant = new Restaurant("Amelie's cafe", "Chennai", LocalTime.of(9, 0), LocalTime.of(22, 0));
        restaurant.addToMenu("Sweet corn soup", 119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }

    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time() {
        Restaurant spyRestaurant = org.mockito.Mockito.spy(restaurant);
        org.mockito.Mockito.when(spyRestaurant.getCurrentTime()).thenReturn(LocalTime.of(10, 0));
        assertTrue(spyRestaurant.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time() {
        Restaurant spyRestaurant = org.mockito.Mockito.spy(restaurant);
        org.mockito.Mockito.when(spyRestaurant.getCurrentTime()).thenReturn(LocalTime.of(23, 0));
        assertFalse(spyRestaurant.isRestaurantOpen());
    }
}
