package com.talentsoft.recruitmentmoduleback.service;

import com.talentsoft.recruitmentmoduleback.model.CandidateStatus;
import com.talentsoft.recruitmentmoduleback.repository.CandidateStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class candidateStatusService {

    private final CandidateStatusRepository candidateStatusRepository;

    @Autowired
    public candidateStatusService(CandidateStatusRepository candidateStatusRepository) {
        this.candidateStatusRepository = candidateStatusRepository;
    }

    /**
     * @name getAll
     * @description Retrieves all existing Candidatestatus.
     *
     * @return An iterable list of Candidatestatus
     */
    public Iterable<CandidateStatus> getAll(){
        return candidateStatusRepository.findAll();
    }

    /**
     * @name getById
     * @description Retrieves Candidatestatus by its ID.
     *
     * @param id the ID of the Candidatestatus
     * @return An optional containing the Candidatestatus with the specified ID, if exists
     */
    public Optional<CandidateStatus> getById(Long id){
        return candidateStatusRepository.findById(id);
    }

    public CandidateStatus getByDescription(String description){
        Iterable<CandidateStatus> allStatus = candidateStatusRepository.findAll();

        for(CandidateStatus c : allStatus){
            if(c.getDescription().equals(description)){
                return c;
            }
        }

        return null;
    }

    /**
     * @name create
     * @description Creates a new Candidatestatus.
     *
     * @param Candidatestatus the details of the Candidatestatus to create
     * @return The newly created Candidatestatus
     */
    public CandidateStatus create(CandidateStatus Candidatestatus){
        return candidateStatusRepository.save(Candidatestatus);
    }

    /**
     * @name update
     * @description Updates an existing Candidatestatus.
     *
     * @param Candidatestatus the Candidatestatus to update
     * @return The updated Candidatestatus
     */
    public CandidateStatus update(CandidateStatus Candidatestatus){
        return candidateStatusRepository.save(Candidatestatus);
    }
    
}
