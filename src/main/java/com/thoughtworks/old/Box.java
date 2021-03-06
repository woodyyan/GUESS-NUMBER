package com.thoughtworks.old;

class Box {

    private int number;
    private Location location;

    int getNumber() {
        return number;
    }

    Location getLocation() {
        return location;
    }

    Box(int number, Location location) {
        this.number = number;
        this.location = location;
    }

    CompareResult Compare(Box box) {
        CompareResult result = CompareResult.None;
        if (number == box.number && location == box.location) {
            result = CompareResult.NumberAndLocation;
        } else if (number == box.number) {
            result = CompareResult.NumberOnly;
        }

        return result;
    }
}
