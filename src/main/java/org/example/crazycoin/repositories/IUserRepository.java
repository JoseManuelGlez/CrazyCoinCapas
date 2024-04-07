package org.example.crazycoin.repositories;

import org.example.crazycoin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    User findUserById(String userId);
}
