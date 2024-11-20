package lt.techin.jparelationships.onetomany.simplepk.service;

import lt.techin.jparelationships.onetomany.simplepk.model.Dish;

public interface DishService {

    Dish validateAndGetDish(Long dishId, Long restaurantId);

    Dish saveDish(Dish dish);

    void deleteDish(Dish dish);
}
