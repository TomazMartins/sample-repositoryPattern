package br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.requeryMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.tomazmartins.samplerequery.core.models.President;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.PresidentEntity;

@Mapper( uses = CountryMapper.class )
public interface PresidentMapper {
    PresidentMapper INSTANCE = Mappers.getMapper( PresidentMapper.class );

    @Mapping( target = "country", ignore = true )
    President mapFrom( PresidentEntity entity );
}
