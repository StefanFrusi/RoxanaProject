package solo.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.testproject.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    List<Reservation> findByActivityIdAndDate(Integer id, LocalDate date);
}
