package com.sametsafkan.mssbrewery.mapper;

import com.sametsafkan.mssbrewery.domain.Beer;
import com.sametsafkan.mssbrewery.dto.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beer);
}
