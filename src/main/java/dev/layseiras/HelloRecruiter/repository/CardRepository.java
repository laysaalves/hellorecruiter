package dev.layseiras.HelloRecruiter.repository;

import dev.layseiras.HelloRecruiter.model.tracker.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
