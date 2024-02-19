package utez.edu.mx.movies.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.movies.models.IMoviesRepository;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.movies.models.MovieModels;
import utez.edu.mx.movies.utils.CustomResponse;

import java.sql.SQLException;
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


}
