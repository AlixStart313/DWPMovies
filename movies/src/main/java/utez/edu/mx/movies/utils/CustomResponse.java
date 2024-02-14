package utez.edu.mx.movies.utils;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomResponse <T>{
    T data;
    boolean error;
    int statusCode;
    String message;
}
