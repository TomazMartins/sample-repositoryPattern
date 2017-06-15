package br.com.tomazmartins.sampleRDP.external.infrastructure.db.repository;


import java.util.List;

import br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.Specification;

public interface Repository<T> {
    void save( final Iterable<T> items );

    T save( final T item );
    T delete( final T item );
    T update( final T item );

    int count();

    List<T> query( Specification specification );

    T first();
    T last();
}
