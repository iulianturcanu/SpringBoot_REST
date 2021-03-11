package com.iudtu.lunchbox.repository;

import com.iudtu.lunchbox.model.LunchboxItem;
import org.springframework.data.repository.CrudRepository;

public interface LunchboxItemRepository extends CrudRepository<LunchboxItem, Long> {
}
