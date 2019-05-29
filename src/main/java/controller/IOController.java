package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IOController {

    IOController() {
    }

    List<String> readInputFile(String path) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<String>();
    }

    void writeToOutput(String path, List<String> toWrite) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
            toWrite.forEach(a -> {
                try {
                    writer.write(a);
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
