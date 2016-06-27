package com.thoughtworks.guessnumber;

class GameConsole {

    private final BoxContainer boxContainer;

    GameConsole(BoxContainer boxContainer) {
        this.boxContainer = boxContainer;
    }

    public String getAnswer(BoxContainer boxContainer) {
        String result = this.boxContainer.getResult(boxContainer);

        return result;
    }
}
