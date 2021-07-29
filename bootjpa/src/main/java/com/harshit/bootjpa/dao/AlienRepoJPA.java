package com.harshit.bootjpa.dao;

import com.harshit.bootjpa.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlienRepoJPA extends JpaRepository<Alien, Integer> {

//    List<Alien> jpafindByTech(String tech);
//
//    List<Alien> jpafindByAlienidGreaterThanEqual(int aid);
//
//    @Query("from Alien where tech=?1 order by aname")
//    List<Alien> jpafindByTechSorted(String tech);

}
