package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ProjektTest {
    //Testen ob Matrix den ersten Film Matrix liefert
    @Test
    public void testFilm (){
        FilmDB filmDB  = new FilmDB();
        final String expected = "Titel='Matrix, The', Beschreibung='A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', Release='1999-03-31', IMDBVotes='1163136', IMDBRating=8.7, FilmID=2081, Genres=[Thriller, Sci-Fi], Schauspieler=[16689, 20027, 16315, 18255], Regisseure=[30191, 30192]";
        ArrayList<String> tfilm = new ArrayList();
        tfilm.add("Matrix");
        final ArrayList<String> actual = filmDB.sucheFilm(tfilm);
        Assert.assertEquals(actual.get(0), expected);
    }
    //Testen ob Kenau Reeves auch Kenau Reeves liefert
    @Test
    public void testSchauspieler (){
        FilmDB filmDB  = new FilmDB();
        final String expected = "Name='Keanu Reeves', SchauspielerID=15578, Filme=[1102, 1301, 3130, 3240, 3378, 3466, 5041, 5999, 8401]";
        ArrayList<String> tschauspieler = new ArrayList<>();
        tschauspieler.add("Keanu Reeves");
        final ArrayList<String> actual = filmDB.sucheSchauspieler(tschauspieler);
        Assert.assertEquals(actual.get(0), expected);
    }
    //Prüfen ob die Anzahl der Filme bzw. Schauspieler stimmt
    @Test
    public void testFilmNetz (){
        FilmDB filmDB = new FilmDB();
        ArrayList<String> tNetz = new ArrayList<>();
        tNetz.add("2018");
        final ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(37);
        final ArrayList<Integer> actual = filmDB.netwerkFilm(tNetz);
        Assert.assertEquals(actual, expected);
    }
    //Prüfen ob die Anzahl der Filme bzw. Schauspieler stimmt
    @Test
    public void testSchauspielerNetz (){
        FilmDB filmDB = new FilmDB();
        ArrayList<String> tNetz = new ArrayList<>();
        tNetz.add("19786");
        final ArrayList<Integer> expected = new ArrayList<>();
        expected.add(11);
        expected.add(27);
        final ArrayList<Integer> actual = filmDB.netwerkSchauspieler(tNetz);
        Assert.assertEquals(actual, expected);
    }

}
