package dev.walker.services;

import dev.walker.entities.Score;
import dev.walker.exceptions.ScoreNotFoundException;
import dev.walker.repos.ScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreRepo scoreRepo;

    @Override
    public Score registerScore(Score score) {
        Score savedScore = this.scoreRepo.save(score);
        return savedScore;
    }

    @Override
    public Score getScoreById(int id) {
        Optional<Score> possibleScore = this.scoreRepo.findById(id);
        if (possibleScore.isPresent()) {
            return possibleScore.get();
        }else {
            throw new ScoreNotFoundException();
        }

    }



    @Override
    public List<Score> getAllScores() {
        List<Score> scores = this.scoreRepo.findAll();
        return scores;
    }

    @Override
    public List<Score> getScoresByInitials(String initials) {
        return this.scoreRepo.findScoreByInitials(initials);
    }
}
