package utez.edu.mx.movies.movies.DTOS;

import lombok.Data;
import utez.edu.mx.movies.movies.models.MovieModels;

@Data
public class GetByDirectorDTO {
    private String directorName;


    public MovieModels GetByDirectorDTO(){
        return  new MovieModels(
                null,
                null,
                null,
                this.getDirectorName(),
                null,
                null
        );
    }
}
