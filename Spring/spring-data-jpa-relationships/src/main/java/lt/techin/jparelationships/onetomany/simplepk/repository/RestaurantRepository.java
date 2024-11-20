package lt.techin.jparelationships.onetomany.simplepk.repository;

import lt.techin.jparelationships.onetomany.simplepk.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}
