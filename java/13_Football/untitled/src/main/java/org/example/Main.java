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

        String fussballVerein = "LASK";

        System.out.println("Alle Spiele \n");
        matches.stream()
                .filter(m -> Objects.equals(m.Gastmannschaft(), fussballVerein) || Objects.equals(m.Heimannschaft(), fussballVerein))
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------");

        System.out.println("Alle Spiele in der Gesamtgruppe \n");
        matches.stream()
                .filter(m -> Objects.equals(m.Gastmannschaft(), fussballVerein) || Objects.equals(m.Heimannschaft(), fussballVerein))
                .filter(m -> Objects.equals(m.Gruppe(), "Gesamtgruppe"))
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------");
        System.out.println("Meistergruppe? \n");
        boolean inMasterGroup = matches.stream()
                .filter(m -> Objects.equals(m.Gastmannschaft(), fussballVerein) || Objects.equals(m.Heimannschaft(), fussballVerein))
                .allMatch(m -> Objects.equals(m.Gruppe(), "Meistergruppe"));
        System.out.println(inMasterGroup);

        System.out.println("---------------------------------------------------");
        System.out.println("Gewonnene Spiele in der Gesamtgruppe: \n");
        Long wonGamesGesGruppe = matches.stream()
                .filter(m -> (Objects.equals(m.Gastmannschaft(), fussballVerein)  || Objects.equals(m.Heimannschaft(), fussballVerein)) && Objects.equals(m.getWinner(), fussballVerein))
                .filter(m -> Objects.equals(m.Gruppe(), "Gesamtgruppe"))
                .count();
        System.out.println(wonGamesGesGruppe);

        System.out.println("---------------------------------------------------");
        System.out.println("Unentschieden gespielte Spiele in der Gesamtgruppe: \n");
        Long equalGames = matches.stream()
                .filter(m -> (Objects.equals(m.Gastmannschaft(), fussballVerein)  || Objects.equals(m.Heimannschaft(), fussballVerein)) && Objects.equals(m.getWinner(), "unentschieden"))
                .filter(m -> Objects.equals(m.Gruppe(), "Gesamtgruppe"))
                .count();
        System.out.println(equalGames);

        System.out.println("\n---------------------------------------------------");
        System.out.println("0:0 Spiele:\n");
        matches.stream()
                .filter(m -> Objects.equals(m.Gastmannschaft(), fussballVerein) || Objects.equals(m.Heimannschaft(), fussballVerein))
                .filter(m -> m.ToreGast() == 0 && m.ToreHeim() == 0)
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------");
        System.out.println("Gewonnene Spiele generell: \n");
        Long wonGames = matches.stream()
                .filter(m -> (Objects.equals(m.Gastmannschaft(), fussballVerein)  || Objects.equals(m.Heimannschaft(), fussballVerein)) && Objects.equals(m.getWinner(), fussballVerein))
                .count();
        System.out.println(wonGames);

        System.out.println("---------------------------------------------------");
        System.out.println("Insgesamte Tore: \n");
        Long toreInsg = matches.stream()
                .filter(m -> Objects.equals(m.Gastmannschaft(), fussballVerein) ||
                        Objects.equals(m.Heimannschaft(), fussballVerein))
                .mapToLong(m -> Objects.equals(m.Heimannschaft(), fussballVerein) ? m.ToreHeim() : m.ToreGast())
                .sum();
        System.out.println(toreInsg);

    }
}