package reiner.example.movie.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Tag(name = "Movie Management API", description = "Provides movie query functionality")
@RestController
@RequestMapping("/api/v1/movies")
//@CrossOrigin(origins = {"http://localhost:3000", "https://32c0-38-34-84-35.ngrok-free.app"})
public class MovieController {
    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    /**
     * Get all movies
     * @return List of movies
     */
    @Operation(summary = "Get all movies", description = "Returns a list of all movies")
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        log.info("Received request to fetch all movies.");
        List<Movie> movies = movieService.allMovies();
        log.info("Returning {} movies.", movies.size());
        return ResponseEntity.ok(movies);

    }

    /**
     * Search for a movie by keyword
     * @param keyword
     * @return List of matching movies
     */
    @Operation(summary = "Search for a movie by keyword", description = "Returns a list of movies that match the search keyword")
    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovie(
            @Parameter(description = "Movie title keyword", required = true) @RequestParam String keyword) {
        List<Movie> filteredMovies = movieService.allMovies().stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        return filteredMovies.isEmpty() ?  ResponseEntity.notFound().build() : ResponseEntity.ok(filteredMovies);


    }

    /**
     * Get a movie by imdbId
     * @param imdbId
     * @return
     */
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByimdbId(
            @Parameter(description = "Movie imdbId", required = true) @PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieByimdbId(imdbId), HttpStatus.OK);
    }

    /**
     * pagenagtion
     * @param movie
     * @return
     */
//    public ResponseEntity<Optional<Movie>> get;
}
