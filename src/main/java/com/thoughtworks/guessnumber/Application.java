package com.thoughtworks.guessnumber;

import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(1, Location.First));
        boxes.add(new Box(2, Location.Second));
        boxes.add(new Box(3, Location.Third));
        boxes.add(new Box(4, Location.Fourth));

        BoxContainer answer = new BoxContainer(boxes);
        GameConsole console = new GameConsole(answer);

        Set<Box> otherBoxes = new HashSet<>();
        otherBoxes.add(new Box(1, Location.First));
        otherBoxes.add(new Box(4, Location.Second));
        otherBoxes.add(new Box(5, Location.Third));
        otherBoxes.add(new Box(6, Location.Fourth));
        BoxContainer otherContainer = new BoxContainer(otherBoxes);

        String result = console.getAnswer(otherContainer);
        System.out.println(result);
    }
}
