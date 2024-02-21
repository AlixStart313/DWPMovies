package utez.edu.mx.movies.movies;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utez.edu.mx.movies.categories.Categories;

import java.util.Date;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String name;
    @Column(nullable = false, length = 200)
    private String description;
    @Column(nullable = false,length = 200)
    private String directorsName;
    @Column(nullable = false)
    private Date publicationDate;
    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false, referencedColumnName = "id")
    private Categories categories;

}
