package com.talentsoft.recruitmentmoduleback.controller;

import com.talentsoft.recruitmentmoduleback.DTO.CandidateDTO;
import com.talentsoft.recruitmentmoduleback.exception.CandidateNotFoundException;
import com.talentsoft.recruitmentmoduleback.model.Candidate;
import com.talentsoft.recruitmentmoduleback.service.CandidateService;
import com.talentsoft.recruitmentmoduleback.service.candidateStatusService;
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
    public CandidateController(CandidateService candidateService, candidateStatusService candidatestatusService) {
        this.candidateService = candidateService;
    }

    @CrossOrigin
    @GetMapping("/getCandidates/{id}")
    public Iterable<Candidate> getAllCandidates(@PathVariable int id) {
        return candidateService.getAllByCompany(id);
    }

    /***
     * @name getCandidateById
     * @description Retrieves a Candidate by their ID.
     *
     * @param id the ID of the Candidate.
     * @return An optional containing the Candidate with the specified ID, if exists.
     */

    @GetMapping("/{id}")
    public Optional<Candidate> getCandidateById(@PathVariable Long id) {
        return candidateService.getById(id);
    }

    /**
     * @name createCandidate
     * @description Creates a new Candidate.
     * @param candidate the details of the Candidate to create.
     * @return The newly created Candidate.
     */

    @PostMapping("/createCandidate")
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateService.create(candidate);
    }

    /**
     * @name updateCandidate
     * @description Updates an existing Candidate.
     *
     * @param id the ID of the Candidate to update.
     * @param candidateDetails the details of the updated Candidate.
     * @return The updated Candidate.
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
     * @name deleteCandidate
     * @description Updates an existing Candidate.
     *
     * @param id the ID of the Candidate to update.
     * @return The updated Candidate.
     */
    @CrossOrigin
    @PutMapping("/deleteCandidate/{id}")
    public Candidate deleteCandidate(@PathVariable Long id){
        Optional<Candidate> candidateOptional = candidateService.getById(id);

        Candidate candidate = candidateOptional.get();

        candidate.setCandidateStatusId(7);

        return candidateService.update(candidate);

    }

}
