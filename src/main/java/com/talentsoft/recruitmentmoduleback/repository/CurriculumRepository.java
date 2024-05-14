package com.talentsoft.recruitmentmoduleback.repository;

import com.talentsoft.recruitmentmoduleback.model.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository  extends JpaRepository<Curriculum, Long> {
}
