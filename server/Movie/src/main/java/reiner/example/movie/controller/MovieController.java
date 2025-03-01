package reiner.example.movie.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reiner.example.movie.model.Movie;
import reiner.example.movie.service.MovieService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName MovieController
 * @Description TODO
 * @Author Matthiola
 * @Date 2025/2/9 11:24
 */

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    /**
     * Get all movies
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);

    }

    /**
     * Search for a movie by keyword
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovie(@RequestParam String keyword) {
        List<Movie> filteredMovies = movieService.allMovies().stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        return filteredMovies.isEmpty() ?  ResponseEntity.notFound().build() : ResponseEntity.ok(filteredMovies);


    }

    /**
     * Get a movie by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(id), HttpStatus.OK);
    }


    public ResponseEntity<Optional<Movie>> get;
}
