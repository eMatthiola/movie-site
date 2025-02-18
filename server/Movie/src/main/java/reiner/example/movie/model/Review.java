package reiner.example.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName Review
 * @Description TODO
 * @Author Matthiola
 * @Date 2025/2/9 11:21
 */

@Document(collection = "review")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    @Id
    private ObjectId id;

    private String body;
}
