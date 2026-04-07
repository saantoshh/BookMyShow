package com.CFS.BookMyShow.repository;

import com.CFS.BookMyShow.entity.Booking;
import com.CFS.BookMyShow.entity.City;
import com.CFS.BookMyShow.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByUserId(Long useId);
    List<Booking> getBookingByUser(Long userId);
    List<Booking> findByShowId(Long showId);

    //find all seat ids that are already booked for given show

//    @Query("SELECT s.id FROM Booking b JOIN b.seat s WHERE b.show.id=:showId AND b.status='CONFIRMED'")
//    List<Long> findBookSeatIdsByShowId(@Param("showId")  Long showId);

    @Query("SELECT s.id FROM Booking b JOIN b.seats s WHERE b.show.id=:showId AND b.status='CONFIRMED'")
    List<Long> findBookedSeatIdsByShowId(@Param("showId") Long showId);

}
