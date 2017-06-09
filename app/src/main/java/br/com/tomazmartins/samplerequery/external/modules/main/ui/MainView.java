package br.com.tomazmartins.samplerequery.external.modules.main.ui;


import java.util.List;

import br.com.tomazmartins.samplerequery.core.models.Country;

public interface MainView {
    void setList( List<Country> countryList );
    void summaryCountry( String infoCountry, String infoPresident );
    void summaryDB( int numberCountries, int numberPresidents );
}
