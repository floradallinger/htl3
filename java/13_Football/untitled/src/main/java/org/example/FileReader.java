package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.format.DateTimeFormatter.ofPattern;

public class FileReader {
    public static List<Match> readMatchesFromFile(Path filePath) {
        List<Match> matches = new ArrayList<Match>();
        try {
            List<String> file = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            for (int i = 1; i < file.size(); i++) {
                matches.add(processLine(file.get(i)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return matches;
    }

    private static Match processLine(String line) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            Match match =  new Match(
                    line.split(",")[0],
                    Integer.parseInt(line.split(",")[1]),
                    LocalDate.parse((line.split(",")[2]), dateFormatter),
                    LocalTime.parse(line.split(",")[3]),
                    line.split(",")[4],
                    line.split(",")[5],
                    Integer.parseInt(line.split(",")[6]),
                    Integer.parseInt(line.split(",")[7]),
                    Integer.parseInt(line.split(",")[8]),
                    Integer.parseInt(line.split(",")[9]));

            return match;


    }

}
