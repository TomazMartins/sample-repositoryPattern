package br.com.algorithmworks.samplerequery.app;

import android.app.Application;
import android.os.StrictMode;

import br.com.algorithmworks.samplerequery.model.Models;
import io.requery.Persistable;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.meta.EntityModel;
import io.requery.sql.Configuration;
import io.requery.sql.EntityDataStore;


public class SampleApplication extends Application {
    private EntityDataStore<Persistable> dataStore;

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
        if( dataStore == null ) {
            /*
            * Create the connection with the database.
            *
            *   As parameters: a 'context', a 'EntityModel' and a number,
            *   indicate the version of the database.
            * */
            DatabaseSource source = new DatabaseSource( this, models, 1 );

            Configuration configuration = source.getConfiguration();

            dataStore = new EntityDataStore<Persistable>( configuration );
        }

        return dataStore;
    }
}
