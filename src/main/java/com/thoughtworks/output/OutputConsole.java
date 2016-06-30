package com.thoughtworks.output;

public class OutputConsole {

    private OutputConsole() {
    }

    private static OutputConsole single = null;

    public static OutputConsole getInstance() {
        if (single == null) {
            single = new OutputConsole();
        }
        return single;
    }

    public void println(String message) {
        System.out.println(message);
    }
}
