package com.company;

import java.util.ArrayList;

public class Film {

    private String filmTitel;
    private String filmBeschreibung;
    private String filmRelease;
    private String IMDBVotes;
    private Double IMDBRating;
    private Integer filmID;

    private Double currentWeight;

    private ArrayList<String> genreNames = new ArrayList<>();
    private ArrayList<Integer> schauspieler = new ArrayList<>();
    private ArrayList<Integer> regisseure = new ArrayList<>();


    Film(
            String filmTitle,
            String filmBeschreibung,
            String filmRelease,
            String IMDBVotes,
            Double IMDBRating,
            Integer filmID
    ) {
        this.filmTitel = filmTitle;
        this.filmBeschreibung = filmBeschreibung;
        this.filmRelease = filmRelease;
        this.IMDBVotes = IMDBVotes;
        this.IMDBRating = IMDBRating;
        if (IMDBRating == 0) {
            this.IMDBRating = 1.0;
        }
        this.filmID = filmID;
    }

    @Override
    public String toString() {
        return  "Titel='" + filmTitel + '\'' +
                ", Beschreibung='" + filmBeschreibung + '\'' +
                ", Release='" + filmRelease + '\'' +
                ", IMDBVotes='" + IMDBVotes + '\'' +
                ", IMDBRating=" + IMDBRating +
                ", FilmID=" + filmID +
                ", Genres=" + genreNames +
                ", Schauspieler=" + schauspieler +
                ", Regisseure=" + regisseure;
    }

    void addGenre(String genre) {
        genreNames.add(genre);
    }

    void addSchauspieler(Integer schauspielerID) {
        schauspieler.add(schauspielerID);
    }

    void addRegisseur(Integer regisseurID) {
        regisseure.add(regisseurID);
    }

    public String getFilmTitel() {
        return filmTitel;
    }

    public void setFilmTitel(String filmTitel) {
        this.filmTitel = filmTitel;
    }

    public String getFilmBeschreibung() {
        return filmBeschreibung;
    }

    public void setFilmBeschreibung(String filmBeschreibung) {
        this.filmBeschreibung = filmBeschreibung;
    }

    public ArrayList<String> getGenreNames() {
        return genreNames;
    }

    public void setGenreNames(ArrayList<String> genreNames) {
        this.genreNames = genreNames;
    }

    public String getFilmRelease() {
        return filmRelease;
    }

    public void setFilmRelease(String filmRelease) {
        this.filmRelease = filmRelease;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
    }

    public ArrayList<Integer> getSchauspieler() {
        return schauspieler;
    }

    public void setSchauspieler(ArrayList<Integer> schauspieler) {
        this.schauspieler = schauspieler;
    }

    public ArrayList<Integer> getRegisseur() {
        return regisseure;
    }

    public void setRegisseur(ArrayList<Integer> regisseure) {
        this.regisseure = regisseure;
    }

    public String getIMDBVotes() {
        return IMDBVotes;
    }

    public void setIMDBVotes(String IMDBVotes) {
        this.IMDBVotes = IMDBVotes;
    }

    public Double getIMDBRating() {
        return IMDBRating;
    }

    public void setIMDBRating(Double IMDBRating) {
        this.IMDBRating = IMDBRating;
    }

}