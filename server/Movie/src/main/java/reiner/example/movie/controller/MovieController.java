package reiner.example.movie.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Movie Management API", description = "Provides movie query functionality")
@RestController
@RequestMapping("/api/v1/movies")
//@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    @Autowired
    private MovieService movieService;

    /**
     * Get all movies
     * @return List of movies
     */
    @Operation(summary = "Get all movies", description = "Returns a list of all movies")
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);

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
     * Get a movie by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(
            @Parameter(description = "Movie ID", required = true) @PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(id), HttpStatus.OK);
    }

    /**
     * pagenagtion
     * @param movie
     * @return
     */
//    public ResponseEntity<Optional<Movie>> get;
}
