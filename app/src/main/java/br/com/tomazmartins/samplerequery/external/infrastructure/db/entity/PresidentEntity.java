package br.com.tomazmartins.samplerequery.external.infrastructure.db.entity;


import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import io.requery.OneToOne;
import io.requery.Persistable;
import io.requery.Table;

@Entity( name = "PresidentEntityImpl" )
@Table( name = "President" )
public abstract class PresidentEntity implements Persistable {
    /*
    * KEY:
    *   The attribute ID is the Primary Key.
    *
    * GENERATED:
    *   The attribute ID is auto incremented.
    * */
    @Key
    @Generated
    int id;

    /*
    * ONE-TO-ONE:
    *   The relationship between PRESIDENT and COUNTRY
    *   is one-to-one, because a COUNTRY must has only
    *   one PRESIDENT
    *   and
    *   a PRESIDENT is the PRESIDENT
    *   of only one COUNTRY.
    * */
    @OneToOne( mappedBy = "president" )
    CountryEntity country;

    String name;

    abstract CountryEntity getCountry();
    abstract String getName();
    abstract int getId();

    public void setCountry( CountryEntity country ) {
        this.country = country;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setId( int id ) {
        this.id = id;
    }
}
