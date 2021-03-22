package com.iudtu.lunchbox.repository;

import com.iudtu.lunchbox.dto.LunchboxDto;
import com.iudtu.lunchbox.model.Lunchbox;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LunchboxRepository extends CrudRepository<Lunchbox, Long> {

    Optional<Lunchbox> findLunchboxByOwner(String owner);
    Optional<Lunchbox> findLunchboxByDescription(String description);
}
