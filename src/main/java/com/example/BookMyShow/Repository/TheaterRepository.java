package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {

    TheaterEntity findByNameAndCity(String name,String city);
}
