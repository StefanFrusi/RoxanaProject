package solo.testproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ReservationDto {
    private Integer activityId;
    private String email;
    private LocalDate date;
    private Integer numberOfTickets;

}
