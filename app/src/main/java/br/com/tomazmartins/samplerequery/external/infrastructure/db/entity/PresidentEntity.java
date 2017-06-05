package br.com.tomazmartins.samplerequery.external.infrastructure.db.entity;


import io.requery.CascadeAction;
import io.requery.Entity;
import io.requery.ForeignKey;
import io.requery.Generated;
import io.requery.Key;
import io.requery.OneToOne;
import io.requery.Persistable;
import io.requery.Table;

@Entity( name = "PresidentEntityImpl" )
@Table( name = "PresidentEntity" )
public interface PresidentEntity extends Persistable {
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

    /*
    * ONE-TO-ONE:
    *   The relationship between PRESIDENT and COUNTRY
    *   is one-to-one, because a COUNTRY must has only
    *   one PRESIDENT
    *   and
    *   a PRESIDENT is the PRESIDENT
    *   of only one COUNTRY.
    * */
    @OneToOne( cascade = CascadeAction.NONE )
    CountryEntity getCountry();

    String getName();

    void setCountry( CountryEntity country );
    void setName( String name );
    void setId( int id );
}
