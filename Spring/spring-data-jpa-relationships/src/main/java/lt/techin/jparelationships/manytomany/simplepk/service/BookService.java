package lt.techin.jparelationships.manytomany.simplepk.service;

import lt.techin.jparelationships.manytomany.simplepk.model.Book;

public interface BookService {

    Book validateAndGetBook(Long id);

    Book saveBook(Book book);

    void deleteBook(Book book);
}
