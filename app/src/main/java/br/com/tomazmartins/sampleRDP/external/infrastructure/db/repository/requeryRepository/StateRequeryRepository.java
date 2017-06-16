package br.com.tomazmartins.sampleRDP.external.infrastructure.db.repository.requeryRepository;


import java.util.ArrayList;
import java.util.List;

import br.com.tomazmartins.sampleRDP.core.models.State;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.entity.StateEntity;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.entity.StateEntityImpl;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.mapper.requeryMapper.StateEntityMapper;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.mapper.requeryMapper.StateMapper;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.Specification;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.requerySpecification.RequerySpecification;
import io.requery.Persistable;
import io.requery.query.Result;
import io.requery.sql.EntityDataStore;

/*
* STATE REQUERY REPOSITORY:
*   extends the abstract class REQUERY REPOSITORY.
*
*   It's guarantee for the business layer that the
*   repository will have all operation that it want.
*
*   The logic of this operations, in this repository,
*   are based in Requery's way.
* */
public class StateRequeryRepository extends RequeryRepository<State> {
    public StateRequeryRepository( EntityDataStore<Persistable> dataStore ) {
        super( dataStore );
    }

    @Override
    public void save( Iterable<State> items ) {
        for( State item : items ) {
            StateEntity entity = StateEntityMapper.INSTANCE.mapFrom( item );
            getDataStore().insert( entity );
        }
    }

    @Override
    public State save( State item ) {
        StateEntity entity = StateEntityMapper.INSTANCE.mapFrom( item );
        entity = getDataStore().insert( entity );

        return StateMapper.INSTANCE.mapFrom( entity );
    }

    @Override
    public State delete( State item ) {
        StateEntity entity = StateEntityMapper.INSTANCE.mapFrom( item );
        getDataStore().delete( entity );

        return item;
    }

    @Override
    public State update( State item ) {
        StateEntity entity = StateEntityMapper.INSTANCE.mapFrom( item );
        entity = getDataStore().update( entity );

        return StateMapper.INSTANCE.mapFrom( entity );
    }

    @Override
    public int count() {
        return getDataStore()
                .count( StateEntity.class )
                .get()
                .value();
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List<State> query( Specification specification ) {
        final RequerySpecification<StateEntity> requerySpecification;
        requerySpecification = (RequerySpecification<StateEntity>) specification;

        final Result<StateEntity> result = requerySpecification.toRequeryResult( getDataStore() );
        final List<State> stateList = new ArrayList<State>();

        for( StateEntity entity : result ) {
            State state = StateMapper.INSTANCE.mapFrom( entity );
            stateList.add( state );
        }

        return stateList;
    }

    @Override
    public State first() {
        StateEntity entity = getDataStore()
                .select( StateEntity.class )
                .get()
                .first();

        return StateMapper.INSTANCE.mapFrom( entity );
    }

    @Override
    public State last() {
        StateEntity entity = getDataStore()
                .select( StateEntity.class )
                .orderBy( StateEntityImpl.ID.desc() )
                .get()
                .first();

        return StateMapper.INSTANCE.mapFrom( entity );
    }
}
