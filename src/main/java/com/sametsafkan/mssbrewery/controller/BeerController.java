package com.sametsafkan.mssbrewery.controller;

import com.sametsafkan.mssbrewery.dto.BeerDto;
import com.sametsafkan.mssbrewery.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @RequestMapping("/{beerId}")
    public ResponseEntity<BeerDto> findById(@PathVariable("beerId") String beerId){
        return new ResponseEntity<>(beerService.findById(beerId), OK);
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody BeerDto beerDto){
        BeerDto saved = beerService.save(beerDto);
        HttpHeaders headers = new HttpHeaders();
        //TODO: add hostname to url
        headers.add("Location", "/mss/v1/beer" + saved.getId().toString());
        return new ResponseEntity(headers, CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity update(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto){
        beerService.update(beerId, beerDto);
        return new ResponseEntity(NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public void delete(@PathVariable("beerId") UUID beerId){
        beerService.delete(beerId);
    }
}
