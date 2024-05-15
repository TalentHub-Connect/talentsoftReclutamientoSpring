package com.talentsoft.recruitmentmoduleback.service;

import com.talentsoft.recruitmentmoduleback.model.Candidate;
import com.talentsoft.recruitmentmoduleback.model.Offer;
import com.talentsoft.recruitmentmoduleback.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    /**
     * @name getAll
     * @description Retrieves all existing Offers.
     *
     * @return An iterable list of Offers
     */
    public Iterable<Offer> getAll(){
        return offerRepository.findAll();
    }

    /**
     * @name getAllByCompany
     * @description Retrieves all existing Offers.
     *
     * @return An iterable list of Offers
     */
    public List<Offer> getAllByCompany(Long id){

        Iterable<Offer> offers = offerRepository.findAll();
        List<Offer> returnOffers = new ArrayList<>();

        for(Offer offer : offers){
            if(offer.getCompanyid().intValue() == id){
                returnOffers.add(offer);
            }
        }

        return returnOffers;
    }

    /**
     * @name getById
     * @description Retrieves Offer by its ID.
     *
     * @param id the ID of the Offer
     * @return An optional containing the Offer with the specified ID, if exists
     */
    public Optional<Offer> getById(Long id){
        return offerRepository.findById(id);
    }

    /**
     * @name create
     * @description Creates a new Offer.
     *
     * @param offer the details of the Offer to create
     * @return The newly created Offer
     */
    public Offer create(Offer offer){
        return offerRepository.save(offer);
    }

    /**
     * @name update
     * @description Updates an existing Offer.
     *
     * @param offer the Offer to update
     * @return The updated Offer
     */
    public Offer update(Offer offer){
        return offerRepository.save(offer);
    }
    
}
