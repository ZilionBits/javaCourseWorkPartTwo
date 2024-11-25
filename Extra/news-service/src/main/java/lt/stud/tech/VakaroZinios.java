package lt.stud.tech;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;

import java.util.List;

public class VakaroZinios implements NewsService {
    NewsService newsService;

    @Override
    public List<Article> getArticles() {
        return newsService.getArticles();
    }
}
