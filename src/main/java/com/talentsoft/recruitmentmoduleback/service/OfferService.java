package com.talentsoft.recruitmentmoduleback.service;

import com.talentsoft.recruitmentmoduleback.DTO.request.OfferUpdateRequest;
import com.talentsoft.recruitmentmoduleback.DTO.request.OfferUpdateStatusRequest;
import com.talentsoft.recruitmentmoduleback.exception.OfferNotFoundException;
import com.talentsoft.recruitmentmoduleback.model.Offer;
import com.talentsoft.recruitmentmoduleback.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

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
        return offerRepository.findAllByCompanyId(id);
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

    public Offer updateOffer(Long id, OfferUpdateRequest offerUpdateRequest) {
        Offer offer = offerRepository.findById(id).orElseThrow(() -> new RuntimeException("Offer not found"));
        offer.setStatus(offerUpdateRequest.getStatus());
        offer.setTittleoffer(offerUpdateRequest.getTittleOffer());
        offer.setDescription(offerUpdateRequest.getDescription());
        offer.setRequeriments(offerUpdateRequest.getRequirements());
        return offerRepository.save(offer);
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

    public Offer updateOfferStatus(Long id, OfferUpdateStatusRequest status) {
        Offer offer = offerRepository.findById(id).orElseThrow(() -> new OfferNotFoundException("Offer not found"));
        offer.setStatus(status.getStatus());
        return offerRepository.save(offer);
    }
}
