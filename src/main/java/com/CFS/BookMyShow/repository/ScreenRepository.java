package com.CFS.BookMyShow.repository;

import com.CFS.BookMyShow.entity.Screen;
import com.CFS.BookMyShow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen,Long> {
     List<Screen> findByTheaterId(Long theaterId);
}
