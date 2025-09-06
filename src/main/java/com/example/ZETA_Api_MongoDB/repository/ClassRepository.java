package com.example.ZETA_Api_MongoDB.repository;

import com.example.ZETA_Api_MongoDB.model.Class;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassRepository extends MongoRepository<Class, Integer> {

    Class findByTitle(String title);

}
