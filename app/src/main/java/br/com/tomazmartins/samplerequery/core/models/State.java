package br.com.tomazmartins.samplerequery.core.models;


class State {
    private Country mCountry;
    private String mName;
    private int mId;

    public Country getCountry() {
        return mCountry;
    }

    public void setCountry( Country country ) {
        this.mCountry = country;
    }

    public String getName() {
        return mName;
    }

    public void setName( String name ) {
        this.mName = name;
    }

    public int getId() {
        return mId;
    }

    public void setId( int id ) {
        this.mId = id;
    }
}
