package lt.stud.techin.library.controller;

import lt.stud.techin.library.dataTransferObject.CategoryRequest;
import lt.stud.techin.library.model.Category;
import lt.stud.techin.library.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api/v1/books/categories")
public class CategoryController {

    CategoryService categoryService;

    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    List<Category> getCategory(){
        return categoryService.getCategory();
    }

    @PostMapping
    Category addCategory(@RequestBody CategoryRequest newCategory){
        return categoryService.addCategory(newCategory);
    }

    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
