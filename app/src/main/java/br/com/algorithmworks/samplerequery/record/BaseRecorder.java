package br.com.algorithmworks.samplerequery.record;


import android.util.Log;

import io.requery.Persistable;
import io.requery.sql.EntityDataStore;


/*
* This class is only a example how we can generalize a Recorder.
*
*   It's not necessarily the best way to do it.
*   It's an experience.
* */
public abstract class BaseRecorder {
    private EntityDataStore<Persistable> dataStore;

    public BaseRecorder( final EntityDataStore<Persistable> data ) {
        this.dataStore = data;
        Log.i( "BASE", this.getClass().getName() );
    }

    public void save( final Object object ) throws ClassNotFoundException {
        String className = object.getClass().getName();

        Class<?> objectClass = Class.forName( className );

        Persistable objectToInsert = (Persistable) objectClass.cast( object );

        this.dataStore.insert( objectToInsert );

        Log.i( this.getClass().getSimpleName(), object.toString() + " was saved" );
    }

    public void delete( final Object object ) throws ClassNotFoundException {
        String className = object.getClass().getName();

        Class<?> objectClass = Class.forName( className );

        Persistable objectToInsert = (Persistable) objectClass.cast( object );

        this.dataStore.delete( objectToInsert );

        Log.i( this.getClass().getSimpleName(), object.toString() + " was deleted" );
    }

    protected EntityDataStore<Persistable> getDataStore() {
        return this.dataStore;
    }
}
