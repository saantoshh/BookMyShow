package com.CFS.BookMyShow.entity;

import com.CFS.BookMyShow.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String seat_number;

    @Column(name = "seat_row")
    private String rows;        //A,B,D,K

    @Column(name = "seat_col")
    private Integer columns;      //1,2,4,5

    @Enumerated(EnumType.STRING)
    private SeatType  seat_type;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

}
