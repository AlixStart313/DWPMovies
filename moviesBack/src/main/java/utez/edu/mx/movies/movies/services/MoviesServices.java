package utez.edu.mx.movies.movies.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.movies.categories.Categories;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.movies.movies.models.MovieModels;
import utez.edu.mx.movies.movies.repository.IMoviesRepository;
import utez.edu.mx.movies.utils.CustomResponse;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MoviesServices {
    @Autowired
    private IMoviesRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<MovieModels>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Lista de peliculas"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse <MovieModels> saveMovie(MovieModels movie) {
      return  new CustomResponse<>(
              this.repository.saveAndFlush(movie),
              false,
              200,
              "pelicula registrada con éxito"
      );
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<MovieModels>> getByName(String name){
        return new CustomResponse<List<MovieModels>>(
                this.repository.findAllByName(name),
                false,
                200,
                "ok"
                );
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<MovieModels>> getByDirectors(String name){
        return new CustomResponse<List<MovieModels>>(
                this.repository.findAllByDirectorsName(name),
                false,
                200,
                "ok"
        );
    }

    @Transactional(rollbackFor = SQLException.class)
    public CustomResponse<List<MovieModels>> getBetweenDates(Date startDate,Date endDate){
        return new CustomResponse<List<MovieModels>>(
                this.repository.findByPublicationDateBetween(startDate,endDate),
                false,
                200,
                "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<MovieModels>> getByCategory(Categories category){
        return new CustomResponse<List<MovieModels>>(
                this.repository.findByCategories(category),
                false,
                200,
                "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<MovieModels>> getByPublicationDaterOrder(){
        return new CustomResponse<List<MovieModels>>(
                this.repository.findByOrderByPublicationDateDesc(),
                false,
                200,
                "ok"
        );
    }




}
