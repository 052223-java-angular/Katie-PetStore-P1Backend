package com.revature.katieskritters.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.katieskritters.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUserId(String user_id);

    Optional<User> isUsernameValid(String username);

    Optional<User> isPasswordValid(String password);

    Optional<User> isConfirmPasswordSame(String confirmedPassword);
}
