package br.com.algorithmworks.samplerequery.record;


import java.util.List;

public interface Recorder {
    void save( final Object object );
    void update( final Object object );
    void delete( final Object object );

    Object getById( int id );
    List<?> getAll();
}
