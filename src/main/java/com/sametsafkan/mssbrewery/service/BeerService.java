package com.sametsafkan.mssbrewery.service;

import com.sametsafkan.mssbrewery.dto.BeerDto;

public interface BeerService {
    BeerDto findById(String beerId);
}
