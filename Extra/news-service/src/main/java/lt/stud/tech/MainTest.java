package lt.stud.tech;

import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

public class MainTest {
    public static void main(String[] args) {
        VakaroZinios vakaroZinios = new VakaroZinios();
        NewsServiceImpl newsService = new NewsServiceImpl();

        System.out.println(newsService.getArticles());
    }
}
