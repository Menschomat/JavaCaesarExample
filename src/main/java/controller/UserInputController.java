package controller;

import controller.encoding.AdvancedEncoder;
import controller.encoding.Encoder;
import controller.io.IOController;

import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInputController {
    private Encoder encoder = new AdvancedEncoder();
    private Scanner inputScanner = new Scanner(System.in);  // Create a Scanner object

    public UserInputController() {
        IOController ioController = new IOController();
        Integer mode = getMode();
        if (mode.equals(1)){
            encoder.setKey(getKey());
            ioController.writeToOutput(getOutput(), ioController.readInputFile(getPath()).stream().map(line -> encoder.encodeLine(line)).collect(Collectors.toList()));}
        else if (mode.equals(2)){
            encoder.setKey(getKey()*(-1)); // For Decoding we want to shift the Letters in the opposite direction. That's why we make our key negative.
            ioController.writeToOutput(getOutput(), ioController.readInputFile(getPath()).stream().map(line -> encoder.encodeLine(line)).collect(Collectors.toList()));}
    }

    private String getPath() {
        System.out.println("Enter Inputfile:");
        return inputScanner.next();
    }
    private String getOutput() {
        System.out.println("Enter Ouptupfile:");
        return inputScanner.next();
    }

    private Integer getKey() {
        System.out.println("Enter Key:");
        Integer keyCandidate = inputScanner.nextInt();
        if(keyCandidate>26)
            return getKey();
        return keyCandidate;
    }

    private Integer getMode() {
        System.out.println("Enter Mode:");
        System.out.println("    Type 1 for Encode");
        System.out.println("    Type 2 for Decode");
        return inputScanner.nextInt();
    }
}
