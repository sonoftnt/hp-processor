package com.tnt.hp.Repository;

import com.tnt.hp.Entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends MongoRepository<Event,String> {
}
