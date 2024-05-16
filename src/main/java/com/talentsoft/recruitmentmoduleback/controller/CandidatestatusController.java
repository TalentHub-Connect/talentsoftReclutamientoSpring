package com.talentsoft.recruitmentmoduleback.controller;

import com.talentsoft.recruitmentmoduleback.model.CandidateStatus;
import com.talentsoft.recruitmentmoduleback.service.candidateStatusService;
import com.talentsoft.recruitmentmoduleback.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/candidatestatus")
public class CandidatestatusController {

    /**
     * @description Conects with the services for Candidatestatus.
     */
    @Autowired
    private candidateStatusService candidatestatusService;

    /**
     * @description Conects with the services for Curriculum.
     */
    @Autowired
    private CurriculumService curriculumService;

    /**
     * @description Conects with the services for Offer.
     */
    @Autowired
    private OfferController offerController;

    /***
     * @name getAllCandidatestatus
     * @description Retrieves all existing Candidatestatus.
     *
     * @return An iterable list of Candidatestatus.
     */
    @CrossOrigin
    @GetMapping("/getCandidatestatus")
    public Iterable<CandidateStatus> getAllCandidatestatuss() {
        return candidatestatusService.getAll();
    }

    /***
     * @name getCandidatestatusById
     * @description Retrieves a Candidatestatus by their ID.
     *
     * @param id the ID of the Candidatestatus.
     * @return An optional containing the Candidatestatus with the specified ID, if exists.
     */
    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<CandidateStatus> getCandidatestatusById(@PathVariable Long id) {
        return candidatestatusService.getById(id);
    }

    /***
     * @name createCandidatestatus
     * @description Creates a new Candidatestatus.
     *
     * @param Candidatestatus the details of the Candidatestatus to create.
     * @return The newly created Candidatestatus.
     */
    @CrossOrigin
    @PostMapping("/createCandidatestatus")
    public CandidateStatus createCandidatestatus(@RequestBody CandidateStatus Candidatestatus) {
        return candidatestatusService.create(Candidatestatus);
    }

    /**
     * @name updateCandidatestatus
     * @description Updates an existing Candidatestatus.
     *
     * @param id the ID of the Candidatestatus to update.
     * @param candidateStatusDetails the details of the updated Candidatestatus.
     * @return The updated Candidatestatus.
     */
    @CrossOrigin
    @PutMapping("/updateCandidatestatus/{id}")
    public CandidateStatus updateCandidatestatus(@PathVariable Long id, @RequestBody CandidateStatus candidateStatusDetails){
        Optional<CandidateStatus> optionalCandidatestatus = candidatestatusService.getById(id);

        CandidateStatus candidatestatus = optionalCandidatestatus.get();

        candidatestatus.setDescription(candidateStatusDetails.getDescription());

        return candidatestatusService.update(candidatestatus);

    }

}
