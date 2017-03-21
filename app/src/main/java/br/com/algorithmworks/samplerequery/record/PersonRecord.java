package br.com.algorithmworks.samplerequery.record;

import android.util.Log;

import java.util.List;

import br.com.algorithmworks.samplerequery.model.Person;
import io.requery.Persistable;
import io.requery.sql.EntityDataStore;


public class PersonRecord {
    private EntityDataStore<Persistable> dataStore;

    public PersonRecord( EntityDataStore<Persistable> data ) {
        this.dataStore = data;
    }

    public void save( final Person person ) {
        dataStore.insert( person );

        Log.i( "PersonRecord", person.toString() +
                " saved with success"
        );
    }

    public void delete( final int id ) {
        Person person = this.getById( id );
        dataStore.delete( person );

        Log.i( "PersonRecord", person.toString() +
                " deleted with success"
        );
    }

    public void delete( final Person person ) {
        dataStore.delete( person );

        Log.i( "PersonRecord", person.toString() +
                " deleted with success"
        );
    }

    public Person getById( final int id ) {
        return dataStore.select( Person.class )
                .where( Person.ID.eq( id )
                ).get()
                .first();
    }

    public List<Person> getAll() {
        return dataStore.select( Person.class )
                .get()
                .toList();
    }

    public EntityDataStore<Persistable> getDataStore() {
        return this.dataStore;
    }
}
