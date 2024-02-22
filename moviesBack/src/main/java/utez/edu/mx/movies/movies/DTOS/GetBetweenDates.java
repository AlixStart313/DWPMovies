package utez.edu.mx.movies.movies.DTOS;

import lombok.Data;

import java.util.Date;

@Data
public class GetBetweenDates {
    private Date startDate;
    private Date endDate;
}
