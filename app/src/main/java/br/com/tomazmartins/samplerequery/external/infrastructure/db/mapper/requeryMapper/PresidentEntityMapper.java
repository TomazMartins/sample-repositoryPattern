package br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.requeryMapper;

import br.com.tomazmartins.samplerequery.core.models.President;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.CountryEntity;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.PresidentEntity;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.PresidentEntityImpl;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.Mapper;


public class PresidentEntityMapper implements Mapper<President, PresidentEntity> {
    @Override
    public PresidentEntity mapFrom( President fromObject ) {
        PresidentEntity entity = new PresidentEntityImpl();

        entity.setName( fromObject.getName() );
        entity.setId( fromObject.getId() );

        CountryEntity countryEntity = new CountryEntityMapper().mapFrom( fromObject.getCountry() );

        entity.setCountry( countryEntity );

        return entity;
    }
}
