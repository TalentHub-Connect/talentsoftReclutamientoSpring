package com.talentsoft.recruitmentmoduleback.controller;

import com.talentsoft.recruitmentmoduleback.model.Candidatestatus;
import com.talentsoft.recruitmentmoduleback.service.CandidateService;
import com.talentsoft.recruitmentmoduleback.service.CandidatestatusService;
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
    private CandidatestatusService candidatestatusService;

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
    @GetMapping("/getCandidatestatus/{id}")
    public Iterable<Candidatestatus> getAllCandidatestatuss(@PathVariable Long id) {
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
    public Optional<Candidatestatus> getCandidatestatusById(@PathVariable Long id) {
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
    public Candidatestatus createCandidatestatus(@RequestBody Candidatestatus Candidatestatus) {
        return candidatestatusService.create(Candidatestatus);
    }

    /**
     * @name updateCandidatestatus
     * @description Updates an existing Candidatestatus.
     *
     * @param id the ID of the Candidatestatus to update.
     * @param candidatestatusDetails the details of the updated Candidatestatus.
     * @return The updated Candidatestatus.
     */
    @CrossOrigin
    @PutMapping("/updateCandidatestatus/{id}")
    public Candidatestatus updateCandidatestatus(@PathVariable Long id, @RequestBody Candidatestatus candidatestatusDetails){
        Optional<Candidatestatus> optionalCandidatestatus = candidatestatusService.getById(id);

        Candidatestatus candidatestatus = optionalCandidatestatus.get();

        candidatestatus.setDescription(candidatestatusDetails.getDescription());

        return candidatestatusService.update(candidatestatus);

    }

}
