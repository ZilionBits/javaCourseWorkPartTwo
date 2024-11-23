package lt.stud.techin.library.services;


import lt.stud.techin.library.dataTransferObject.BookRequest;
import lt.stud.techin.library.exceptions.BookByIdNotFoundException;
import lt.stud.techin.library.model.Book;
import lt.stud.techin.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private Book book;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(BookRequest newBook) {

        book = new Book();

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
        book = bookRepository.findById(id)
                .orElseThrow(() -> new BookByIdNotFoundException("Book with ID: " + id + ", not found."));

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
    public void removeBook(Long id) {
        if(bookRepository.existsById(id)) {
        bookRepository.deleteById(id);
        } else {
            throw new BookByIdNotFoundException("Book with ID: " + id + ", not found.");
        }
    }

}
