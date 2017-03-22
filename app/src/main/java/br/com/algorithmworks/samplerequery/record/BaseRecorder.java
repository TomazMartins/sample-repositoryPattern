package br.com.algorithmworks.samplerequery.record;


import io.requery.Persistable;
import io.requery.sql.EntityDataStore;


abstract class BaseRecorder implements Recorder {
    private EntityDataStore<Persistable> dataStore;

    BaseRecorder( final EntityDataStore<Persistable> data ) {
        this.dataStore = data;
    }

    protected EntityDataStore<Persistable> getDataStore() {
        return this.dataStore;
    }
}
