/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.renta.repository;


import com.usa.renta.model.Score;
import com.usa.renta.repository.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepo;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepo.findAll();
    }

    public Optional<Score> getScore (int id) {
        return scoreCrudRepo.findById(id);
    }

    public Score save(Score score){
        return scoreCrudRepo.save(score);
    }

    public void delete(Score score){
        scoreCrudRepo.delete(score);
    }
}
