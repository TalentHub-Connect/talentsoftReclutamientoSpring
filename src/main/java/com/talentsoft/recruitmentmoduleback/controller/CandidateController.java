package com.talentsoft.recruitmentmoduleback.controller;

import com.talentsoft.recruitmentmoduleback.DTO.CandidateDTO;
import com.talentsoft.recruitmentmoduleback.model.Candidate;
import com.talentsoft.recruitmentmoduleback.model.Candidatestatus;
import com.talentsoft.recruitmentmoduleback.model.Offer;
import com.talentsoft.recruitmentmoduleback.service.CandidateService;
import com.talentsoft.recruitmentmoduleback.service.CandidatestatusService;
import com.talentsoft.recruitmentmoduleback.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    /**
     * @description Conects with the services for Candidate.
     */
    @Autowired
    private CandidateService candidateService;

    /**
     * @description Conects with the services for Candidatestatus.
     */
    @Autowired
    private CandidatestatusService candidatestatusService;


    /***
     * @name getAllCandidates
     * @description Retrieves all existing Candidates.
     *
     * @return An iterable list of Candidates.
     */
    @CrossOrigin
    @GetMapping("/getCandidates/{id}")
    public Iterable<Candidate> getAllCandidates(@PathVariable Long id) {
        return candidateService.getAllByCompany(id);
    }

    /***
     * @name getCandidateById
     * @description Retrieves a Candidate by their ID.
     *
     * @param id the ID of the Candidate.
     * @return An optional containing the Candidate with the specified ID, if exists.
     */
    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Candidate> getCandidateById(@PathVariable Long id) {
        return candidateService.getById(id);
    }

    /***
     * @name createCandidate
     * @description Creates a new Candidate.
     *
     * @param candidate the details of the Candidate to create.
     * @return The newly created Candidate.
     */
    @CrossOrigin
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
    @CrossOrigin
    @PutMapping("/updateCandidate/{id}")
    public Candidate updateCandidate(@PathVariable Long id, @RequestBody CandidateDTO candidateDetails){
        Optional<Candidate> optionalCandidate = candidateService.getById(id);
        Candidatestatus ca = candidatestatusService.getByDescription(candidateDetails.getStatus());

        Candidate candidate = optionalCandidate.get();

        candidate.setCandidatestatusid(ca.getId());
        candidate.setPhonenumber(candidateDetails.getPhonenumber());

        return candidateService.update(candidate);

    }

    /**
     * @name deleteCandidate
     * @description Updates an existing Candidate.
     *
     * @param id the ID of the Candidate to update.
     * @param candidateDetails the details of the updated Candidate.
     * @return The updated Candidate.
     */
    @CrossOrigin
    @PutMapping("/deleteCandidate/{id}")
    public Candidate deleteCandidate(@PathVariable Long id, @RequestBody Candidate candidateDetails){
        Optional<Candidate> candidateOptional = candidateService.getById(id);

        Candidate candidate = candidateOptional.get();

        candidate.setCandidatestatusid(7); // The number 7 has the Rejected status.

        return candidateService.update(candidate);

    }

}
