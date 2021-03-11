package com.iudtu.lunchbox.repository;

import com.iudtu.lunchbox.model.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}
