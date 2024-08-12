package com.example.capstoneupdate.Controller;

import com.example.capstoneupdate.Model.Category;
import com.example.capstoneupdate.Service.CategoryService;
import com.example.capstoneupdate.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final UserService userService;

    //GET DONE
    @GetMapping("/get")
    public ResponseEntity getCategory() {
        if (categoryService.getCategories().isEmpty()) {
            return ResponseEntity.status(200).body("sorry nothing here yet..");
        }
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }
    //ADD DONE
    @PostMapping("/admin/{userId}")
    public ResponseEntity addCategory(@PathVariable Integer userId, @Valid @RequestBody Category category,Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body("category update failed, only for Admin"+ errorMessage);
        }
        return ResponseEntity.status(201).body("category added successfully");
    }
}

@PutMapping("/update/{id}")
public ResponseEntity updateCategory(@PathVariable Integer id, @Valid @RequestBody Category category, Errors errors) {
    if (errors.hasErrors()) {
        String errorMessage = errors.getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.status(400).body("category update failed, only for Admin"+ errorMessage);
    }
    boolean isCategoryUpdated = categoryService.updateCategory(id, category);
    if (isCategoryUpdated) {
        return ResponseEntity.status(201).body("Category updated successfully");
    }

    return ResponseEntity.status(400).body("Category update failed");
}


DELETE DONE
@DeleteMapping("/admin/{userId}/{id}")
public ResponseEntity deleteCategory(@PathVariable Integer userId, @PathVariable Integer id) {
    boolean isDeleted = categoryService.adminRemoveCategory(userId, id);
    if (isDeleted) {
        return ResponseEntity.status(201).body("category deleted successfully");
    }
    return ResponseEntity.status(400).body("category delete failed, only for Admin");

}

}


    //endpoint to check if the role is admin he can add category and delete it
    @PostMapping("/admin/{userId}")
    public ResponseEntity updateCategoryAdmin(@PathVariable int userId, @Valid @RequestBody Category category) {
        boolean isAdded = categoryService.adminAddCategory(userId,category);
        if (isAdded) {
            return ResponseEntity.status(201).body("category added successfully");
        }
        return ResponseEntity.status(400).body("category update failed, only for Admin");
}
@DeleteMapping("/admin/{userId}/{id}")
    public ResponseEntity deleteCategoryAdmin(@PathVariable int userId, @PathVariable int id) {
        boolean isDeleted = categoryService.adminRemoveCategory(userId, id);
        if (isDeleted) {
            return ResponseEntity.status(201).body("category deleted successfully");
        }
        return ResponseEntity.status(400).body("category delete failed, only for Admin");

}






