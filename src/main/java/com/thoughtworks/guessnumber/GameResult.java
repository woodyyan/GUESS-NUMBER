package com.thoughtworks.guessnumber;

class GameResult {

    private MessageType messageType;
    private int numberCorrectCount;
    private int locationCorrectCount;

    void setNumberCorrectCount(int numberCorrectCount) {
        this.numberCorrectCount = numberCorrectCount;
    }

    void setLocationCorrectCount(int locationCorrectCount) {
        this.locationCorrectCount = locationCorrectCount;
    }

    MessageType getMessageType() {
        return messageType;
    }

    void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        String result = "";
        switch (messageType) {
            case Success:
                result = "Successful!";
                break;
            case Failed:
                result = "Failed!";
                break;
            case Pending:
                result = numberCorrectCount + "A" + locationCorrectCount + "B";
                break;
        }
        return result;
    }
}