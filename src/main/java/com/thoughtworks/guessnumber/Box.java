package com.thoughtworks.guessnumber;

class Box {

    private int number;
    private Location location;

    public int getNumber() {
        return number;
    }

    public Location getLocation() {
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
