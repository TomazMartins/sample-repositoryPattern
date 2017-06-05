package br.com.tomazmartins.samplerequery.external.infrastructure.db.entity;


import io.requery.CascadeAction;
import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import io.requery.OneToOne;
import io.requery.Persistable;
import io.requery.Table;

@Entity( name = "CountryEntityImpl" )
@Table( name = "Country" )
public interface CountryEntity extends Persistable {
    @Key
    @Generated
    int getId();

    @OneToOne( cascade = CascadeAction.NONE )
    PresidentEntity getPresident();

    int getPopulation();
    String getName();
}
