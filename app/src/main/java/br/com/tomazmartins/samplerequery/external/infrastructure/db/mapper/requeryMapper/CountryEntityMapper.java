package br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.requeryMapper;

import br.com.tomazmartins.samplerequery.core.models.Country;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.CountryEntity;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.CountryEntityImpl;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.PresidentEntity;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.Mapper;


public class CountryEntityMapper implements Mapper<Country, CountryEntity> {
    @Override
    public CountryEntity mapFrom( Country fromObject ) {
        CountryEntity entity;

        if( fromObject != null ) {
            entity = new CountryEntityImpl();

            entity.setPopulation( fromObject.getPopulation() );
            entity.setName( fromObject.getName() );
            entity.setId( fromObject.getId() );

            PresidentEntity presidentEntity = new PresidentEntityMapper()
                    .mapFrom( fromObject.getPresident() );

            entity.setPresident( presidentEntity );
        } else {
            entity = null;
        }

        return entity;
    }
}
