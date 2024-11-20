package lt.techin.jparelationships.onetomany.simplepk.mapper;

import lt.techin.jparelationships.onetomany.simplepk.model.Restaurant;
import lt.techin.jparelationships.onetomany.simplepk.rest.dto.CreateRestaurantRequest;
import lt.techin.jparelationships.onetomany.simplepk.rest.dto.RestaurantResponse;
import lt.techin.jparelationships.onetomany.simplepk.rest.dto.UpdateRestaurantRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface RestaurantMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dishes", ignore = true)
    Restaurant toRestaurant(CreateRestaurantRequest createRestaurantRequest);

    RestaurantResponse toRestaurantResponse(Restaurant restaurant);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dishes", ignore = true)
    void updateRestaurantFromRequest(UpdateRestaurantRequest updateRestaurantRequest,
                                     @MappingTarget Restaurant restaurant);
}
