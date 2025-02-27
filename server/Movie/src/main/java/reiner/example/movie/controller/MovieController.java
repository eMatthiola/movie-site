package reiner.example.movie.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reiner.example.movie.model.Movie;
import reiner.example.movie.service.MovieService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);

    }



    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(id), HttpStatus.OK);
    }

}
