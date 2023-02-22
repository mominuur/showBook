package com.example.BookMyShow.Service;


import com.example.BookMyShow.Dtos.TheaterRequestDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Models.TheaterEntity;
import com.example.BookMyShow.Models.TheaterSeatEntity;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public String createTheater(TheaterRequestDto theaterRequestDto){


        TheaterEntity theater = TheaterEntity.builder().city(theaterRequestDto.getCity()).name(theaterRequestDto.getName()).address(theaterRequestDto.getAddress()).build();

        List<TheaterSeatEntity> theaterSeats = createTheaterSeats();


        theater.setTheaterSeatEntityList(theaterSeats); //Bidirectional mapping


        //For each theater Seat : we need to set the theaterEntity
        for(TheaterSeatEntity theaterSeat : theaterSeats){
            theaterSeat.setTheater(theater);
        }

        theaterRepository.save(theater);

        return "Theater added successfully";

    }

    private List<TheaterSeatEntity> createTheaterSeats(){


        List<TheaterSeatEntity> seats = new ArrayList<>();
//
//        TheaterSeatEntity theaterSeat1 = new TheaterSeatEntity("1A", SeatType.CLASSIC,100);
//        TheaterSeatEntity theaterSeat2 = new TheaterSeatEntity("1B", SeatType.CLASSIC,100);
//        TheaterSeatEntity theaterSeat3 = new TheaterSeatEntity("1C", SeatType.CLASSIC,100);
//        TheaterSeatEntity theaterSeat4 = new TheaterSeatEntity("1D", SeatType.CLASSIC,100);
//        TheaterSeatEntity theaterSeat5 = new TheaterSeatEntity("1E", SeatType.CLASSIC,100);

        //Optimize by adding loop

        for(int i=0;i<5;i++){

            char ch = (char)('A'+i);

            String seatNo  = "1"+ ch;
            TheaterSeatEntity theaterSeat = new TheaterSeatEntity(seatNo,SeatType.CLASSIC,100);
            seats.add(theaterSeat);
        }
        for(int i=0;i<5;i++){
            char ch = (char)('A'+i);
            String seatNo  = "2"+ ch;
            TheaterSeatEntity theaterSeat = new TheaterSeatEntity(seatNo,SeatType.PLATINUM,200);
            seats.add(theaterSeat);
        }


        theaterSeatRepository.saveAll(seats);

        return seats;

    }



}