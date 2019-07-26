package com.cegeka.springcourse.validation.dive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiveService {

    @Autowired
    private DiveRepository diveRepository;

    public List<Dive> addDives(List<Dive> dives) {
        dives.forEach(Dive::generateId);
        return diveRepository.saveAll(dives);
    }

    public void updateDive(Dive dive) {
        diveRepository.save(dive);
    }
}
