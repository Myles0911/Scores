package dev.walker.controllers;

import dev.walker.entities.Score;
import dev.walker.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Controller
public class ScoreController {
    //Logger logger = LogManager.getLogManager().getLogger(ScoreController.class);

    @Autowired
    ScoreService scoreService;


    @GetMapping("/scores")
    @ResponseBody
    public List<Score> allScores(@RequestParam(required = false) String initials) {
        if(initials == null) {
            return scoreService.getAllScores();
        } else {
            return scoreService.getScoresByInitials(initials);
        }
    }

    @GetMapping("/scores/{id}")
    @ResponseBody
    public Score getScoreById(@PathVariable String id) {
        int scoreId = Integer.parseInt(id);
        return scoreService.getScoreById(scoreId);

    }
    @PostMapping("/scores")
    @ResponseBody
    public ResponseEntity<Score> createScore(@RequestBody Score body) {
    Score savedScore = this.scoreService.registerScore(body);
    return new ResponseEntity<Score>(savedScore, HttpStatus.CREATED);
    }

}


