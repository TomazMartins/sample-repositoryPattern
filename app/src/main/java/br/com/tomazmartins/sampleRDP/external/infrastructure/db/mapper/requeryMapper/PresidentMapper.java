package br.com.tomazmartins.sampleRDP.external.infrastructure.db.mapper.requeryMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.tomazmartins.sampleRDP.core.models.President;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.entity.PresidentEntity;

/*
* MAPPER:
*   This annotation declares to the MapStruct
*   that this interface is a Mapper.
*
*   The attribute USES is used to declare some
*   classes that this Mapper will must to use.
*
*   With would be more than one class, we need
*   to use a list of '.class', between the
*   symbols '{}', like that:
*
*   uses = {SomeClass.class, AnotherClass.class}
* */
@Mapper( uses = CountryMapper.class )
public interface PresidentMapper {
    /*
    * Its necessary declare this constant to receive the
    *   mapper created by the Mappers factory.
    *
    *   For convention, the is INSTANCE
    * */
    PresidentMapper INSTANCE = Mappers.getMapper( PresidentMapper.class );

    /*
    * MAPPING:
    *   With this annotation we declare some attribute to the
    *   MapStruct, to instruction it with some specification.
    *
    *   I this case, we declare to the MapStruct to ignore the
    *   attribute calls 'country'.
    *
    *   This method will be implemented by MapStruct in the
    *   generated concrete class.
    * */
    @Mapping( target = "country", ignore = true )
    President mapFrom( PresidentEntity entity );
}
