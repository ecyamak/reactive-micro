package com.ecy.firstservice.repository;

import com.ecy.firstservice.entities.FirstEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FirstRepository extends ReactiveMongoRepository<FirstEntity, String> {

}
