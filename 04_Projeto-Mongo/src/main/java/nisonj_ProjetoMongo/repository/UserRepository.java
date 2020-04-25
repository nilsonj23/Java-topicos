package nisonj_ProjetoMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nisonj_ProjetoMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}