package com.tse;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        App app = new App();
            app.resolve("inputFile", 3, "outputFile");
    }

    public boolean resolve(String fileName, int month, String outputFileName) {
        URL path = this.getClass().getClassLoader().getResource(fileName);
        File newFile = new File(outputFileName);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            List<String> result = Files.newBufferedReader(Paths.get(path.toURI())).lines()
                    .filter(line -> Integer.parseInt(line.split(" ")[2].split("-")[1]) == month)
                    .map(line -> line.split(" ")[0] + " " +line.split(" ")[1])
                    .sorted()
                    .collect(Collectors.toList());

            try (PrintWriter pw = new PrintWriter(
                    Files.newBufferedWriter(Paths.get(newFile.getName())))) {
                Stream.of(result.toString()).forEach(pw::println);
                return true;
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }



}


