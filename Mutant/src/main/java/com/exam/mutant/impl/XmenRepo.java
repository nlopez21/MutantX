package com.exam.mutant.impl;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exam.mutant.model.Stats;


@Repository
public interface XmenRepo extends MongoRepository<Stats, String> {

}
