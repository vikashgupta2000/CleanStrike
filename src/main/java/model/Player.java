package model;

import constants.Carrom;

/**
 * Created by vikashgupta on 30/09/18.
 */
public class Player {
    private String name;
    private int score;
    private int foulCount;
    private int consecutiveMissedPocket;
    private int totalBlackCoinPocketed;
    private boolean redCoinPocketed;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    private void addScore(int score) {
        this.score += score;
    }

    private void reduceScore(int score) {
        this.score -= score;
        if (this.score < 0) {
            this.score = 0;
        }
    }

    private void resetFoulCount() {
        this.foulCount = 0;
    }

    public void foulPlay(int pointToLoose) {
        this.reduceScore(pointToLoose);
        ++this.foulCount;
    }

    public void incrementMissedPocketCounter() {
        ++this.consecutiveMissedPocket;
    }

    private void resetConsecutiveMissedPocketCounter() {
        this.consecutiveMissedPocket = 0;
    }

    public int getTotalBlackCoinPocketed() {
        return this.totalBlackCoinPocketed;
    }

    public void setBlackCoinPocketed() {
        ++this.totalBlackCoinPocketed;
    }

    private void resetBlackCoinPocketed () {
        this.totalBlackCoinPocketed = 0;
    }

    public boolean getRedCoinPocketed() {
        return this.redCoinPocketed;
    }

    public void setRedCoinPocketed() {
        this.redCoinPocketed = true;
    }

    private void resetRedCoinPocketed() {
        this.redCoinPocketed = false;
    }

    public void calculateScore () {
        if (redCoinPocketed) {
            addScore(Carrom.RED_COIN_VALUE);
            this.resetRedCoinPocketed();
            this.resetConsecutiveMissedPocketCounter();
        }
        if (this.totalBlackCoinPocketed > 0) {
            if(this.totalBlackCoinPocketed == 1) {
                addScore(Carrom.SINGLE_BLACK_COIN_VALUE);
            } else {
                addScore(Carrom.MULTI_BLACK_COIN_VALUE);
            }
            this.resetBlackCoinPocketed();
            this.resetConsecutiveMissedPocketCounter();
        } else if (consecutiveMissedPocket == 3) {
            reduceScore(Carrom.CONSECUTIVE_COIN_FAILURE);
            resetConsecutiveMissedPocketCounter();
        } else if (foulCount == 3) {
            reduceScore(Carrom.FOUL);
            resetFoulCount();
        }
    }
}
