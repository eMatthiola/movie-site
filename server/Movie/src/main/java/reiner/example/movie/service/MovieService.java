package reiner.example.movie.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reiner.example.movie.model.Movie;
import reiner.example.movie.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName MovieService
 * @Description TODO
 * @Author Matthiola
 * @Date 2025/2/9 16:43
 */
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }


    public Optional<Movie> getMovieById(ObjectId id) {
        return movieRepository.findById(id);
    }
}
