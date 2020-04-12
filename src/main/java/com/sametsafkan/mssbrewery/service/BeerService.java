package com.sametsafkan.mssbrewery.service;

import com.sametsafkan.mssbrewery.dto.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto findById(String beerId);

    BeerDto save(BeerDto beerDto);

    void update(UUID beerId, BeerDto beerDto);

    void delete(UUID beerId);
}
