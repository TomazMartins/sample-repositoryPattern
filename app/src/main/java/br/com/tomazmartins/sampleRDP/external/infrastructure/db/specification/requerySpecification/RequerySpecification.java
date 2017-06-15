package br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.requerySpecification;

import br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.Specification;
import io.requery.Persistable;
import io.requery.query.Result;
import io.requery.sql.EntityDataStore;

/*
* REQUERY SPECIFICATION:
*   It's guarantee that all specification linked
*   with the Requery will implement a method that
*   handled with the database with the Requery's way.
* */
public interface RequerySpecification<T> extends Specification {
    Result<T> toRequeryResult( EntityDataStore<Persistable> dataStore );
}
