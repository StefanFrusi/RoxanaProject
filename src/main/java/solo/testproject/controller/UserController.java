package solo.testproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solo.testproject.dto.ActivityDto;
import solo.testproject.dto.ReservationDto;
import solo.testproject.dto.ResponseDto;
import solo.testproject.dto.UserDto;
import solo.testproject.service.UserService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UserController {
    UserService userService;
    UserController(UserService userService)
    {this.userService=userService;}
    @PostMapping("/registerAccount")
    public ResponseEntity<ResponseDto > createAccount(@RequestBody UserDto userDto)
    {   userService.createUserAccount(userDto);
        return new ResponseEntity<>(
                new ResponseDto("The account has been successfully created"
                        ,HttpStatus.CREATED), HttpStatus.OK);
    }
    @PostMapping("/addReservation")
    public ResponseEntity<ResponseDto> addReservation(@RequestBody ReservationDto reservationDto)
    { userService.addReservation(reservationDto);
        return new ResponseEntity<>(
                new ResponseDto("The reservation has been successfully created"
                        ,HttpStatus.CREATED), HttpStatus.OK);
    }
    @PostMapping("/addActivity")
    public ResponseEntity<ResponseDto> addActivity(@RequestBody ActivityDto activityDto)
    { userService.addActivity(activityDto);
        return new ResponseEntity<>(new ResponseDto("The activity has been successfully created",
                HttpStatus.CREATED),HttpStatus.OK);

    }
    @GetMapping("/getReservations")
    public ResponseEntity<List<ReservationDto>> getReservations(@RequestParam(name = "id")Integer activityId,@RequestParam(name = "date") LocalDate date)
    {List<ReservationDto> reservations=userService.getReservations(activityId,date);
        return new ResponseEntity<>(reservations,HttpStatus.OK);
    }
}
