package br.com.tomazmartins.sampleRDP.external.infrastructure.db.repository.requeryRepository;


import java.util.ArrayList;
import java.util.List;

import br.com.tomazmartins.sampleRDP.core.models.President;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.entity.PresidentEntity;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.entity.PresidentEntityImpl;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.mapper.requeryMapper.PresidentEntityMapper;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.mapper.requeryMapper.PresidentMapper;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.Specification;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.requerySpecification.RequerySpecification;
import io.requery.Persistable;
import io.requery.query.Result;
import io.requery.sql.EntityDataStore;

/*
* PRESIDENT REQUERY REPOSITORY:
*   extends the abstract class REQUERY REPOSITORY.
*
*   It's guarantee for the business layer that the
*   repository will have all operation that it want.
*
*   The logic of this operations, in this repository,
*   are based in Requery's way.
* */
public class PresidentRequeryRepository extends RequeryRepository<President> {
    public PresidentRequeryRepository( EntityDataStore<Persistable> dataStore ) {
        super( dataStore );
    }

    @Override
    public void save( final Iterable<President> items ) {
        for( President president : items ) {
            PresidentEntity entity = PresidentEntityMapper.INSTANCE.mapFrom( president );
            getDataStore().insert( entity );
        }
    }

    @Override
    public President save( final President item ) {
        PresidentEntity entity = PresidentEntityMapper.INSTANCE.mapFrom( item );
        PresidentEntity presidentInserted = getDataStore().insert( entity );

        return PresidentMapper.INSTANCE.mapFrom( presidentInserted );
    }

    @Override
    public President delete( final President item ) {
        PresidentEntity entity = PresidentEntityMapper.INSTANCE.mapFrom( item );
        getDataStore().delete( entity );

        return item;
    }

    @Override
    public President update( final President item ) {
        PresidentEntity entity = PresidentEntityMapper.INSTANCE.mapFrom( item );
        PresidentEntity presidentUpdated = getDataStore().update( entity );

        return PresidentMapper.INSTANCE.mapFrom( presidentUpdated );
    }

    @Override
    public int count() {
        return getDataStore()
                .count( PresidentEntity.class )
                .get()
                .value();
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List<President> query( final Specification specification ) {
        final RequerySpecification<PresidentEntity> requerySpecification;
        requerySpecification = (RequerySpecification<PresidentEntity>) specification;

        final Result<PresidentEntity> result = requerySpecification
                .toRequeryResult( getDataStore() );

        final List<President> presidentList = new ArrayList<>();

        for( PresidentEntity entity : result ) {
            President president = PresidentMapper.INSTANCE.mapFrom( entity );
            presidentList.add( president );
        }

        return presidentList;
    }

    @Override
    public President first() {
        PresidentEntity entity = getDataStore()
                .select( PresidentEntity.class )
                .get()
                .first();

        return PresidentMapper.INSTANCE.mapFrom( entity );
    }

    @Override
    public President last() {
        PresidentEntity entity = getDataStore()
                .select( PresidentEntity.class )
                .orderBy( PresidentEntityImpl.ID.desc() )
                .get()
                .first();

        return PresidentMapper.INSTANCE.mapFrom( entity );
    }
}
