package br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.requeryMapper;

import br.com.tomazmartins.samplerequery.core.models.Country;
import br.com.tomazmartins.samplerequery.core.models.President;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.PresidentEntity;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.Mapper;


public class PresidentMapper implements Mapper<PresidentEntity, President> {
    @Override
    public President mapFrom( PresidentEntity fromObject ) {
        President president;

        if( fromObject != null ) {
            president = new President();

            president.setName( fromObject.getName() );
            president.setId( fromObject.getId() );

            Country country = new CountryMapper().mapFrom( fromObject.getCountry() );

            president.setCountry( country );
        } else {
            president = null;
        }

        return president;
    }
}
