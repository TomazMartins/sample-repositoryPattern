package br.com.tomazmartins.samplerequery.external.infrastructure.db.specification.requerySpecification;


import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.CountryEntity;
import io.requery.Persistable;
import io.requery.query.Result;
import io.requery.sql.EntityDataStore;

public class ListAllCountriesSpec implements RequerySpecification<CountryEntity> {
    @Override
    public Result<CountryEntity> toRequeryResult( EntityDataStore<Persistable> dataStore ) {
        return dataStore
                .select( CountryEntity.class )
                .get();
    }
}
