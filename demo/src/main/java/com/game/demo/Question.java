package com.game.demo;

public class Question {

    private String correctAnswer;

    public Question() {

    }

    public String chooseQuestion(int questionId) {
        if (questionId == 1) {
            this.correctAnswer = "banana";
            return "Guess fruit: It's yellow and curved.";
        } else if (questionId == 2) {
            this.correctAnswer = "apple";
            return "Guess fruit: It's red and round.";
        } else {
            this.correctAnswer = "watermelon";
            return "Guess fruit: It's green and huge.";
        }
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
