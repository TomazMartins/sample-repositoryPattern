package br.com.algorithmworks.samplerequery.record;

import java.util.List;

import br.com.algorithmworks.samplerequery.model.Person;
import io.requery.Persistable;
import io.requery.sql.EntityDataStore;


public class PersonRecorder extends BaseRecorder {
    public PersonRecorder( EntityDataStore<Persistable> data ) {
        super( data );
    }

    @Override
    public void save( final Object object ) {
        if( object instanceof Person ) {
            getDataStore().insert( (Person) object );
        }
    }

    @Override
    public void update( final Object object ) {
        if( object instanceof Person ) {
            getDataStore().update( (Person) object );
        }
    }

    @Override
    public void delete( final Object object ) {
        if( object instanceof Person ) {
            getDataStore().delete( (Person) object );
        }
    }

    @Override
    public Person getById( final int id ) {
        return getDataStore()
                .select( Person.class )
                .where( Person.ID.eq( id )
                ).get()
                .first();
    }

    @Override
    public List<Person> getAll() {
        return getDataStore()
                .select( Person.class )
                .get()
                .toList();
    }
}
