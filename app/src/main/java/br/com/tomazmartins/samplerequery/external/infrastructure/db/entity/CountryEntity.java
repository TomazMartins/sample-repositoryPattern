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
public abstract class CountryEntity implements Persistable {
    /*
    * KEY:
    *   The attribute ID is the Primary Key.
    *
    * GENERATED:
    *   The attribute ID is auto incremented.
    * */
    @Key
    @Generated
    protected int id;

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
    protected PresidentEntity president;

    protected int population;
    protected String name;

    public PresidentEntity getPresident() {
        return this.president;
    }

    public int getPopulation() {
        return this.population;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setPresident( PresidentEntity president ) {
        this.president = president;
    }

    public void setPopulation( int population ) {
        this.population = population;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setId( int id ) {
        this.id = id;
    }
}
