package lt.stud.techin.library.services;

import lt.stud.techin.library.dataTransferObject.CategoryRequest;
import lt.stud.techin.library.model.Book;
import lt.stud.techin.library.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategory();
    List<Book> getBooksByCategoryId(Long id);
    Category addCategory(CategoryRequest newCategory);
    void deleteCategory(Long id);
}
