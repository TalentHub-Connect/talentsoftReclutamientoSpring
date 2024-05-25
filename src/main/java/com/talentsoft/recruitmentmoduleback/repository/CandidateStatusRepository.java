package com.talentsoft.recruitmentmoduleback.repository;

import com.talentsoft.recruitmentmoduleback.model.CandidateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateStatusRepository  extends JpaRepository<CandidateStatus, Long> {
}
