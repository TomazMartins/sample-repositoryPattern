package br.com.tomazmartins.samplerequery.external.infrastructure.db.entity;


import io.requery.CascadeAction;
import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import io.requery.OneToOne;
import io.requery.Persistable;
import io.requery.Table;

@Entity( name = "PresidentEntityImpl" )
@Table( name = "PresidentEntity" )
public interface PresidentEntity extends Persistable {
    @Key
    @Generated
    int getId();

    @OneToOne( cascade = CascadeAction.NONE )
    CountryEntity getCountry();

    String getName();
}
