package br.com.tomazmartins.sampleRDP.external.infrastructure.db.repository;


import java.util.List;

import br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.Specification;

/*
* REPOSITORY:
*   This class serves as a contract.
*   All Repositories must implement this methods.
*
*   It's guarantee which the repository that we use
*   has useful and known methods.
* */
public interface Repository<Model> {
    List<Model> save( final Iterable<Model> items );

    Model save( final Model item );
    Model delete( final Model item );
    Model update( final Model item );

    int count();

    List<Model> query( Specification specification );

    Model first();
    Model last();
}
