package com.nit.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.entity.mongo.CustomerMongo;

public interface CustomerMongoRepo extends MongoRepository<CustomerMongo, String>{

}
