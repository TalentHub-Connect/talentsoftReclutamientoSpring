package com.talentsoft.recruitmentmoduleback.controller;

import com.talentsoft.recruitmentmoduleback.model.Offer;
import com.talentsoft.recruitmentmoduleback.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/updateOffer/{id}")
    public ResponseEntity<?> updateOffer(@PathVariable Long id, @RequestParam String status, @RequestParam String tittleOffer, @RequestParam String description, @RequestParam String requirements) {
        try {
            Offer updatedOffer = offerService.updateOffer(id, status, tittleOffer, description, requirements);
            return ResponseEntity.ok(updatedOffer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * @name updateOffer
     * @description Updates an existing Offer.
     *
     * @param id the ID of the Offer to update.
     * @param status the details of the deleted Offer.
     * @return The updated Offer.
     */
    @CrossOrigin
    @PutMapping("/deleteOffer/{id}")
    public Offer deleteOffer(@PathVariable Long id, @RequestBody String status){
        Optional<Offer> optionalOffer = offerService.getById(id);

        Offer offer = optionalOffer.get();

        offer.setStatus(status);

        return offerService.update(offer);

    }
    
}
