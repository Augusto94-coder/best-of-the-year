package org.lessons.java.best_of_the_year.controller;

import org.lessons.java.best_of_the_year.model.Movie;
import org.lessons.java.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Augusto Di Leo");
        return "index";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movies = getBestMovies();
        String titoli = "";

        for (Movie movie : movies) {
            titoli += movie.getTitle() + ", ";
        }
        if (!titoli.isEmpty()) {
            titoli = titoli.substring(0, titoli.length() - 2);
        }
        model.addAttribute("titoli", titoli);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {

        List<Song> songs = getBestSongs();
        songs.add(new Song(4, "Giuseppe Verdi - Va pensiero"));
        String titoli = "";

        for (Song song : songs) {
            titoli += song.getTitle() + ", ";
        }
        if (!titoli.isEmpty()) {
            titoli = titoli.substring(0, titoli.length() - 2);
        }
        model.addAttribute("titoli", titoli);
        return "songs";
    }

    

    // ---- METODI getBestMovies() e getBestSongs()

    private List<Movie> getBestMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Lupin III - Jigen's gravestone"));
        movies.add(new Movie(2, "Lupin III - Goemon's blood spray"));
        movies.add(new Movie(3, "Lupin III - Fujiko's lie"));
        return movies;
    }

    private List<Song> getBestSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Disturbed - Decadence"));
        songs.add(new Song(2, "Bullet for my Valentines - Hands of blood"));
        songs.add(new Song(3, "Static X - The Only"));
        return songs;
    }

}
