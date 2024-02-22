package utez.edu.mx.movies.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.movies.movies.DTOS.*;
import utez.edu.mx.movies.movies.services.MoviesServices;
import utez.edu.mx.movies.movies.models.MovieModels;
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

    @GetMapping("/getByDirector")
    public ResponseEntity<CustomResponse<List<MovieModels>>> getByDirector(@RequestBody GetByDirectorDTO dto){
        return new ResponseEntity<>(
                this.services.getByDirectors(dto.getDirectorName()),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/getByName")
    public ResponseEntity<CustomResponse<List<MovieModels>>> getByName(@RequestBody GetByNameDTO dto){
        return new ResponseEntity<>(
                this.services.getByName(dto.getName()),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/getByCategory")
    public ResponseEntity<CustomResponse<List<MovieModels>>> getByName(@RequestBody GetByCategoryDTO dto){
        return new ResponseEntity<>(
                this.services.getByCategory(dto.getCategory()),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/getByPublicationDate")
    public ResponseEntity<CustomResponse<List<MovieModels>>> getByPublicationDate(){
        return new ResponseEntity<>(
                this.services.getByPublicationDaterOrder(),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/filterDates")
    public ResponseEntity<CustomResponse<List<MovieModels>>> filterDates(@RequestBody GetBetweenDates dto){
        return new ResponseEntity<>(
                this.services.getBetweenDates(dto.getStartDate(),dto.getEndDate()),
                HttpStatus.FOUND
        );
    }







}
