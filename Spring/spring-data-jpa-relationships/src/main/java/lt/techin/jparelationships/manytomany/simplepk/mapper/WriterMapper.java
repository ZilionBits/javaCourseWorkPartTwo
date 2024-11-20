package lt.techin.jparelationships.manytomany.simplepk.mapper;

import lt.techin.jparelationships.manytomany.simplepk.model.Writer;
import lt.techin.jparelationships.manytomany.simplepk.rest.dto.WriterResponse;
import lt.techin.jparelationships.manytomany.simplepk.rest.dto.CreateWriterRequest;
import lt.techin.jparelationships.manytomany.simplepk.rest.dto.UpdateWriterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface WriterMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    Writer toWriter(CreateWriterRequest createWriterRequest);

    WriterResponse toWriterResponse(Writer writer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    void updateWriterFromRequest(UpdateWriterRequest updateWriterRequest, @MappingTarget Writer writer);
}
