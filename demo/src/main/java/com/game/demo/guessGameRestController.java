package com.game.demo;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class guessGameRestController {

    private Question currentQuestion; 

    //"Juuri endpointti" pyytää aloittamaan pelin
    @GetMapping("/")
    public String info() {
        return "Send GET-request /startgame to start game";
    }

    //Aloittaa pelin eli luodaan uusi objekti
    @GetMapping("/startgame")
    public String startGame() {
        currentQuestion = new Question(); 
        return "Game has started! Send GET-request /question to get question";
    }

    //Arvotaan kysymys kolmesta vaihtoehdosta ja tulostetaan se
    @GetMapping("/question")
    public String getQuestion() {

        if (currentQuestion == null) {
            return "Game has not started. Send a GET request to /startgame to start!";
        }
        Random random = new Random();
        int randInt = random.nextInt(3);
        return currentQuestion.chooseQuestion(randInt);
    }

    //Tarkistetaan onko vastaus oikea. Sitä ennen katsotaan onko peli aloitettu ja onko vastausta annettu
    @PostMapping("/answer/{id}")
    public String submitAnswer(@PathVariable String id) {
        if (currentQuestion == null) {
            return "Game has not started. Send a GET request to /startgame to start!";
        }

        if (id == null) {
            return "Please provide an answer.";
        }

        if (id.equals(currentQuestion.getCorrectAnswer())) {
            return "Correct! Well played.";
        } else {
            return "Wrong! The correct answer was: " + currentQuestion.getCorrectAnswer();
        }
    }

}