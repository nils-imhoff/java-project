package com.company;

import java.util.ArrayList;

public class Schauspieler {
    private String name;
    private Integer schauspielerID;
    private ArrayList<Integer> filme = new ArrayList<>();

    Schauspieler(String name, Integer schauspielerID) {
        this.name = name;
        this.schauspielerID = schauspielerID;
    }

    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                ", SchauspielerID=" + schauspielerID +
                ", Filme=" + filme;
    }

    void addFilm(Integer filmID) {
        filme.add(filmID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSchauspielerID() {
        return schauspielerID;
    }

    public void setSchauspielerID(Integer schauspielerID) {
        this.schauspielerID = schauspielerID;
    }

    public ArrayList<Integer> getFilme() {
        return filme;
    }

    public void setFilme(ArrayList<Integer> filme) {
        this.filme = filme;
    }
}
