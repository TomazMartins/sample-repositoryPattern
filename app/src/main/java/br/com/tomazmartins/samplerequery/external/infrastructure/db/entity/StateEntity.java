package br.com.tomazmartins.samplerequery.external.infrastructure.db.entity;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import io.requery.ManyToOne;
import io.requery.Persistable;
import io.requery.Table;

@Table( name = "State" )
@Entity( name = "StateEntityImpl" )
public interface StateEntity extends Persistable {
    /*
    * KEY:
    *   The attribute ID is the Primary Key.
    *
    * GENERATED:
    *   The attribute ID is auto incremented.
    * */
    @Key
    @Generated
    int getId();

    @ManyToOne
    CountryEntity getCountry();

    String getName();

    void setCountry( CountryEntity country );
    void setName( String name );
    void setId( int id );
}
