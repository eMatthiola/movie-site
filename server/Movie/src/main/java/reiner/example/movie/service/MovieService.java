package reiner.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reiner.example.movie.model.Movie;
import reiner.example.movie.repository.MovieRepository;

import java.util.List;

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
        System.out.println(movieRepository.findAll().toString());
        return movieRepository.findAll();
    }
}
