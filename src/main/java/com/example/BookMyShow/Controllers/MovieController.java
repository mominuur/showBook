package com.example.BookMyShow.Controllers;


import com.example.BookMyShow.Dtos.MovieRequestDto;
import com.example.BookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public String addMovie(@RequestBody MovieRequestDto movieRequestDto){

        return movieService.addMovie(movieRequestDto);
    }




    //Get movie by Name
}
