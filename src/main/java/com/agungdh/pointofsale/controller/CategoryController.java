package com.agungdh.pointofsale.controller;

import com.agungdh.pointofsale.dto.CategoryCreateRequest;
import com.agungdh.pointofsale.entity.Category;
import com.agungdh.pointofsale.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody CategoryCreateRequest categoryCreateRequest) {
        return ResponseEntity.ok(categoryService.save(categoryCreateRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @Valid @RequestBody CategoryCreateRequest categoryCreateRequest) {
        Optional<Category> existingCategory = Optional.ofNullable(categoryService.findById(id));
        if (existingCategory.isPresent()) {
            Category updatedCategory = categoryService.update(id, categoryCreateRequest);
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> category = Optional.ofNullable(categoryService.findById(id));
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Category> category = Optional.ofNullable(categoryService.findById(id));
        if (category.isPresent()) {
            categoryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
