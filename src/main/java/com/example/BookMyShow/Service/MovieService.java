package com.example.BookMyShow.Service;


import com.example.BookMyShow.Dtos.MovieRequestDto;
import com.example.BookMyShow.Models.MovieEntity;
import com.example.BookMyShow.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieRequestDto movieRequestDto){

        //Convert Dto to Entity layer for saving it to the Database.
        MovieEntity movie = MovieEntity.builder().movieName(movieRequestDto.getName()).duration(movieRequestDto.getDuration()).releaseDate(movieRequestDto.getReleaseDate()).build();
        //movie.setListOfShows();
        movieRepository.save(movie);

        return "Movie Added successfully";
    }


}
