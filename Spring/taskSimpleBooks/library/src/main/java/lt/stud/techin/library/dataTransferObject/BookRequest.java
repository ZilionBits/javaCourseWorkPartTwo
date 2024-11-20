package lt.stud.techin.library.dataTransferObject;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequest {

    @NotBlank(message = "Must give a title to the book.")
    private String title;
    private String author;
    private String category;
    private double price;
    private String cover;
    private boolean reserved;
}
