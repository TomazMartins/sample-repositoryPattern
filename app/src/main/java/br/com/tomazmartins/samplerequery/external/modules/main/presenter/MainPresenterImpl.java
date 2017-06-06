package br.com.tomazmartins.samplerequery.external.modules.main.presenter;


import android.util.Log;

import java.util.List;

import br.com.tomazmartins.samplerequery.core.models.Country;
import br.com.tomazmartins.samplerequery.core.models.President;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.repository.Repository;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.repository.requeryRepository.CountryRepository;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.repository.requeryRepository.PresidentRepository;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.specification.requerySpecification.ListAllCountriesSpec;
import br.com.tomazmartins.samplerequery.external.modules.main.ui.MainView;
import io.requery.Persistable;
import io.requery.sql.EntityDataStore;

import static android.R.attr.country;

public class MainPresenterImpl implements MainPresenter {
    private Repository<Country> mCountryRepository;
    private Repository<President> mPresidentRepository;
    private MainView mView;

    public MainPresenterImpl( EntityDataStore<Persistable> dataStore ) {
        this.mCountryRepository = new CountryRepository( dataStore );
        this.mPresidentRepository = new PresidentRepository( dataStore );
    }

    @Override
    public void setView( MainView view ) {
        this.mView = view;
    }

    @Override
    public void onResume() {
        createCountries();

        List<Country> countryList = mCountryRepository.query( new ListAllCountriesSpec() );
        mView.setList( countryList );
    }

    private void createCountries() {
        Country brazil = createBrazil();
        summaryCountry( brazil );

        Country england = createEngland();
        summaryCountry( england );
    }

    @Override
    public void summaryCountry( Country country ) {
        String infoCountry = country.getName() + " has the follow attributes: \n" +
                "ID( " + country.getId() + " ),\n" +
                "Name( " + country.getName() + " ),\n" +
                "Population( " + country.getPopulation() + " ),\n" +
                "President( " + country.getPresident().getId() + "-" + country.getPresident().getName() + " );\n\n";

        String infoPresident = country.getPresident().getName() + " has the follow attributes: \n" +
                "ID( " + country.getPresident().getId() + " ),\n" +
                "Name( " + country.getPresident().getName() + " ),\n" +
                "Country( " + country.getPresident().getCountry().getId() + "-" + country.getPresident().getCountry().getName() + " );\n\n";

        mView.summaryCountry( infoCountry, infoPresident );
    }

    private Country createBrazil() {
        Country brazil = new Country();

        brazil.setName( "Brazil" );
        brazil.setPopulation( 206081432 );

        President michelTemer = new President();
        michelTemer.setName( "Michel Temer" );
        michelTemer.setCountry( brazil );

        michelTemer = mPresidentRepository.save( michelTemer );

        brazil.setPresident( michelTemer );
        brazil = mCountryRepository.save( brazil );

        michelTemer.setCountry( brazil );
        michelTemer = mPresidentRepository.update( michelTemer );

        brazil.setPresident( michelTemer );
        return mCountryRepository.update( brazil );
    }

    private Country createEngland() {
        Country england = new Country();

        england.setName( "England" );
        england.setPopulation( 53012456 );

        President theresaMay = new President();
        theresaMay.setName( "Theresa May" );
        theresaMay.setCountry( england );

        theresaMay = mPresidentRepository.save( theresaMay );

        england.setPresident( theresaMay );
        england = mCountryRepository.save( england );

        theresaMay.setCountry( england );
        theresaMay = mPresidentRepository.update( theresaMay );

        england.setPresident( theresaMay );
        return mCountryRepository.update( england );
    }
}
