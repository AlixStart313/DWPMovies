package utez.edu.mx.movies.categories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utez.edu.mx.movies.movies.MovieModels;

import java.util.List;


@Entity
@Table(name = "Categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 200)
    private String genderName;
    @Column(nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "categories")
    private List<MovieModels> movieList;



}
