package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        FilmDB filmDB = new FilmDB();
        ArrayList<String> genreArg = new ArrayList<>();
        ArrayList<String> schauspielerArg = new ArrayList<>();
        ArrayList<String> filmArg = new ArrayList<>();
        ArrayList<String> regisseurArg = new ArrayList<>();

        String limitArg = "200";
        Integer limit;

        Boolean test = false;


        filmDB.getRegisseur();

        if (args.length != 0) {
            for (String s : args) {
                if (s.contains("--schauspieler=")) {
                    schauspielerArg = extractArguments(s);
                } else if (s.contains("--film=")) {
                    filmArg = extractArguments(s);
                }
            }
            if(filmArg.size()>=1);
                filmDB.sucheFilm(filmArg);

            if(schauspielerArg.size()>=1);
                filmDB.sucheSchauspieler(schauspielerArg);



        }
    }

    private static ArrayList<String> extractArguments(String s) {

        return new ArrayList<>(
                Arrays.asList(
                        s.substring(
                                s.indexOf("=") + 1)
                                .split(",")
                ));
    }
}

