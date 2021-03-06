package com.iudtu.lunchbox.repository;

import com.iudtu.lunchbox.dto.ItemType;
import com.iudtu.lunchbox.model.LunchboxItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;
import java.util.Optional;

public interface LunchboxItemRepository extends CrudRepository<LunchboxItem, Long> {

    Optional<LunchboxItem> findOneByName(String name);
    Iterator<LunchboxItem> findByItemType(ItemType itemType);

}
