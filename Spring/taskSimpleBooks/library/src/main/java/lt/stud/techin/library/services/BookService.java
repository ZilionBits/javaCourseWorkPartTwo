package lt.stud.techin.library.services;

import lt.stud.techin.library.dataTransferObject.BookRequest;
import lt.stud.techin.library.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();
    Book createBook(BookRequest newBook);
    Book updateBook(BookRequest newBook, Long id);
    void removeBook(Long id);


}
