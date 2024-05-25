package com.talentsoft.recruitmentmoduleback.controller;

import com.talentsoft.recruitmentmoduleback.DTO.request.OfferUpdateRequest;
import com.talentsoft.recruitmentmoduleback.DTO.request.OfferUpdateStatusRequest;
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

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    /**
     * @name getAllOffers
     * @description Retrieves all existing Offers.
     *
     * @return An iterable list of Offers.
     */

    @GetMapping("/getOffers/{id}")
    public ResponseEntity<?> getAllOffers(@PathVariable Long id) {
        return ResponseEntity.ok(offerService.getAllByCompany(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllOffers() {
        return ResponseEntity.ok(offerService.getAll());
    }

    /**
     * @name getOfferById
     * @description Retrieves a Offer by their ID.
     * @param id the ID of the Offer.
     * @return An optional containing the Offer with the specified ID, if exists.
     */

    @GetMapping("/{id}")
    public Optional<Offer> getOfferById(@PathVariable Long id) {
        return offerService.getById(id);
    }

    /**
     * @name createOffer
     * @description Creates a new Offer.
     *
     * @param Offer the details of the Offer to create.
     * @return The newly created Offer.
     */

    @PostMapping("/createOffer")
    public Offer createOffer(@RequestBody Offer Offer) {
        return offerService.create(Offer);
    }


    @PutMapping("/updateOffer/{id}")
    public ResponseEntity<?> updateOffer(@PathVariable Long id, @RequestBody OfferUpdateRequest offerUpdateRequest) {
        try {
            Offer updatedOffer = offerService.updateOffer(id, offerUpdateRequest);
            return ResponseEntity.ok(updatedOffer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<?> updateOfferStatus(@PathVariable Long id, @RequestBody OfferUpdateStatusRequest status) {
        try {
            Offer updatedOffer = offerService.updateOfferStatus(id, status);
            return ResponseEntity.status(HttpStatus.OK).body(updatedOffer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteOffer/{id}")
    public Offer deleteOffer(@PathVariable Long id, @RequestBody String status){
        Optional<Offer> optionalOffer = offerService.getById(id);

        Offer offer = optionalOffer.get();
        offer.setStatus(status);
        return offerService.update(offer);
    }
    
}
