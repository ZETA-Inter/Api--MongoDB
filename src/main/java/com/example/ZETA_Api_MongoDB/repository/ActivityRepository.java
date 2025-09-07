package com.example.ZETA_Api_MongoDB.repository;

import com.example.ZETA_Api_MongoDB.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityRepository extends MongoRepository<Activity, Integer> {

}
