package br.com.tomazmartins.sampleRDP.external.infrastructure.db.mapper.requeryMapper;

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
@Mapper( uses = {PresidentMapper.class} )
public abstract class CountryMapper {
    /*
    * It's necessary declare this constant to receive the
    *   mapper created by the Mappers factory.
    *
    *   For convention, the is INSTANCE
    * */
    public static CountryMapper INSTANCE = Mappers.getMapper( CountryMapper.class );

    /*
    * This method is used to calls the method that map the object.
    *   and them,
    *   make some configurations.
    *
    *   The motivation to use an abstract class in here is
    *   exactly it: we can implement manually this method.
    * */
    public Country mapFrom( CountryEntity fromObject ) {
        Country country = CountryMapper.INSTANCE.toCountry( fromObject );
        country.getPresident().setCountry( country );

        return country;
    }

    /*
    * This abstract method is used by MapStruct to map
    *   the target.
    * */
    abstract Country toCountry( CountryEntity entity );
}
