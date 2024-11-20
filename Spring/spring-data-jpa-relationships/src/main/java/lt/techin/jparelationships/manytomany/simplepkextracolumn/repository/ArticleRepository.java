package lt.techin.jparelationships.manytomany.simplepkextracolumn.repository;

import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
}
