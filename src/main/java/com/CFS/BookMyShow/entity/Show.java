package com.CFS.BookMyShow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_id" , nullable = false)
    private Screen screen;


    @Column(name = "show_date",nullable = false)
    private LocalDate showDate;

    @Column(nullable = false)
    private LocalTime  start_time;

    private LocalTime end_time;

    private double ticket_price;

}
