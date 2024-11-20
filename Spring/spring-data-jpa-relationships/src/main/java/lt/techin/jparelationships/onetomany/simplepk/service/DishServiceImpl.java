package lt.techin.jparelationships.onetomany.simplepk.service;

import lt.techin.jparelationships.onetomany.simplepk.exception.DishNotFoundException;
import lt.techin.jparelationships.onetomany.simplepk.model.Dish;
import lt.techin.jparelationships.onetomany.simplepk.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Override
    public Dish validateAndGetDish(Long dishId, Long restaurantId) {
        return dishRepository.findByIdAndRestaurantId(dishId, restaurantId)
                .orElseThrow(() -> new DishNotFoundException(dishId, restaurantId));
    }

    @Override
    public Dish saveDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public void deleteDish(Dish dish) {
        dishRepository.delete(dish);
    }
}
