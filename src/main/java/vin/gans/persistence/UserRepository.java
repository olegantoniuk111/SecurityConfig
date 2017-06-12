package vin.gans.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import vin.gans.domain.User;

import java.util.List;

public interface UserRepository extends MongoRepository <User, String>{

    @Query("{'username':?0}")
    public User findByUserName(String userName);

    @Query("{'email':?0}")
    public User findByEmail(String email);
}
