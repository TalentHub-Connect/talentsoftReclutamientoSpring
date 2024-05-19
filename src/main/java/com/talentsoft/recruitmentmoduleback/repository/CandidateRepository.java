package com.talentsoft.recruitmentmoduleback.repository;

import com.talentsoft.recruitmentmoduleback.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository  extends JpaRepository<Candidate, Integer> {
    @Query("SELECT c FROM Candidate c WHERE c.companyid = ?1 AND c.candidateStatusId != 7")
    List<Candidate> findAllByCompanyIdAndStatusNotEliminado(int companyId);
}
