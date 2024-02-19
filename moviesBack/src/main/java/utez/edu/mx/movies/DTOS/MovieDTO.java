package utez.edu.mx.movies.DTOS;

import lombok.Data;
import utez.edu.mx.movies.models.MovieModels;

@Data
public class MovieDTO {
    private Long id;
    private String name;
    private String gender;
    private String description;

    public MovieModels getMovie(){
        System.out.println(id+" "+name+" "+gender+" "+description);
        return new MovieModels(
                this.id,
                this.name,
                this.description,
                this.gender

        );
    }
}
