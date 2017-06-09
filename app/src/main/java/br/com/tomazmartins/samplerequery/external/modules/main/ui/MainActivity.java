package br.com.tomazmartins.samplerequery.external.modules.main.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.tomazmartins.samplerequery.R;
import br.com.tomazmartins.samplerequery.core.models.Country;
import br.com.tomazmartins.samplerequery.core.models.President;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.repository.Repository;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.repository.requeryRepository.CountryRepository;
import br.com.tomazmartins.samplerequery.external.infrastructure.db.repository.requeryRepository.PresidentRepository;
import br.com.tomazmartins.samplerequery.external.modules.application.SampleApplication;
import br.com.tomazmartins.samplerequery.external.modules.main.presenter.MainPresenter;
import br.com.tomazmartins.samplerequery.external.modules.main.presenter.MainPresenterImpl;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.requery.Convert;
import io.requery.Persistable;
import io.requery.sql.EntityDataStore;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView( R.id.listView_countries ) ListView listViewCountries;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ButterKnife.bind( this );

        EntityDataStore<Persistable> dataStore;
        dataStore = ((SampleApplication) getApplication()).getDataStore();

        mPresenter = new MainPresenterImpl( dataStore );
        mPresenter.setView( this );
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void setList( List<Country> countryList ) {
        CountryAdapter adapter = new CountryAdapter( countryList, this );
        listViewCountries.setAdapter( adapter );
    }

    @Override
    public void summaryCountry( String infoCountry, String infoPresident ) {
        Log.i( "LOG", infoCountry );
        Log.i( "LOG", infoPresident );
    }

    @Override
    public void summaryDB( int numberCountries, int numberPresidents ) {
        Log.i( "LOG", "Qtd. Presidents: "+ numberPresidents );
        Log.i( "LOG", "Qtd. Countries: "+ numberCountries );
    }
}
