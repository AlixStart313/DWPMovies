package utez.edu.mx.movies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.movies.utils.CustomResponse;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = {"*"})
public class MoviesController {
    @Autowired
    MoviesServices services;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<MovieModels>>> getAll() {
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }

    @PostMapping("/saveMovie")
    public ResponseEntity<CustomResponse<MovieModels>> savemovie(@RequestBody MovieDTO dto){
        System.out.println(dto);
        return  new ResponseEntity<>(
                this.services.saveMovie(dto.getMovie()),
                HttpStatus.CREATED
        );
    }


}
