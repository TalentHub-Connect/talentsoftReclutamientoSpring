package com.talentsoft.recruitmentmoduleback.controller;

import com.talentsoft.recruitmentmoduleback.DTO.request.CurriculumRequest;
import com.talentsoft.recruitmentmoduleback.model.Curriculum;
import com.talentsoft.recruitmentmoduleback.service.CurriculumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    private final CurriculumService curriculumService;

    @Autowired
    public CurriculumController(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }

    /***
     * @name getCurriculumById
     * @description Retrieves a Curriculum by their ID.
     *
     * @param id the ID of the Curriculum.
     * @return An optional containing the Curriculum with the specified ID, if exists.
     */

    @GetMapping("/{id}")
    public Optional<Curriculum> getCurriculumById(@PathVariable Long id) {
        if (curriculumService.getById(id).isPresent()) {
            return curriculumService.getById(id);
        } else {
            return Optional.empty();
        }
    }

    /***
     * @name createCurriculum
     * @description Creates a new Curriculum.
     *
     * @param curriculum the details of the Curriculum to create.
     * @return The newly created Curriculum.
     */

    @PostMapping("/createCurriculum")
    public ResponseEntity<?> createCurriculum(@RequestBody CurriculumRequest curriculum) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(curriculumService.create(curriculum));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
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


    @Operation(summary = "Update curriculum")
    @ApiResponse(responseCode = "200", description = "Curriculum updated")
    @ApiResponse(responseCode = "404", description = "Curriculum not found")
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
