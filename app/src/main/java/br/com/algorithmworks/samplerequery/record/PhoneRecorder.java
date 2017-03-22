package br.com.algorithmworks.samplerequery.record;


import java.util.List;

import br.com.algorithmworks.samplerequery.model.Phone;
import io.requery.Persistable;
import io.requery.sql.EntityDataStore;

public class PhoneRecorder extends BaseRecorder {
    public PhoneRecorder( EntityDataStore<Persistable> data ) {
        super( data );
    }

    @Override
    public void save( final Object object ) {
        if( object instanceof Phone ) {
            getDataStore().insert( (Phone) object );
        }
    }

    @Override
    public void update( final Object object ) {
        if( object instanceof Phone ) {
            getDataStore().update( (Phone) object );
        }
    }

    @Override
    public void delete( final Object object ) {
        if( object instanceof Phone ) {
            getDataStore().insert( (Phone) object );
        }
    }

    @Override
    public Object getById( final int id ) {
        return getDataStore()
                .select( Phone.class )
                .where( Phone.ID.eq( id ) )
                .get()
                .first();
    }

    @Override
    public List<?> getAll() {
        return getDataStore()
                .select( Phone.class )
                .get()
                .toList();
    }
}
