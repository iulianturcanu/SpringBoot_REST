package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.dto.LunchboxDto;
import com.iudtu.lunchbox.dto.mapper.LunchboxMapper;
import com.iudtu.lunchbox.model.Lunchbox;
import com.iudtu.lunchbox.repository.LunchboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LunchboxService {

    private final LunchboxRepository lunchboxRepository;

    @Autowired
    public LunchboxService(LunchboxRepository lunchboxRepository) {
        this.lunchboxRepository = lunchboxRepository;
    }

    public LunchboxDto create() {
        return LunchboxMapper.toLunchboxDto(new Lunchbox());
    }


    public LunchboxDto createWithOwner(String owner) {
        Optional<Lunchbox> lunchboxByOwner = lunchboxRepository.findLunchboxByOwner(owner);
        if (lunchboxByOwner.isPresent()) {
            throw new IllegalStateException("Owner already present");
        }
        Lunchbox newLunchbox = new Lunchbox(owner, "unknown", 0, new ArrayList<>(1));
        lunchboxRepository.save(newLunchbox);
        return LunchboxMapper.toLunchboxDto(newLunchbox);

    }

    public LunchboxDto findWithDescription(String description) {
        Lunchbox withDescription = lunchboxRepository.findLunchboxByDescription(description).orElseThrow(IllegalStateException::new);
        return LunchboxMapper.toLunchboxDto(withDescription);
    }

    public void deleteAll() {
        lunchboxRepository.deleteAll();
    }

    public void saveOne(Lunchbox lunchbox){
        lunchboxRepository.save(lunchbox);
    }

    public void saveAll(Iterable<Lunchbox> lunchboxes){
        lunchboxes.forEach(lunchboxRepository::save);
    }


}
