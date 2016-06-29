package com.thoughtworks.guessnumber;

class GameResult {

    private int numberCorrectCount;
    private int locationCorrectCount;

    private boolean isSuccessful;

    boolean getIsSuccessful() {
        return isSuccessful;
    }

    void setIsSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    void setNumberCorrectCount(int numberCorrectCount) {
        this.numberCorrectCount = numberCorrectCount;
    }

    void setLocationCorrectCount(int locationCorrectCount) {
        this.locationCorrectCount = locationCorrectCount;
    }

    String getMessage() {
        return numberCorrectCount + "A" + locationCorrectCount + "B";
    }
}