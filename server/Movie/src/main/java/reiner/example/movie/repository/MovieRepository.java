package reiner.example.movie.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reiner.example.movie.model.Movie;

import java.util.Optional;

/**
 * @ClassName MovieRepository
 * @Description TODO
 * @Author Matthiola
 * @Date 2025/2/9 11:39
 */
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
//    Optional<Movie> findMovieByImbdId(String imbdId);

}
