package br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.requeryMapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.tomazmartins.samplerequery.core.models.President;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.PresidentEntity;

@Mapper( uses = EntityFactory.class )
public interface PresidentEntityMapper {
    PresidentEntityMapper INSTANCE = Mappers.getMapper( PresidentEntityMapper.class );

    @BeanMapping( resultType = PresidentEntity.class )
    @Mapping( target = "country", ignore = true)
    PresidentEntity mapFrom( President fromObject );
}
