package com.CFS.BookMyShow.repository;

import com.CFS.BookMyShow.entity.Seat;
import com.CFS.BookMyShow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Long> {
     List<Seat>  findByScreenId(Long screenIid);
}
