package dev.walker.repos;

import dev.walker.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepo extends JpaRepository<Score, Integer> {

    List<Score> findScoreByInitials(String initials);

    Score deleteAllById(int id);
}
