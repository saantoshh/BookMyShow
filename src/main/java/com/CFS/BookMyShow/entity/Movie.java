package com.CFS.BookMyShow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String description;
    private String genre;
    private String language;

    private Integer duration_minutes;
    private Double rating;
    private LocalDate release_date;
    private String poster_url;
}
