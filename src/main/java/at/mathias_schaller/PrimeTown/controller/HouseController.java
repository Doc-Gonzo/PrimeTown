package at.mathias_schaller.PrimeTown.controller;


import at.mathias_schaller.PrimeTown.exception.ResourceNotFoundException;
import at.mathias_schaller.PrimeTown.model.House;
import at.mathias_schaller.PrimeTown.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    @GetMapping("/houses")
    public Page<House> getAllHouses(Pageable pageable) {
        return houseRepository.findAll(pageable);
    }

    @PostMapping("/houses")
    public House createHouse(@Valid @RequestBody House house) {

        return houseRepository.save(house);
    }

    @PutMapping("/houses/{houseId}")
    public House updateHouse(@PathVariable Long houseId, @Valid @RequestBody House postRequest) {
        return houseRepository.findById(houseId).map(house -> {
            house.setOwner(postRequest.getOwner());
            house.setYearOfConstruction(postRequest.getYearOfConstruction());
            return houseRepository.save(house);
        }).orElseThrow(() -> new ResourceNotFoundException("HouseID " + houseId + " not found"));
    }


    @DeleteMapping("/houses/{houseId}")
    public ResponseEntity<?> deleteHouse(@PathVariable Long houseId) {
        return houseRepository.findById(houseId).map(house -> {
            houseRepository.delete(house);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + houseId + " not found"));
    }

}