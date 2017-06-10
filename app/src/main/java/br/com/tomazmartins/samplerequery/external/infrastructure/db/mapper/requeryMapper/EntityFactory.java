package br.com.tomazmartins.samplerequery.external.infrastructure.db.mapper.requeryMapper;


import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.CountryEntity;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.CountryEntityImpl;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.PresidentEntity;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.entity.PresidentEntityImpl;

public class EntityFactory {
    public CountryEntity createCountryEntity() {
        return new CountryEntityImpl();
    }

    public PresidentEntity createPresidentEntity() {
        return new PresidentEntityImpl();
    }
}
