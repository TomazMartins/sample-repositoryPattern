package br.com.tomazmartins.sampleRDP.external.modules.main.presenter;


import java.util.List;

import br.com.tomazmartins.sampleRDP.core.models.Country;
import br.com.tomazmartins.sampleRDP.core.models.President;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.repository.Repository;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.repository.requeryRepository.CountryRequeryRepository;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.repository.requeryRepository.PresidentRequeryRepository;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.requerySpecification.FindCountryByIdSpec;
import br.com.tomazmartins.sampleRDP.external.infrastructure.db.specification.requerySpecification.ListAllCountriesSpec;
import br.com.tomazmartins.sampleRDP.external.modules.main.ui.MainView;
import io.requery.Persistable;
import io.requery.sql.EntityDataStore;

public class MainPresenterImpl implements MainPresenter {
    private Repository<Country> mCountryRepository;
    private Repository<President> mPresidentRepository;
    private MainView mView;

    public MainPresenterImpl( EntityDataStore<Persistable> dataStore ) {
        this.mCountryRepository = new CountryRequeryRepository( dataStore );
        this.mPresidentRepository = new PresidentRequeryRepository( dataStore );
    }

    @Override
    public void setView( MainView view ) {
        this.mView = view;
    }

    @Override
    public void onResume() {
        if( mCountryRepository.count() == 0 && mPresidentRepository.count() == 0 ) {
            createCountries();
        }

        int qtdCountries = mCountryRepository.count();
        int qtdPresidents = mPresidentRepository.count();

        mView.summaryDB( qtdCountries, qtdPresidents );

        for( int id = 1; id <= mCountryRepository.count(); ++id ) {
            Country country = findCountry( id );
            summaryCountry( country );
        }

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

        michelTemer = mPresidentRepository.save( michelTemer );

        brazil.setPresident( michelTemer );

        return mCountryRepository.save( brazil );
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
        return mCountryRepository.save( england );
    }

    private Country findCountry( int id ) {
        final int FIRST = 0;
        return mCountryRepository.query( new FindCountryByIdSpec( id ) ).get( FIRST );
    }
}
