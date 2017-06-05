package br.com.tomazmartins.samplerequery.core.models;


import java.util.List;

public class Country {
    private List<State> mStates;
    private President mPresident;
    private int mPopulation;
    private String mName;
    private int mId;

    public List<State> getStates() {
        return mStates;
    }

    public void setStates( List<State> states ) {
        this.mStates = states;
    }

    public President getPresident() {
        return mPresident;
    }

    public void setPresident( President president ) {
        this.mPresident = president;
    }

    public int getPopulation() {
        return mPopulation;
    }

    public void setPopulation( int population ) {
        this.mPopulation = population;
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
