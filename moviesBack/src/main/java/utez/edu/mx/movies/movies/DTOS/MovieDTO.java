package utez.edu.mx.movies.movies;

import lombok.Data;
import utez.edu.mx.movies.categories.Categories;
import utez.edu.mx.movies.movies.MovieModels;

import java.util.Date;

@Data
public class MovieDTO {
    private Long id;
    private String name;
    //private String gender;
    private String description;
    private Date pulicationDate;
    private String directorsName;
    private Categories gender;

    public MovieModels getMovie(){
        System.out.println(id+" "+name+" "+gender+" "+description);
        return new MovieModels(
                this.id,
                this.name,
                this.description,
                this.directorsName,
                this.pulicationDate,
                this.gender
        );
    }
}
