package br.com.tomazmartins.sampleRDP.external.modules.application;

import android.app.Application;
import android.os.StrictMode;

import br.com.tomazmartins.sampleRDP.external.infrastructure.db.entity.Models;
import io.requery.Persistable;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.meta.EntityModel;
import io.requery.sql.Configuration;
import io.requery.sql.EntityDataStore;


public class SampleApplication extends Application {
    private static final int DB_VERSION = 1;
    private EntityDataStore<Persistable> mDataStore;
    private DatabaseSource mSource;

    @Override
    public void onCreate() {
        super.onCreate();

        StrictMode.enableDefaults();
    }

    /**
     * Return a single instance of the EntityDataStore
     *   of the application.
     *
     * @return the EntityDataStore responsible to connection with database.
     */
    public EntityDataStore<Persistable> getDataStore() {
        /*
        * The class 'Models' is generated when the at least one
        *   table is created.
        * */
        EntityModel models = Models.DEFAULT;


        // Guarantee that there is only one connection with the database.
        if( mDataStore == null ) {
            /*
            * Create the connection with the database.
            *
            *   As parameters: a 'context', a 'EntityModel' and a number,
            *   indicate the version of the database.
            * */
            mSource = new DatabaseSource( this, models, DB_VERSION );
            mSource.setLoggingEnabled( true );

            Configuration configuration = mSource.getConfiguration();

            mDataStore = new EntityDataStore<>( configuration );
        }

        return mDataStore;
    }

    public void closeDataStore() {
        mDataStore.close();
        mSource.close();
    }
}
