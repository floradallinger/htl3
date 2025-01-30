package org.example;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Path fileName = Paths.get("./bundesliga_23_24.csv");


        List<Match> matches = FileReader.readMatchesFromFile(fileName);

        /*for(Match m: matches){
            System.out.println(m.toString());
        }*/

        String lieblingsVereinOderSo = "LASK";

        System.out.println("Alle Spiele \n");
        matches.stream()
                .filter(m -> Objects.equals(m.Gastmannschaft(), lieblingsVereinOderSo) || Objects.equals(m.Heimannschaft(), lieblingsVereinOderSo))
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------");

        System.out.println("Alle Spiele in der Gesamtgruppe \n");
        matches.stream()
                .filter(m -> Objects.equals(m.Gastmannschaft(), lieblingsVereinOderSo) || Objects.equals(m.Heimannschaft(), lieblingsVereinOderSo))
                .filter(m -> Objects.equals(m.Gruppe(), "Gesamtgruppe"))
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------");
        System.out.println("Meistergruppe? \n");
        matches.stream()
                .limit(1)
                .filter(m -> Objects.equals(m.Gastmannschaft(), lieblingsVereinOderSo) || Objects.equals(m.Heimannschaft(), lieblingsVereinOderSo))
                .filter(m -> Objects.equals(m.Gruppe(), "Meistergruppe"))
                .forEach(System.out::println);

    }
}