package com.CFS.BookMyShow.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "screens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;   //AUDI-1  , AUDI2

    private Integer total_seats;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "theater_id",nullable = false)
    private Theater theater;
}
