package br.com.tomazmartins.samplerequery.external.infrastructure.db.repository.requeryRepository;

import br.com.tomazmartins.samplerequery.external.infrastructure.db.repository.Repository;
import io.requery.Persistable;
import io.requery.sql.EntityDataStore;


public abstract class RequeryRepository<T> implements Repository<T> {
    private final EntityDataStore<Persistable> mDataStore;

    public RequeryRepository( EntityDataStore<Persistable> dataStore ) {
        this.mDataStore = dataStore;
    }

    protected EntityDataStore<Persistable> getDataStore() {
        return mDataStore;
    }
}
