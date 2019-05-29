package controller;

import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInputController {
    private Encoder encoder;
    private Decoder decoder;
    private Scanner inputScanner = new Scanner(System.in);  // Create a Scanner object

    public UserInputController() {
        IOController ioController = new IOController();
        Integer key = getKey();
        encoder = new Encoder(key);
        decoder = new Decoder(key);
        String path = getPath();
        String oPath = getOutput();
        Integer mode = getMode();
        if (mode.equals(1))
            ioController.writeToOutput(oPath, ioController.readInputFile(path).stream().map(line -> encoder.encodeLine(line)).collect(Collectors.toList()));
        else if (mode.equals(2))
            ioController.writeToOutput(oPath, ioController.readInputFile(path).stream().map(line -> decoder.decodeLine(line)).collect(Collectors.toList()));
    }

    private String getPath() {
        System.out.println("Enter Filename:");
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
