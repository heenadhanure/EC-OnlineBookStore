package com.nit.repository.mongo;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.entity.mongo.UserRegisterMongo;

@Repository
public interface UserRegisterMongoRepo extends MongoRepository<UserRegisterMongo, String>{

}
