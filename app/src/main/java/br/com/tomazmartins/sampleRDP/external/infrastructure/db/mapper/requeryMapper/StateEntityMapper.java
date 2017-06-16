package br.com.tomazmartins.sampleRDP.external.infrastructure.db.mapper.requeryMapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.tomazmartins.sampleRDP.core.models.State;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.entity.StateEntity;

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
@Mapper( uses = EntityFactory.class )
public interface StateEntityMapper {
    /*
    * It's necessary declare this constant to receive the
    *   mapper created by the Mappers factory.
    *
    *   For convention, the is INSTANCE
    * */
    StateEntityMapper INSTANCE = Mappers.getMapper( StateEntityMapper.class );

    /*
    * BEAM MAPPING:
    *   This annotation allow us to determine the result type.
    *   Normally, it's used when we use inheritance relations.
    *   We use this because there is an inheritance
    *   relation between the abstract classes and concrete classes
    *   of the Requery.
    *
    *   In this case, we have the abstract class STATE ENTITY,
    *   that generated by Requery the concrete class
    *   STATE ENTITY IMPL.
    *   So, we use annotation BEAM MAPPING and declare that the
    *   result must be STATE ENTITY.
    *   And
    *   With the ENTITY FACTORY.createPresidentEntity(), we
    *   instantiate the concrete class, not the abstract class.
    *
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
    @BeanMapping( resultType = StateEntity.class )
    @Mapping( target = "country", ignore = true )
    StateEntity mapFrom( State fromObject );
}
