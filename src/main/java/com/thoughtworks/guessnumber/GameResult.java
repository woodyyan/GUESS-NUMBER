package com.thoughtworks.guessnumber;

class GameResult {

    private int numberCorrectCount;
    private int locationCorrectCount;
    private boolean isSuccessful;

    GameResult(boolean isSuccessful, Integer numberCorrectCount, Integer locationCorrectCount) {
        this.isSuccessful = isSuccessful;
        this.numberCorrectCount = numberCorrectCount;
        this.locationCorrectCount = locationCorrectCount;
    }

    boolean getIsSuccessful() {
        return isSuccessful;
    }

    String getMessage() {
        return numberCorrectCount + "A" + locationCorrectCount + "B";
    }
}