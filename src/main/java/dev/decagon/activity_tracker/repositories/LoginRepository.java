package dev.decagon.activity_tracker.repositories;

import dev.decagon.activity_tracker.models.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login,Long> {
    Optional<Login> findByEmailAndPassword(String email, String password);
}
