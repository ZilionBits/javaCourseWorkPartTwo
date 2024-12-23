package lt.techin.jparelationships.manytomany.simplepk.service;

import lt.techin.jparelationships.manytomany.simplepk.exception.BookNotFoundException;
import lt.techin.jparelationships.manytomany.simplepk.model.Book;
import lt.techin.jparelationships.manytomany.simplepk.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book validateAndGetBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }
}
