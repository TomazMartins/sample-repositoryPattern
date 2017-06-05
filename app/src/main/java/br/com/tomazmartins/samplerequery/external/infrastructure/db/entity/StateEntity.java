package br.com.tomazmartins.samplerequery.external.infrastructure.db.entity;


import io.requery.Entity;
import io.requery.Persistable;
import io.requery.Table;

@Entity( name = "StateEntityImpl" )
@Table( name = "State" )
public interface StateEntity extends Persistable {
}
