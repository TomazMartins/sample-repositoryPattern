package br.com.tomazmartins.sampleRDP.external.infrastructure.db.repository.requeryRepository;

import br.com.tomazmartins.sampleRDP.external.infrastructure.db.repository.Repository;
import io.requery.Persistable;
import io.requery.sql.EntityDataStore;

/*
* REQUERY REPOSITORY:
*   This abstract class represent the repositories that use
*   the Requery.
*
*   All repositories that use Requery must extend this abstract class.
*
*
*   It's the magic behind of the RDP (Repository Design Pattern).
*   When use the RDP we don't need to worry if we must change the
*   technology behind the database.
*
*   With the interface REPOSITORY we guarantee that all repositories will
*   be used of the same way. So, when we USE it, we don't worry with the
*   implementation of it.
*
*   In other hand, when we need CHANGE the technology of the database,
*   like when we change from SQLITE to REQUERY, for example. We need only create
*   a small new set of the classes, that implements the interface REPOSITORY.
 *
 *  The logic of the how the repository will operate in database is encapsulated
 *  inside the repositories. The business layer don't change,
 *  only the repository layer.
* */
public abstract class RequeryRepository<T> implements Repository<T> {
    /*
    * This attribute is the key of the Requery.
    *   With this we have access of the Requery's operations.
    * */
    private final EntityDataStore<Persistable> mDataStore;

    /*
    * With this constructor we guarantee that all repositories
    *   that use Requery will have a ENTITY DATA STORE injected.
    * */
    public RequeryRepository( EntityDataStore<Persistable> dataStore ) {
        this.mDataStore = dataStore;
    }

    /*
    * With this method we allow the children classes access to the
    *   ENTITY DATA STORE
    *   and them,
    *   They can make operation in database.
    * */
    protected EntityDataStore<Persistable> getDataStore() {
        return mDataStore;
    }
}
