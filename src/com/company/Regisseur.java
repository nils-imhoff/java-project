package com.company;

import java.util.ArrayList;

public class Regisseur {

    private String name;
    private Integer regisseurID;

    private ArrayList<Integer> filme = new ArrayList<>();

    Regisseur(String name, Integer regisseurID) {
        this.name = name;
        this.regisseurID = regisseurID;
    }

    @Override
    public String toString() {
        return "Regisseur{" +
                "Name='" + name + '\'' +
                ", RegisseurID=" + regisseurID +
                ", Filme=" + filme +
                '}';
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

    public Integer getregisseurID() {
        return regisseurID;
    }

    public void setregisseurID(Integer regisseurID) {
        this.regisseurID = regisseurID;
    }

    public ArrayList<Integer> getFilme() {
        return filme;
    }

    public void setFilme(ArrayList<Integer> filme) {
        this.filme = filme;
    }
}
