package com.talentsoft.recruitmentmoduleback.service;

import com.talentsoft.recruitmentmoduleback.model.Candidate;
import com.talentsoft.recruitmentmoduleback.model.Curriculum;
import com.talentsoft.recruitmentmoduleback.repository.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CurriculumService {

    private final CurriculumRepository curriculumRepository;

    @Autowired
    public CurriculumService(CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }

    /**
     * @name getAll
     * @description Retrieves all existing Curriculums.
     *
     * @return An iterable list of Curriculums
     */
    public Iterable<Curriculum> getAll(){
        return curriculumRepository.findAll();
    }

    /**
     * @name getById
     * @description Retrieves Curriculum by its ID.
     *
     * @param id the ID of the Curriculum
     * @return An optional containing the Curriculum with the specified ID, if exists
     */
    public Optional<Curriculum> getById(Long id){
        return curriculumRepository.findById(id);
    }

    /**
     * @name create
     * @description Creates a new Curriculum.
     *
     * @param curriculum the details of the Curriculum to create
     * @return The newly created Curriculum
     */
    public Curriculum create(Curriculum curriculum){
        return curriculumRepository.save(curriculum);
    }

    /**
     * @name update
     * @description Updates an existing Curriculum.
     *
     * @param curriculum the Curriculum to update
     * @return The updated Curriculum
     */
    public Curriculum update(Curriculum curriculum){
        return curriculumRepository.save(curriculum);
    }


}
