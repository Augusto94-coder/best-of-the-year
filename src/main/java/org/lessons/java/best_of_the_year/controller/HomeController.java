package org.lessons.java.best_of_the_year.controller;

import org.lessons.java.best_of_the_year.model.Movie;
import org.lessons.java.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        /*
         * String titoli = "";
         * 
         * for (Movie movie : movies) {
         * titoli += movie.getTitle() + ", ";
         * }
         * if (!titoli.isEmpty()) {
         * titoli = titoli.substring(0, titoli.length() - 2);
         * }
         * model.addAttribute("titoli", titoli);
         */
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {

        List<Song> songs = getBestSongs();
        /*
         * String titoli = "";
         * 
         * for (Song song : songs) {
         * titoli += song.getTitle() + ", ";
         * }
         * if (!titoli.isEmpty()) {
         * titoli = titoli.substring(0, titoli.length() - 2);
         * }
         * model.addAttribute("titoli", titoli);
         */
        model.addAttribute("songs", songs);
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String movieDetails(@PathVariable("id") Integer movieId, Model model) {
        /*
         * String details = "";
         * for (int i = 0; i < getBestMovies().size(); i++) {
         * Movie movie = getBestMovies().get(i);
         * if (movieId == movie.getId()) {
         * details = movie.getTitle();
         * break;
         * } else {
         * details = "Nessun film trovato";
         * }
         * }
         * 
         * model.addAttribute("movieDetail", details);
         * return "movie-detail";
         * }
         */
        Movie found = null;
        for (Movie movie : getBestMovies()) {
            if (movieId.equals(movie.getId())) {
                found = movie;
                break;
            }
        }

        model.addAttribute("movie", found);
        return "movie-detail";
    }

    @GetMapping("/songs/{id}")
    public String songDetail(@PathVariable("id") Integer songId, Model model) {
        /*
         * String details = "";
         * for (int i = 0; i < getBestSongs().size(); i++) {
         * Song song = getBestSongs().get(i);
         * if (songId == song.getId()) {
         * details = song.getTitle() + ", " + song.getArtist();
         * break;
         * } else {
         * details = "Nessuna canzone trovata";
         * }
         * }
         * model.addAttribute("songDetail", details);
         * return "song-detail";
         * }
         */
        Song found = null;
        for (Song song : getBestSongs()) {
            if (songId.equals(song.getId())) {
                found = song;
                break;
            }
        }

        model.addAttribute("song", found);
        return "song-detail";
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
        songs.add(new Song(1, "Decadence", "Decadence"));
        songs.add(new Song(2, "Hands of blood", "Bullet for my Valentine"));
        songs.add(new Song(3, "The Only", "Static-X"));
        return songs;
    }

}
