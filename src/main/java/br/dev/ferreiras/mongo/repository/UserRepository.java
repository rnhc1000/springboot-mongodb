package br.dev.ferreiras.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.dev.ferreiras.mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
