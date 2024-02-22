package utez.edu.mx.movies.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utez.edu.mx.movies.categories.Categories;
import utez.edu.mx.movies.movies.models.MovieModels;

import java.util.Date;
import java.util.List;

@Repository
public interface IMoviesRepository extends JpaRepository<MovieModels, Long> {

    List<MovieModels> findAllByName(String name);
    List<MovieModels> findAllByDirectorsName(String directors);
    List<MovieModels> findByPublicationDateBetween(Date startDate, Date endDate);
    List<MovieModels> findByCategories(Categories categories);
    List<MovieModels> findByOrderByPublicationDateDesc();

}
