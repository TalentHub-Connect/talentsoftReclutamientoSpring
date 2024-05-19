package com.talentsoft.recruitmentmoduleback.controller;

import com.talentsoft.recruitmentmoduleback.DTO.request.CandidateDTO;
import com.talentsoft.recruitmentmoduleback.exception.CandidateNotFoundException;
import com.talentsoft.recruitmentmoduleback.model.Candidate;
import com.talentsoft.recruitmentmoduleback.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getCandidates/company/{id}")
    public Iterable<Candidate> getAllByCompany(@PathVariable int id) {
        return candidateService.getAllByCompany(id);
    }

    @GetMapping("/getAllCandidates")
    public Iterable<Candidate> getAllCandidates() {
        return candidateService.getAll();
    }

    /***
     * @name getCandidateById
     * @description Retrieves a Candidate by their ID.
     * @param id the ID of the Candidate.
     * @return An optional containing the Candidate with the specified ID, if exists.
     */

    @GetMapping("/{id}")
    public ResponseEntity<?> getCandidateById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(candidateService.getById(id));
        } catch (CandidateNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * @param candidate the details of the Candidate to create.
     * @return The newly created Candidate.
     * @name createCandidate
     * @description Creates a new Candidate.
     */

    @PostMapping("/createCandidate")
    public ResponseEntity<?> createCandidate(@RequestBody Candidate candidate) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.create(candidate));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * @param id               the ID of the Candidate to update.
     * @param candidateDetails the details of the updated Candidate.
     * @return The updated Candidate.
     * @name updateCandidate
     * @description Updates an existing Candidate.
     */

    @PutMapping("/updateCandidate/{id}")
    public ResponseEntity<?> updateCandidate(@PathVariable Long id, @RequestBody CandidateDTO candidateDetails) {
        try {
            Candidate updatedCandidate = candidateService.updateCandidate(id, candidateDetails.getStatus(), candidateDetails.getPhoneNumber());
            return ResponseEntity.ok(updatedCandidate);
        } catch (CandidateNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
      * @param id the ID of the Candidate to set the status to "Eliminado".
      * @return A message indicating the result of the operation.
      * @name deleteCandidate
      * @description Deletes a Candidate.
      */

    @PutMapping("/deleteCandidate/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable Long id) {
        try {
            candidateService.softDeleteCandidate(id);
            return ResponseEntity.status(HttpStatus.OK).body("Candidate deleted successfully");
        } catch (CandidateNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
