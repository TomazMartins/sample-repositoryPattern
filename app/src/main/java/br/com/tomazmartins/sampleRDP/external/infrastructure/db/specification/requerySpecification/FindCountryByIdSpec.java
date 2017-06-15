package br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.requerySpecification;

import br.com.tomazmartins.sampleRDP.external.infrastructure.db.entity.CountryEntity;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.entity.CountryEntityImpl;
import io.requery.Persistable;
import io.requery.query.Result;
import io.requery.sql.EntityDataStore;


public class FindCountryByIdSpec implements RequerySpecification<CountryEntity> {
    private int mId;

    public FindCountryByIdSpec( int id ) {
        this.mId = id;
    }
    @Override
    public Result<CountryEntity> toRequeryResult( EntityDataStore<Persistable> dataStore ) {
        return dataStore.select( CountryEntity.class )
                .where( CountryEntityImpl.ID.equal( mId ) )
                .get();
    }
}
