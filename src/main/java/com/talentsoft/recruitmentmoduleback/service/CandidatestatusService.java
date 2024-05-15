package com.talentsoft.recruitmentmoduleback.service;

import com.talentsoft.recruitmentmoduleback.model.Candidatestatus;
import com.talentsoft.recruitmentmoduleback.repository.CandidateStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CandidatestatusService {

    @Autowired
    private CandidateStatusRepository candidateStatusRepository;

    /**
     * @name getAll
     * @description Retrieves all existing Candidatestatus.
     *
     * @return An iterable list of Candidatestatus
     */
    public Iterable<Candidatestatus> getAll(){
        return candidateStatusRepository.findAll();
    }

    /**
     * @name getById
     * @description Retrieves Candidatestatus by its ID.
     *
     * @param id the ID of the Candidatestatus
     * @return An optional containing the Candidatestatus with the specified ID, if exists
     */
    public Optional<Candidatestatus> getById(Long id){
        return candidateStatusRepository.findById(id);
    }

    /**
     * @name getById
     * @description Retrieves Candidatestatus by its ID.
     *
     * @param description the Name of the Candidatestatus
     * @return An optional containing the Candidatestatus with the specified ID, if exists
     */
    public Candidatestatus getByDescription(String description){
        Iterable<Candidatestatus> allStatus = candidateStatusRepository.findAll();

        for(Candidatestatus c : allStatus){
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
    public Candidatestatus create(Candidatestatus Candidatestatus){
        return candidateStatusRepository.save(Candidatestatus);
    }

    /**
     * @name update
     * @description Updates an existing Candidatestatus.
     *
     * @param Candidatestatus the Candidatestatus to update
     * @return The updated Candidatestatus
     */
    public Candidatestatus update(Candidatestatus Candidatestatus){
        return candidateStatusRepository.save(Candidatestatus);
    }
    
}
