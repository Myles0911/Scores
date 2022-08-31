package dev.walker;

import dev.walker.app.HiScoresApplication;
import dev.walker.entities.Score;
import dev.walker.repos.ScoreRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = HiScoresApplication.class)
public class ScoreRepoTests {

    @Autowired
    ScoreRepo scoreRepo;

    @Test
    public void creates_scores() {
        Score score = new Score(110, "CCC", 2000);
        Score savedScore = this.scoreRepo.save(score);
        System.out.println(savedScore);
        Assertions.assertNotEquals(110, savedScore.getId());

    }

    @Test
    public void get_score_by_id() {
        Score score = this.scoreRepo.findById(105).get();
        System.out.println(score);
    }

    @Test
    public void get_all_scores() {
        List<Score> scores = this.scoreRepo.findAll();
        System.out.println(scores);
    }

    @Test
    public void get_scores_by_initials() {
        List<Score> getInitial = this.scoreRepo.findScoreByInitials("BBB");
        System.out.println(getInitial);
    }

    @Test
    public void update_Score() {
        Score replaceScore = new Score(559, "DDD", 2000);
        this.scoreRepo.save(replaceScore);
    }

    @Test
    public void delete_Score() {
    Score deleteScore = this.scoreRepo.deleteAllById(105);
    }
}
