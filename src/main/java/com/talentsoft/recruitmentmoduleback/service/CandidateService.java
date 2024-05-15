package com.talentsoft.recruitmentmoduleback.service;

import com.talentsoft.recruitmentmoduleback.model.Candidate;
import com.talentsoft.recruitmentmoduleback.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    /**
     * @name getAll
     * @description Retrieves all existing Candidates.
     *
     * @return An iterable list of Candidates
     */
    public Iterable<Candidate> getAll(){
        return candidateRepository.findAll();
    }

    /**
     * @name getAllByCompany
     * @description Retrieves all existing Candidates.
     *
     * @return An iterable list of Candidates
     */
    public List<Candidate> getAllByCompany(Long id){

        Iterable<Candidate> candidates = candidateRepository.findAll();
        List<Candidate> returnCantidades = new ArrayList<>();

        for(Candidate candidate : candidates){
            if(candidate.getCompanyid().intValue() == id){
                returnCantidades.add(candidate);
            }
        }

        return returnCantidades;
    }

    /**
     * @name getById
     * @description Retrieves Candidate by its ID.
     *
     * @param id the ID of the Candidate
     * @return An optional containing the Candidate with the specified ID, if exists
     */
    public Optional<Candidate> getById(Long id){
        return candidateRepository.findById(id);
    }

    /**
     * @name create
     * @description Creates a new Candidate.
     *
     * @param candidate the details of the Candidate to create
     * @return The newly created Candidate
     */
    public Candidate create(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    /**
     * @name update
     * @description Updates an existing Candidate.
     *
     * @param candidate the Candidate to update
     * @return The updated Candidate
     */
    public Candidate update(Candidate candidate){
        return candidateRepository.save(candidate);
    }

}
