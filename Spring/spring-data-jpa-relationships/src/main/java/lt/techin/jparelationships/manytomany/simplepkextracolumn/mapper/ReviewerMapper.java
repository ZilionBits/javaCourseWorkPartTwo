package lt.techin.jparelationships.manytomany.simplepkextracolumn.mapper;

import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Reviewer;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.rest.dto.CreateReviewerRequest;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.rest.dto.ReviewerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Reviewer toReviewer(CreateReviewerRequest createReviewerRequest);

    ReviewerResponse toReviewerResponse(Reviewer reviewer);
}
