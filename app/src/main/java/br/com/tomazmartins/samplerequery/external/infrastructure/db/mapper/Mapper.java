package br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper;


public interface Mapper<From, To> {
    To mapFrom( From fromObject );
}
