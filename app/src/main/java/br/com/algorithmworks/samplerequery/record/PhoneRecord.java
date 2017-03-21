package br.com.algorithmworks.samplerequery.record;


import android.util.Log;

import java.util.List;

import br.com.algorithmworks.samplerequery.model.Phone;
import io.requery.Persistable;
import io.requery.sql.EntityDataStore;

public class PhoneRecord {
    private EntityDataStore<Persistable> dataStore;

    public PhoneRecord( EntityDataStore<Persistable> data ) {
        this.dataStore = data;
    }

    public void save( final Phone phone ) {
        dataStore.insert( phone );

        Log.i( "PhoneRecord", phone.toString() +
                "saved with success"
        );
    }

    public void delete( final int id ) {
        Phone phone = this.getById( id );
        dataStore.delete( phone );

        Log.i( "PhoneRecord", phone.toString() +
                "deleted with success"
        );
    }

    public void delete( final Phone phone ) {
        dataStore.delete( phone );

        Log.i( "PhoneRecord", phone.toString() +
                "deleted with success"
        );
    }

    public Phone getById( final int id ) {
        return dataStore.select( Phone.class )
                .where( Phone.ID.eq( id )
                ).get()
                .first();
    }

    public List<Phone> getAll() {
        return dataStore.select( Phone.class )
                .get()
                .toList();
    }

    public EntityDataStore<Persistable> getDataStore() {
        return this.dataStore;
    }
}
