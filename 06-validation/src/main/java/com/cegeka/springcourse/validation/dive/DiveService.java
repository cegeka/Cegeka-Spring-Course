package com.cegeka.springcourse.validation.dive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Component
@Validated
public class DiveService {

    @Autowired
    private DiveRepository diveRepository;

    @Validated(OnCreate.class)
    public List<Dive> addDives(@Valid List<Dive> dives) {
        dives.forEach(Dive::generateId);
        return diveRepository.saveAll(dives);
    }

    @Validated(OnUpdate.class)
    public void updateDive(@Valid Dive dive) {
        diveRepository.save(dive);
    }
}
