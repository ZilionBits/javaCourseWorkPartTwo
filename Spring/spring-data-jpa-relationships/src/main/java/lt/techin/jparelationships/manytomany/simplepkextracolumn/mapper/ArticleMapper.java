package lt.techin.jparelationships.manytomany.simplepkextracolumn.mapper;

import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Article;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.rest.dto.ArticleResponse;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.rest.dto.CreateArticleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Article toArticle(CreateArticleRequest createArticleRequest);

    ArticleResponse toArticleResponse(Article article);
}
