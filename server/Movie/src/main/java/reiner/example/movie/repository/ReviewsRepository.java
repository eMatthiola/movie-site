package reiner.example.movie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reiner.example.movie.model.Review;

/**
 * @ClassName ReviewsRepository
 * @Description TODO
 * @Author Matthiola
 * @Date 2025/3/11 15:19
 */

@Repository
public interface ReviewsRepository extends MongoRepository<Review, String> {
}
