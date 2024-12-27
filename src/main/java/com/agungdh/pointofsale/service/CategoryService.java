package com.agungdh.pointofsale.service;

import com.agungdh.pointofsale.dto.CategoryCreateRequest;
import com.agungdh.pointofsale.entity.Category;
import com.agungdh.pointofsale.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category save(CategoryCreateRequest categoryCreateRequest) {
        Category category = new Category();
        category.setName(categoryCreateRequest.name());
        return categoryRepository.save(category);
    }

    public Category update(Long id, CategoryCreateRequest categoryCreateRequest) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(categoryCreateRequest.name());
            return categoryRepository.save(existingCategory);
        }
        return null; // or throw an exception if preferred
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}