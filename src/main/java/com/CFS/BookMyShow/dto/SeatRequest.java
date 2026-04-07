package com.CFS.BookMyShow.dto;

import com.CFS.BookMyShow.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequest {
    private String seatNumber;
    private String row;
    private String column;
    private SeatType seatType;
    private Long screenId;

}
