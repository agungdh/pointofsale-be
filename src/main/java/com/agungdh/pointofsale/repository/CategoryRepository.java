package com.agungdh.pointofsale.repository;

import com.agungdh.pointofsale.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
