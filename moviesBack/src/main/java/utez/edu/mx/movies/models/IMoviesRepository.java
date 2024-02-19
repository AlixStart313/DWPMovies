package utez.edu.mx.movies.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utez.edu.mx.movies.models.MovieModels;
import java.util.List;

@Repository
public interface IMoviesRepository extends JpaRepository<MovieModels, Long> {


}
