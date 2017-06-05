package br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.requeryMapper;

import br.com.tomazmartins.samplerequery.core.models.Country;
import br.com.tomazmartins.samplerequery.core.models.President;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.CountryEntity;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.Mapper;


public class CountryMapper implements Mapper<CountryEntity, Country> {
    @Override
    public Country mapFrom( CountryEntity fromObject ) {
        Country country = new Country();

        country.setPopulation( fromObject.getPopulation() );
        country.setName( fromObject.getName() );
        country.setId( fromObject.getId() );

        President president = new PresidentMapper().mapFrom( fromObject.getPresident() );

        country.setPresident( president );

        return country;
    }
}
