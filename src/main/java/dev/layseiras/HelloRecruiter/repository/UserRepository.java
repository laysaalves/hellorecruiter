package dev.layseiras.HelloRecruiter.repository;

import dev.layseiras.HelloRecruiter.model.tracker.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
