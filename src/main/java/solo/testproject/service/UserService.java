package solo.testproject.service;

import solo.testproject.dto.ActivityDto;
import solo.testproject.dto.ReservationDto;
import solo.testproject.dto.UserDto;
import solo.testproject.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    void createUserAccount(UserDto userDto);
    void addReservation(ReservationDto reservationDto);
    void addActivity(ActivityDto activityDto);
    List<ReservationDto> getReservations(Integer activityId, LocalDate date);
}
