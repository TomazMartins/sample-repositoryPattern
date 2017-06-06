package br.com.tomazmartins.samplerequery.external.modules.main.presenter;


import br.com.tomazmartins.samplerequery.core.models.Country;
import br.com.tomazmartins.samplerequery.external.modules.main.ui.MainView;

public interface MainPresenter {
    void onResume();
    void setView( MainView view );
    void summaryCountry( Country country );
}
