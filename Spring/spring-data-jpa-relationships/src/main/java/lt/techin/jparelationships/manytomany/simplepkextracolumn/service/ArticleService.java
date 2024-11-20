package lt.techin.jparelationships.manytomany.simplepkextracolumn.service;

import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Article;

public interface ArticleService {

    Article validateAndGetArticle(Long id);

    Article createArticle(Article article);

    void deleteArticle(Article article);
}
