package com.sametsafkan.mssbrewery.controller;

import com.sametsafkan.mssbrewery.dto.BeerDto;
import com.sametsafkan.mssbrewery.service.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mss/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @RequestMapping("/{beerId}")
    public ResponseEntity<BeerDto> findById(@PathVariable("beerId") String beerId){
        return new ResponseEntity<>(beerService.findById(beerId), HttpStatus.OK);
    }
}
