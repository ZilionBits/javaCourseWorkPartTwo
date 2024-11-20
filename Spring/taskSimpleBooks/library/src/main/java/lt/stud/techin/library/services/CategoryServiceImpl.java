package lt.stud.techin.library.services;

import lt.stud.techin.library.dataTransferObject.CategoryRequest;
import lt.stud.techin.library.model.Book;
import lt.stud.techin.library.model.Category;
import lt.stud.techin.library.repository.BookRepository;
import lt.stud.techin.library.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    CategoryRepository categoryRepository;
    BookRepository bookRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Book> getBooksByCategoryId(Long id) {
        return null;
    }

    @Override
    public Category addCategory(CategoryRequest newCategory) {
        Category category = new Category();

            category.setName(newCategory.getName());

            categoryRepository.save(category);

        return category;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
