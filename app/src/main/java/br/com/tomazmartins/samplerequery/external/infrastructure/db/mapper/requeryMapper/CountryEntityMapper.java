package br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.requeryMapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.tomazmartins.samplerequery.core.models.Country;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.CountryEntity;

@Mapper( uses = EntityFactory.class )
public abstract class CountryEntityMapper {
    public static CountryEntityMapper INSTANCE = Mappers.getMapper( CountryEntityMapper.class );

    public CountryEntity mapFrom( Country fromObject ) {
        CountryEntity entity = toEntity( fromObject );
        return entity;
    }

    @BeanMapping( resultType = CountryEntity.class )
    @Mapping( target = "president", ignore = true )
    abstract CountryEntity toEntity( Country model );
}
