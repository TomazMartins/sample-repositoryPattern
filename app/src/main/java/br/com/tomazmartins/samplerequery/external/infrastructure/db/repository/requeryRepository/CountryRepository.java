package br.com.tomazmartins.samplerequery.external.infrastructure.db.repository.requeryRepository;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.tomazmartins.samplerequery.core.models.Country;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.CountryEntity;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.CountryEntityImpl;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.Mapper;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.requeryMapper.CountryEntityMapper;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.requeryMapper.CountryMapper;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.specification.Specification;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.specification.requerySpecification.RequerySpecification;
import io.requery.Persistable;
import io.requery.query.Result;
import io.requery.sql.EntityDataStore;

public class CountryRepository extends RequeryRepository<Country> {
    private Mapper<Country, CountryEntity> toEntity = new CountryEntityMapper();
    private Mapper<CountryEntity, Country> toCountry = new CountryMapper();

    public CountryRepository( EntityDataStore<Persistable> dataStore ) {
        super( dataStore );
    }

    @Override
    public void save( final Iterable<Country> items ) {
        for( Country item : items ) {
            CountryEntity entity = toEntity.mapFrom( item );

            getDataStore().insert( entity );
        }
    }

    @Override
    public Country save( final Country item ) {
        CountryEntity entity = toEntity.mapFrom( item );
        CountryEntity entityInserted = getDataStore().insert( entity );

        return toCountry.mapFrom( entityInserted );
    }

    @Override
    public Country delete( final Country item ) {
        CountryEntity entity = toEntity.mapFrom( item );

        getDataStore().delete( entity );

        return item;
    }

    @Override
    public Country update( final Country item ) {
        CountryEntity entity = toEntity.mapFrom( item );
        CountryEntity entityUpdated = getDataStore().update( entity );

        return toCountry.mapFrom( entityUpdated );
    }

    @Override
    public int count() {
        return getDataStore()
                .count( CountryEntity.class )
                .get()
                .value();
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List<Country> query( final Specification specification ) {
        final RequerySpecification<CountryEntity> requerySpecification;
        requerySpecification = (RequerySpecification) specification;

        final Result<CountryEntity> result = requerySpecification.toRequeryResult( getDataStore() );

        final List<Country> countryList = new ArrayList<>();

        for( CountryEntity entity : result ) {
            Country country = toCountry.mapFrom( entity );
            countryList.add( country );
        }

        return countryList;
    }

    @Override
    public Country first() {
        CountryEntity entity = getDataStore()
                .select( CountryEntity.class )
                .get()
                .first();

        return toCountry.mapFrom( entity );
    }

    @Override
    public Country last() {
        CountryEntity entity = getDataStore()
                .select( CountryEntity.class )
                .orderBy( CountryEntityImpl.ID.desc() )
                .get()
                .first();

        return toCountry.mapFrom( entity );
    }
}
