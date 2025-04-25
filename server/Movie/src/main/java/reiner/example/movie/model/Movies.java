package reiner.example.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Movies
 * @Description TODO
 * @Author Matthiola
 * @Date 2025/4/24 11:51
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
    private Long id;
    private String name;
    private Date date;
}
