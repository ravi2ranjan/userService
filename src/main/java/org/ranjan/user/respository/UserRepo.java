package org.ranjan.user.respository;

import org.ranjan.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "select id, name, email,about from user_details where name=:name")
    public List<User> getUserByName(@Param("name") String name);
}
