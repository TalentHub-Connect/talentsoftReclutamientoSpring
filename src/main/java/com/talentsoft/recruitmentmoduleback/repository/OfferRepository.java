package com.talentsoft.recruitmentmoduleback.repository;

import com.talentsoft.recruitmentmoduleback.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
