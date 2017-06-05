package br.com.tomazmartins.samplerequery.external.infrastructure.db.entity;


import io.requery.CascadeAction;
import io.requery.Entity;
import io.requery.ForeignKey;
import io.requery.Generated;
import io.requery.Key;
import io.requery.OneToOne;
import io.requery.Persistable;
import io.requery.Table;

@Entity( name = "CountryEntityImpl" )
@Table( name = "Country" )
public interface CountryEntity extends Persistable {
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
    *
    * FOREIGN KEY:
    *   The Foreign Key was put in here, because
    *   the entity (Table) COUNTRY 'need' a
    *   PRESIDENT.
    *
    *   The dependence is between COUNTRY -> PRESIDENT,
    *   not PRESIDENT -> COUNTRY.
    *
    *   So, The Foreign Key is put in the dependent
    *   table. In this case, the 'COUNTRY'.
    * */
    @OneToOne( cascade = CascadeAction.NONE )
    @ForeignKey
    PresidentEntity getPresident();

    int getPopulation();
    String getName();

    void setPopulation( int population );
    void setName( String name );
    void setId( int id );
    void setPresident( PresidentEntity president );
}
