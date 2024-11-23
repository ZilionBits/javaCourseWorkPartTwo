package lt.stud.techin.library.dataTransferObject;

import lombok.Data;
import lt.stud.techin.library.model.Book;

import java.util.List;

@Data
public class CategoryRequest {

    private String name;
    private List<Book> books;
}
