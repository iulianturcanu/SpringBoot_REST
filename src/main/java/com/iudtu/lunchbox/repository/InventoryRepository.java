package com.iudtu.lunchbox.repository;


import com.iudtu.lunchbox.model.Inventory;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.NamedQuery;
import java.util.Optional;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Optional<Inventory> findByLunchboxItemNameAndCount(Integer count);
}
