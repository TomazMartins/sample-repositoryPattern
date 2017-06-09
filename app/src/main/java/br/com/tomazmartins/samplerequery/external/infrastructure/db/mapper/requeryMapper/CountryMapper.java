package br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.requeryMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.tomazmartins.samplerequery.core.models.Country;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.CountryEntity;

@Mapper( uses = {PresidentMapper.class} )
public abstract class CountryMapper {
    public static CountryMapper INSTANCE = Mappers.getMapper( CountryMapper.class );

    public Country mapFrom( CountryEntity fromObject ) {
        Country country = CountryMapper.INSTANCE.toCountry( fromObject );
        return country;
    }

    @Mapping( source = "states", target = "states", ignore = true )
    abstract Country toCountry( CountryEntity entity );
}
