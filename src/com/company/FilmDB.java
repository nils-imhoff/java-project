package com.company;

import java.io.*;
import java.util.*;

public class FilmDB {

    private HashMap<Integer, Schauspieler> schauspieler = new HashMap<>();
    private HashMap<Integer, Film> film = new HashMap<>();
    private HashMap<Integer, Regisseur> regisseur = new HashMap<>();

    FilmDB () {
        readFile();
    }

    private void readFile() {

        String in;
        String identifier = null;
        String substrings[];

        Integer id;
        Integer filmId;

        Double rating;

        String name;
        String title;
        String genre;
        String plot;
        String filmReleased;
        String IMDBVotes;
        String IMDBRating;

        try (BufferedReader br = new BufferedReader(new FileReader("movieproject2019.db"))) {
            while ((in = br.readLine()) != null) {
                if (in.contains("New_Entity: ")) {
                    identifier = in.substring(12);
                } else {
                    switch (identifier) {
                        case ("\"actor_id\",\"actor_name\""):
                            substrings = in.split("\",\"");
                            id = Integer.parseInt(substrings[0].substring(1));
                            name = substrings[1].trim().substring(0, substrings[1].length() - 1);
                            schauspieler.put(id, new Schauspieler(name, id));
                            break;
                        case ("\"movie_id\",\"movie_title\",\"movie_plot\",\"genre_name\",\"movie_released\",\"movie_imdbVotes\",\"movie_imdbRating\""):

                            substrings = in.split("\",\"");
                            id = Integer.parseInt(substrings[0].substring(1));
                            title = substrings[1].trim();
                            plot = substrings[2].trim();
                            genre = substrings[3].trim();
                            filmReleased = substrings[4].trim();
                            IMDBVotes = substrings[5].trim();
                            IMDBRating = substrings[6].trim().substring(0, substrings[6].length() - 1);
                            rating = Double.parseDouble("0" + IMDBRating);

                            if (film.get(id) != null) {
                                film.get(id).addGenre(genre);
                            } else {
                                film.put(id, new Film(title, plot, filmReleased, IMDBVotes, rating, id));
                            }

                            break;
                        case ("\"director_id\",\"director_name\""):
                            substrings = in.split("\",\"");
                            id = Integer.parseInt(substrings[0].substring(1));
                            name = substrings[1].trim().substring(0, substrings[1].length() - 1);
                            regisseur.put(id, new Regisseur(name, id));
                            break;
                        case ("\"actor_id\",\"movie_id\""):
                            substrings = in.split("\",\"");
                            id = Integer.parseInt(substrings[0].substring(1));
                            filmId = Integer.parseInt(substrings[1].trim().substring(0, substrings[1].length() - 1));

                            schauspieler.get(id).addFilm(filmId);
                            film.get(filmId).addRegisseur(id);

                            break;
                        case ("\"director_id\",\"movie_id\""):
                            substrings = in.split("\",\"");
                            id = Integer.parseInt(substrings[0].substring(1));
                            filmId = Integer.parseInt(substrings[1].trim().substring(0, substrings[1].length() - 1));

                            film.get(filmId).addRegisseur(id);
                            regisseur.get(id).addFilm(filmId);

                            break;
                        default:
                            break;

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void sucheFilm (ArrayList<String> params) {

        for(int i = 0; i < params.size(); i++) {
            for (Film value : film.values()) {
                if (value.getFilmTitel().toLowerCase().contains(params.get(i).toLowerCase())) {
                    System.out.println(value);
                }
            }
        }
    }

    void sucheSchauspieler (ArrayList<String> params) {

        for(int i = 0; i < params.size(); i++) {
            for (Schauspieler value : schauspieler.values()) {
                if (value.getName().toLowerCase().contains(params.get(i).toLowerCase())) {
                    System.out.println(value);
                }
            }
        }
    }

    public String toString() {
        return "MovieDB{" +
                "actor=" + schauspieler +
                ", movie=" + film +
                ", director=" + regisseur +
                '}';
    }

    public HashMap<Integer, Schauspieler> getSchauspieler() {
        return schauspieler;
    }

    public void setSchauspieler(HashMap<Integer, Schauspieler> schauspieler) {
        this.schauspieler = schauspieler;
    }

    public HashMap<Integer, Film> getFilm() {
        return film;
    }

    public void setMovie(HashMap<Integer, Film> film) {
        this.film = film;
    }

    public HashMap<Integer, Regisseur> getRegisseur() {
        return regisseur;
    }

    public void setDirector(HashMap<Integer, Schauspieler> director) {
        this.schauspieler = director;
    }
}
