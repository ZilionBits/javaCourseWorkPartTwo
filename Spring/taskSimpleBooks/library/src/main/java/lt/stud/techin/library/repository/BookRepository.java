package lt.stud.techin.library.repository;

import lt.stud.techin.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
