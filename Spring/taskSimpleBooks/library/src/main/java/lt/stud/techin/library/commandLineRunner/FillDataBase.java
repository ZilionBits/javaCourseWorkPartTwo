package lt.stud.techin.library.commandLineRunner;


import lt.stud.techin.library.model.Book;
import lt.stud.techin.library.model.Category;
import lt.stud.techin.library.repository.BookRepository;
import lt.stud.techin.library.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FillDataBase implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public FillDataBase(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Category category1 = new Category();

        category1.setName("SciFi");

        categoryRepository.save(category1);

        Book book1 = new Book();

        book1.setAuthor("Ingrida Kupčiūnienė");
        book1.setTitle("STEAM užduočių sąsiuvinis 5-6 klasei");
        book1.setCategory("Informatika");
        book1.setCover("https://www.patogupirkti.lt/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/s/t/steam-uzduociu-sasiuvinis-5-6-klasei-.jpg");
        book1.setPrice(9.66);
        book1.setReserved(false);
        book1.setBookCategory(category1);


        Book book2 = new Book();

        book2.setAuthor("Bebras");
        book2.setTitle("Žaidimo kortelės BEBRAS 10+ informatinio mąstymo ugdymui");
        book2.setCategory("Informatika");
        book2.setCover("https://www.patogupirkti.lt/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/i/m/image_2081.jpg");
        book2.setPrice(15.99);
        book2.setReserved(false);
        book2.setBookCategory(category1);

        bookRepository.save(book1);
        bookRepository.save(book2);

    }
}
