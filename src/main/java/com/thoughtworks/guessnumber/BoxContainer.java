package com.thoughtworks.guessnumber;

import java.util.Set;

public class BoxContainer {
    private Set<Box> boxes;

    public BoxContainer(Set<Box> boxes) {

        this.boxes = boxes;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public String getResult(BoxContainer otherContainer) {

        int aCount = 0;
        int bCount = 0;

        Set<Box> otherBoxes = otherContainer.getBoxes();
        for (Box box : boxes) {
            for (Box otherBox : otherBoxes) {
                if (box.getNumber() == otherBox.getNumber() && box.getLocation() == otherBox.getLocation()) {
                    aCount++;
                } else if (box.getNumber() == otherBox.getNumber()) {
                    bCount++;
                }
            }
        }

        String result = aCount + "A" + bCount + "B";

        return result;
    }
}
