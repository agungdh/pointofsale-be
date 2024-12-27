package com.agungdh.pointofsale.repository;

import com.agungdh.pointofsale.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
