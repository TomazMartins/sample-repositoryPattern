package br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.requerySpecification;

import br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.Specification;
import io.requery.Persistable;
import io.requery.query.Result;
import io.requery.sql.EntityDataStore;


public interface RequerySpecification<T> extends Specification {
    Result<T> toRequeryResult( EntityDataStore<Persistable> dataStore );
}
