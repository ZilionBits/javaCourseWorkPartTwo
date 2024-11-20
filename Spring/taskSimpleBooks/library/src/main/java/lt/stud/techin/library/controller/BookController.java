package lt.stud.techin.library.controller;

import jakarta.validation.Valid;
import lt.stud.techin.library.dataTransferObject.BookRequest;
import lt.stud.techin.library.model.Book;
import lt.stud.techin.library.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping
    ResponseEntity<Book> createBook(@Valid @RequestBody BookRequest book){

        Book newBook = bookService.createBook(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @PutMapping("/{id}")
    ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookRequest newBook) {
        Book updatedBook = bookService.updateBook(newBook, id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedBook);
    }

    @DeleteMapping("/{id}")
    void removeBook(@PathVariable Long id){
        bookService.removeBook(id);
    }

}
