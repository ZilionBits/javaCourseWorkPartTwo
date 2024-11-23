package lt.stud.techin.library.dataTransferObject;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequest {


    private Long id;
    @NotBlank(message = "Must give title to the book.")
    private String title;
    @NotBlank(message = "Must give author to the book.")
    private String author;
    @NotBlank(message = "Must give category to the book.")
    private String category;
    @Min(value = 0,message = "Price must be positive.")
    private double price;
    @NotBlank(message = "Give working book cover url.")
    private String cover;
    private boolean reserved;
}
