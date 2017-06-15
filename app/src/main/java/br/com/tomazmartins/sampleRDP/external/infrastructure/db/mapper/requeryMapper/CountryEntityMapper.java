package br.com.tomazmartins.sampleRDP.external.infrastructure.db.mapper.requeryMapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.tomazmartins.sampleRDP.core.models.Country;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.entity.CountryEntity;

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
@Mapper( uses = {EntityFactory.class, PresidentEntityMapper.class, StateEntityMapper.class} )
public abstract class CountryEntityMapper {
    /*
    * It's necessary declare this constant to receive the
    *   mapper created by the Mappers factory.
    *
    *   For convention, the is INSTANCE
    * */
    public static CountryEntityMapper INSTANCE = Mappers.getMapper( CountryEntityMapper.class );

    /*
    * This method is used to calls the method that map the object.
    *   and them,
    *   make some configurations.
    *
    *   The motivation to use an abstract class in here is
    *   exactly it: we can implement manually this method.
    * */
    public CountryEntity mapFrom( Country fromObject ) {
        CountryEntity entity = toEntity( fromObject );
        entity.getPresident().setCountry( entity );

        return entity;
    }

    /*
    * BEAM MAPPING:
    *   This annotation allow us to determine the result type.
    *   Normally, it's used when we use inheritance relations.
    *   We use this because there is an inheritance
    *   relation between the abstract classes and concrete classes
    *   of the Requery.
    *
    *   In this case, we have the abstract class COUNTRY ENTITY,
    *   that generated by Requery the concrete class
    *   COUNTRY ENTITY IMPL.
    *   So, we use annotation BEAM MAPPING and declare that the
    *   result must be COUNTRY ENTITY.
    *   And
    *   With the ENTITY FACTORY.createPresidentEntity(), we
    *   instantiate the concrete class, not the abstract class.
    * */
    @BeanMapping( resultType = CountryEntity.class )
    abstract CountryEntity toEntity( Country model );
}
