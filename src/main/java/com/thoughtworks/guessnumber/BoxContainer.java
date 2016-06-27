package com.thoughtworks.guessnumber;

import java.util.HashSet;
import java.util.Set;

class BoxContainer {
    private Set<Box> boxes;

    BoxContainer(String numbersString) {
        String[] numbers = numbersString.split(" ");
        int firstNumber = Integer.parseInt(numbers[0]);
        int secondNumber = Integer.parseInt(numbers[1]);
        int thirdNumber = Integer.parseInt(numbers[2]);
        int fourthNumber = Integer.parseInt(numbers[3]);

        Set<Box> newBoxes = new HashSet<>();
        newBoxes.add(new Box(firstNumber, Location.First));
        newBoxes.add(new Box(secondNumber, Location.Second));
        newBoxes.add(new Box(thirdNumber, Location.Third));
        newBoxes.add(new Box(fourthNumber, Location.Fourth));
        this.boxes = newBoxes;
    }

    Set<Box> getBoxes() {
        return boxes;
    }

    String getResult(BoxContainer otherContainer) {

        int aCount = 0;
        int bCount = 0;

        Set<Box> otherBoxes = otherContainer.getBoxes();
        for (Box box : boxes) {
            for (Box otherBox : otherBoxes) {
                if (box.getNumber() == otherBox.getNumber()
                        && box.getLocation() == otherBox.getLocation()) {
                    aCount++;
                } else if (box.getNumber() == otherBox.getNumber()) {
                    bCount++;
                }
            }
        }

        return aCount + "A" + bCount + "B";
    }
}
