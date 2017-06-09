package br.com.tomazmartins.samplerequery.core.models;


import java.util.List;

public class Country {
    private List<State> states;
    private President president;
    private int population;
    private String name;
    private int id;

    public List<State> getStates() {
        return states;
    }

    public void setStates( List<State> states ) {
        this.states = states;
    }

    public President getPresident() {
        return president;
    }

    public void setPresident( President president ) {
        this.president = president;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation( int population ) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }
}
