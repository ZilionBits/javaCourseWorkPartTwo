package lt.techin.jparelationships.onetomany.simplepk.service;

import lt.techin.jparelationships.onetomany.simplepk.model.Restaurant;

public interface RestaurantService {

    Restaurant validateAndGetRestaurant(Long id);

    Restaurant saveRestaurant(Restaurant restaurant);

    void deleteRestaurant(Restaurant restaurant);
}
