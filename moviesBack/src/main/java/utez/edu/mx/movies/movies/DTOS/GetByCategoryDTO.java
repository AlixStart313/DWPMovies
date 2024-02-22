package utez.edu.mx.movies.movies.DTOS;

import lombok.Data;
import utez.edu.mx.movies.categories.Categories;


@Data
public class GetByCategoryDTO {
    private Categories category;
    public GetByDirectorDTO getByCategoryDTO(){
        return (this.getByCategoryDTO());
    }
}
