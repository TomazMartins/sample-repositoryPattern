package br.com.tomazmartins.sampleRDP.external.modules.main.presenter;


import br.com.tomazmartins.sampleRDP.core.models.Country;
import br.com.tomazmartins.sampleRDP.external.modules.main.ui.MainView;

public interface MainPresenter {
    void onResume();
    void setView( MainView view );
    void summaryCountry( Country country );
}
