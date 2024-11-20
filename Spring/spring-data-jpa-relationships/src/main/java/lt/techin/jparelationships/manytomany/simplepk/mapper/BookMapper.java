package lt.techin.jparelationships.manytomany.simplepk.mapper;

import lt.techin.jparelationships.manytomany.simplepk.rest.dto.BookResponse;
import lt.techin.jparelationships.manytomany.simplepk.rest.dto.UpdateBookRequest;
import lt.techin.jparelationships.manytomany.simplepk.model.Book;
import lt.techin.jparelationships.manytomany.simplepk.rest.dto.CreateBookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "writers", ignore = true)
    Book toBook(CreateBookRequest createBookRequest);

    BookResponse toBookResponse(Book book);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "writers", ignore = true)
    void updateBookFromRequest(UpdateBookRequest updateBookRequest, @MappingTarget Book book);
}
