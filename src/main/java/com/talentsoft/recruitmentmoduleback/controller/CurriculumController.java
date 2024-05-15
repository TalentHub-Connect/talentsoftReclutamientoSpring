package com.talentsoft.recruitmentmoduleback.controller;

import com.talentsoft.recruitmentmoduleback.model.Curriculum;
import com.talentsoft.recruitmentmoduleback.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {


    /**
     * @description Conects with the services for Curriculum.
     */
    @Autowired
    private CurriculumService curriculumService;

    /***
     * @name getCurriculumById
     * @description Retrieves a Curriculum by their ID.
     *
     * @param id the ID of the Curriculum.
     * @return An optional containing the Curriculum with the specified ID, if exists.
     */
    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Curriculum> getCurriculumById(@PathVariable Long id) {
        return curriculumService.getById(id);
    }

    /***
     * @name createCurriculum
     * @description Creates a new Curriculum.
     *
     * @param curriculum the details of the Curriculum to create.
     * @return The newly created Curriculum.
     */
    @CrossOrigin
    @PostMapping("/createCurriculum")
    public ResponseEntity<Long> createCurriculum(@RequestBody Curriculum curriculum) {
        try {
            Curriculum cu = curriculumService.create(curriculum);
            Long curriculumId = cu.getId().longValue();
            return new ResponseEntity<>(curriculumId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @name updateCurriculum
     * @description Updates an existing Curriculum.
     *
     * @param id the ID of the Curriculum to update.
     * @param curriculumDetails the details of the updated Curriculum.
     * @return The updated Curriculum.
     */
    @CrossOrigin
    @PutMapping("/updateCurriculum/{id}")
    public Curriculum updateCurriculum(@PathVariable Long id, @RequestBody Curriculum curriculumDetails){
        Optional<Curriculum> optionalCurriculum = curriculumService.getById(id);

        Curriculum curriculum = optionalCurriculum.get();

        curriculum.setAddress(curriculumDetails.getAddress());
        curriculum.setPersonalobjetive(curriculumDetails.getPersonalobjetive());
        curriculum.setWorkexperience(curriculumDetails.getWorkexperience());
        curriculum.setEducationalhistory(curriculumDetails.getEducationalhistory());
        curriculum.setLanguage(curriculumDetails.getLanguage());
        curriculum.setCertification(curriculumDetails.getCertification());
        curriculum.setPersonalreference(curriculumDetails.getPersonalreference());
        curriculum.setUniversity(curriculumDetails.getUniversity());

        return curriculumService.update(curriculum);

    }

}
