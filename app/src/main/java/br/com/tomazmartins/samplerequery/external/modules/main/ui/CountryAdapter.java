package br.com.tomazmartins.samplerequery.external.modules.main.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.tomazmartins.samplerequery.R;
import br.com.tomazmartins.samplerequery.core.models.Country;


public class CountryAdapter extends BaseAdapter {
    private List<Country> mCountryList;
    private Context mContext;


    private static class CountryViewHolder {
        final TextView nameCountry;
        final TextView populationCountry;
        final TextView presidentCountry;

        private CountryViewHolder( View view ) {
            this.nameCountry = (TextView) view.findViewById( R.id.textView_nameCountry );
            this.populationCountry = (TextView) view.findViewById( R.id.textView_populationCountry );
            this.presidentCountry = (TextView) view.findViewById( R.id.textView_presidentCountry );
        }
    }


    public CountryAdapter( List<Country> mCountryList, Context mContext ) {
        this.mCountryList = mCountryList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return this.mCountryList.size();
    }

    @Override
    public Object getItem( int position ) {
        return this.mCountryList.get( position );
    }

    @Override
    public long getItemId( int position ) {
        return 0;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {
        View rowView = verifyView( convertView, parent );

        CountryViewHolder viewHolder = new CountryViewHolder( rowView );

        Country country = (Country) getItem( position );

        String nameCountry = country.getName();
        String populationCountry = String.valueOf( country.getPopulation() );
        String presidentCountry = country.getPresident().getName();

        viewHolder.nameCountry.setText( nameCountry );
        viewHolder.populationCountry.setText( populationCountry );
        viewHolder.presidentCountry.setText( presidentCountry );

        return rowView;
    }

    private View verifyView( View convertView, ViewGroup parent ) {
        View rowView;

        if( convertView != null ) {
            rowView = convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );

            rowView = inflater.inflate( R.layout.adapter_country, parent, false );
        }

        return rowView;
    }
}
