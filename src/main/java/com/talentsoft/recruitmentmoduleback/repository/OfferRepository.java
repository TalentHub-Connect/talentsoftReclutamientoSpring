package com.talentsoft.recruitmentmoduleback.repository;

import com.talentsoft.recruitmentmoduleback.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Query("SELECT c FROM Offer c WHERE c.companyid = ?1 AND c.status != 'Eliminado'")
    List<Offer> findAllByCompanyId(Long companyId);
}
