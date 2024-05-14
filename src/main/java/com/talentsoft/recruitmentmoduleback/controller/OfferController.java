package com.talentsoft.recruitmentmoduleback.controller;

import com.talentsoft.recruitmentmoduleback.model.Offer;
import com.talentsoft.recruitmentmoduleback.service.OfferService;
import com.talentsoft.recruitmentmoduleback.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/offer")
public class OfferController {

    /**
     * @description Conects with the services for Offer.
     */
    @Autowired
    private OfferService offerService;

    /***
     * @name getAllOffers
     * @description Retrieves all existing Offers.
     *
     * @return An iterable list of Offers.
     */
    @CrossOrigin
    @GetMapping("/getOffers/{id}")
    public Iterable<Offer> getAllOffers(@PathVariable Long id) {
        return offerService.getAllByCompany(id);
    }

    /***
     * @name getOfferById
     * @description Retrieves a Offer by their ID.
     *
     * @param id the ID of the Offer.
     * @return An optional containing the Offer with the specified ID, if exists.
     */
    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Offer> getOfferById(@PathVariable Long id) {
        return offerService.getById(id);
    }

    /***
     * @name createOffer
     * @description Creates a new Offer.
     *
     * @param Offer the details of the Offer to create.
     * @return The newly created Offer.
     */
    @CrossOrigin
    @PostMapping("/createOffer")
    public Offer createOffer(@RequestBody Offer Offer) {
        return offerService.create(Offer);
    }

    /**
     * @name updateOffer
     * @description Updates an existing Offer.
     *
     * @param id the ID of the Offer to update.
     * @param offerDetails the details of the updated Offer.
     * @return The updated Offer.
     */
    @CrossOrigin
    @PutMapping("/updateOffer/{id}")
    public Offer updateOffer(@PathVariable Long id, @RequestBody Offer offerDetails){
        Optional<Offer> optionalOffer = offerService.getById(id);

        Offer offer = optionalOffer.get();

        offer.setTittleoffer(offerDetails.getTittleoffer());
        offer.setDescription(offerDetails.getDescription());
        offer.setExperience(offerDetails.getExperience());
        offer.setPublishdate(offerDetails.getPublishdate());
        offer.setRequeriments(offerDetails.getRequeriments());
        offer.setStatus(offerDetails.getStatus());

        return offerService.update(offer);

    }
    
}
