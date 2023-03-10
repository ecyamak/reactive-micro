package com.ecy.secondservice.repository;

import com.ecy.secondservice.entity.SecondEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SecondRespository extends ReactiveMongoRepository<SecondEntity, String> {

}
