package com.thoughtworks.input;

import java.util.Scanner;

public class InputConsole {
    public String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
