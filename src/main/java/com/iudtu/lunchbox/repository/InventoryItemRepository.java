package com.iudtu.lunchbox.repository;


import com.iudtu.lunchbox.model.InventoryItem;
import com.iudtu.lunchbox.model.LunchboxItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryItemRepository extends CrudRepository<InventoryItem, Long> {

    @Override
    List<InventoryItem> findAll();

    Optional<InventoryItem> findOneByItem(LunchboxItem item);


}
