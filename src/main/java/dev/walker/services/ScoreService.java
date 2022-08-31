package dev.walker.services;

import dev.walker.entities.Score;

import java.util.List;

public interface ScoreService {

    Score registerScore(Score score);
    Score getScoreById(int id);
    List<Score> getAllScores();
    List<Score> getScoresByInitials(String initials);
}
