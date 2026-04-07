package com.CFS.BookMyShow.entity;

import com.CFS.BookMyShow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id",nullable = false)
    private Show show;

    @ManyToMany
    @JoinTable(
            name = "booking_seats",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )

    private List<Seat> seats;

    private Double total_price;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private LocalDateTime booked_at;


    @PrePersist
    private void onCreate() {
        this.booked_at = LocalDateTime.now();
        if (this.status==null){
            this.status=BookingStatus.CONFORMED;
        }
    }


}
