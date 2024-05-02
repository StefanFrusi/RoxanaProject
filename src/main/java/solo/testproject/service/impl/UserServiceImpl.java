package solo.testproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import solo.testproject.dto.ActivityDto;
import solo.testproject.dto.ReservationDto;
import solo.testproject.dto.UserDto;
import solo.testproject.entity.Activity;
import solo.testproject.entity.Reservation;
import solo.testproject.entity.User;
import solo.testproject.exception.GlobalException;
import solo.testproject.mapper.ActivityMapper;
import solo.testproject.mapper.ReservationMapper;
import solo.testproject.mapper.UserMapper;
import solo.testproject.repository.ActivityRepository;
import solo.testproject.repository.ReservationRepository;
import solo.testproject.repository.UserRepository;
import solo.testproject.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final ActivityRepository activityRepository;

    UserServiceImpl(UserRepository userRepository,ReservationRepository reservationRepository,ActivityRepository activityRepository)
    {  this.reservationRepository=reservationRepository;
        this.userRepository=userRepository;
        this.activityRepository=activityRepository;
    }

    public void createUserAccount(UserDto userDto) {
        Optional<User> DBUser=userRepository.findByEmail(userDto.getEmail());
        if(DBUser.isPresent())
            throw new GlobalException("There is already and existing account associated with this email address", HttpStatus.BAD_REQUEST);
        User user= UserMapper.toUser(userDto);
        userRepository.save(user);
    }

    public void addReservation(ReservationDto reservationDto)
    { Optional<User> DBUser= userRepository.findByEmail(reservationDto.getEmail());
        Optional<Activity> activity= activityRepository.findById(reservationDto.getActivityId());
        if(activity.isEmpty())
            throw new GlobalException("The activity provided does not exist",HttpStatus.BAD_REQUEST);
        if(DBUser.isEmpty())
            throw new GlobalException("There is no account that matches this email address",HttpStatus.BAD_REQUEST);
        Reservation reservation= ReservationMapper.toReservation(reservationDto);
        reservationRepository.save(reservation);

    }

    public void addActivity(ActivityDto activityDto)
    { Optional<Activity> activityDB=activityRepository.findByName(activityDto.getName());
        if(activityDB.isPresent())
            throw new GlobalException("There is already an existing activity with this name",HttpStatus.BAD_REQUEST);
      Activity activity= ActivityMapper.toActivity(activityDto);
        activityRepository.save(activity);

    }
    public List<ReservationDto> getReservations(Integer activityId, LocalDate date)
    {
        List<Reservation> reservations= reservationRepository.findByActivityIdAndDate(activityId,date);
        return ReservationMapper.toReservationDtoList(reservations);
    }
}
