package lt.stud.techin.library.services;

import lt.stud.techin.library.dataTransferObject.BookRequest;
import lt.stud.techin.library.model.Book;
import lt.stud.techin.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(BookRequest newBook) {

        Book book = new Book();

        book.setAuthor(newBook.getAuthor());
        book.setTitle(newBook.getTitle());
        book.setCategory(newBook.getCategory());
        book.setCover(newBook.getCover());
        book.setPrice(newBook.getPrice());
        book.setReserved(newBook.isReserved());

        bookRepository.save(book);

        return book;
    }

    @Override
    public Book updateBook(BookRequest newBook, Long id) {
        return bookRepository.findById(id)
                .map(book ->{
                    book.setAuthor(newBook.getAuthor());
                    book.setTitle(newBook.getTitle());
                    book.setCategory(newBook.getCategory());
                    book.setCover(newBook.getCover());
                    book.setPrice(newBook.getPrice());
                    book.setReserved(newBook.isReserved());

                    return bookRepository.save(book);
                }).orElseThrow();
    }

    @Override
    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

}
