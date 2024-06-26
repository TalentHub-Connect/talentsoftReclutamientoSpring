package com.talentsoft.recruitmentmoduleback.service;

import com.talentsoft.recruitmentmoduleback.exception.CandidateNotFoundException;
import com.talentsoft.recruitmentmoduleback.model.Candidate;
import com.talentsoft.recruitmentmoduleback.model.CandidateStatus;
import com.talentsoft.recruitmentmoduleback.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {


    private final CandidateRepository candidateRepository;

    private final candidateStatusService candidateStatusService;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository, candidateStatusService candidateStatusService) {
        this.candidateRepository = candidateRepository;
        this.candidateStatusService = candidateStatusService;
    }

    /**
     * @name getAll
     * @description Retrieves all existing Candidates.
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
    public List<Candidate> getAllByCompany(int id) {
        return candidateRepository.findAllByCompanyIdAndStatusNotEliminado(id);
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
     * @description Updates an existing Candidate
     * @param candidate the Candidate to update
     * @return The updated Candidate
     */

    public Candidate update(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Integer id, String status, String phoneNumber) {
       try{
              Candidate candidate = candidateRepository.findById(id).orElse(null);
              if(candidate != null){
                   CandidateStatus candidateStatus = candidateStatusService.getByDescription(status);
                     if(candidateStatus != null){
                          candidate.setCandidateStatusId(candidateStatus.getId());
                     }
                candidate.setPhoneNumber(phoneNumber);
                return candidateRepository.save(candidate);
              }
              return null;
       }catch (Exception e){
           throw new CandidateNotFoundException("Candidate not found with id: " + id);
       }
    }

    public Optional<Candidate> getById(Integer id) {
        return candidateRepository.findById(id);
    }



    public Candidate softDeleteCandidate(Integer id) {
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        if(candidate != null){
            candidate.setCandidateStatusId(7);
            return candidateRepository.save(candidate);
        }
        return null;
    }
}
