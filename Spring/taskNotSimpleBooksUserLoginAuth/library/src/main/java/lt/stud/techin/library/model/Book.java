package lt.stud.techin.library.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String category;
    private double price;
    private String cover;
    private boolean reserved;
    @ManyToOne
    private Category bookCategory;

    public void addCategory(Category category){
        this.bookCategory = category;
        category.getBooks().add(this);
    }

    public void removeCategory(){
        this.bookCategory.getBooks().remove(this);
        this.bookCategory = null;
    }
}
