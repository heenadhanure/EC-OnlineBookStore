package com.nit.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.entity.mongo.BookMongo;

public interface BookMongoRepo extends MongoRepository<BookMongo, Long>{

}
