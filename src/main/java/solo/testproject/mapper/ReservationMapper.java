package solo.testproject.mapper;

import solo.testproject.dto.ReservationDto;
import solo.testproject.entity.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationMapper {
    public static Reservation toReservation(ReservationDto reservationDto)
    { Reservation reservation=new Reservation();
        reservation.setActivityId(reservationDto.getActivityId());
        reservation.setEmail(reservationDto.getEmail());
        reservation.setNumberOfTickets(reservationDto.getNumberOfTickets());
        reservation.setDate(reservationDto.getDate());
        return reservation;
    }
    public static ReservationDto toReservationDto(Reservation reservation)
    { ReservationDto reservationDto=new ReservationDto();
        reservationDto.setDate(reservation.getDate());
        reservationDto.setEmail(reservation.getEmail());
        reservationDto.setNumberOfTickets(reservation.getNumberOfTickets());
        return reservationDto;
    }
    public static List<ReservationDto> toReservationDtoList(List<Reservation> reservations)
    { List<ReservationDto> reservationsDto= new ArrayList<>();
        for(int i=0;i<reservations.size();i++)
        { ReservationDto reservationDto= toReservationDto(reservations.get(i));
            reservationsDto.add(reservationDto);
        }
        return reservationsDto;

    }

}
