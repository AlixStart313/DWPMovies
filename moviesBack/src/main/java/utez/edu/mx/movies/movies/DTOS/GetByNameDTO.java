package utez.edu.mx.movies.movies.DTOS;

import lombok.Data;
import utez.edu.mx.movies.movies.models.MovieModels;

@Data
public class GetByNameDTO {
    private String name;

    public MovieModels getByNameDTO(){
        return  new MovieModels(
                null,
                this.getName(),
                null,
                null,
                null,
                null
        );
    }
}
