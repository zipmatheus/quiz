package org.senai.prjquiz.repository;

import org.senai.prjquiz.entity.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz,Integer>{
    
}
