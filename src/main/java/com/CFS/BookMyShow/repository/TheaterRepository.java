package com.CFS.BookMyShow.repository;

import com.CFS.BookMyShow.entity.Theater;
import com.CFS.BookMyShow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater,Long> {
     List<Theater> findByCityId(Long id);

     Theater findCityByName(String name); ////
}
