package com.sametsafkan.mssbrewery.service;

import com.sametsafkan.mssbrewery.dto.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto findById(String beerId) {
        return new BeerDto().builder()
                .id(UUID.randomUUID())
                .name("Samet Ale")
                .style("Dark Ale").build();
    }

    @Override
    public BeerDto save(BeerDto beerDto) {
        return new BeerDto().builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void update(UUID beerId, BeerDto beerDto) {
        //TODO: Impl later
    }

    @Override
    public void delete(UUID beerId) {
        //TODO: Implement later
    }
}