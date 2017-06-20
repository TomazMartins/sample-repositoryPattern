package br.com.tomazmartins.sampleRDP.external.modules.main.ui;


import java.util.List;

import br.com.tomazmartins.sampleRDP.core.models.Country;

public interface MainView {
    void setList( List<Country> countryList );
    void summaryCountry( String infoCountry, String infoPresident, String infoState );
    void summaryDB( int numberCountries, int numberPresidents, int numberStates );
}
