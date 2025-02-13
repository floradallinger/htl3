package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public record Match(String Gruppe,
                    Integer Spieltag,
                    LocalDate Datum,
                    LocalTime Uhrzeit,
                    String Heimannschaft,
                    String Gastmannschaft,
                    Integer ToreHeim,
                    Integer ToreGast,
                    Integer ToreHeimHZ,
                    Integer ToreGastHZ){

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(Match.this.Datum + " " + Match.this.Uhrzeit + "\n")
                .append("----------------------\n")
                .append(Match.this.Heimannschaft + "-" + Match.this.Gastmannschaft + "\n")
                .append("Zwischenstand: " + Match.this.ToreHeimHZ + ":" + Match.this.ToreGastHZ + "\n")
                .append("Endstand: " + Match.this.ToreHeim + ":" + Match.this.ToreGast + "\n\n");

        return sb.toString();

    }

    public String getWinner(){
        Integer endStand = Match.this.ToreHeim - Match.this.ToreGast;
        if(endStand > 0){
            return Match.this.Heimannschaft;
        } else if (endStand < 0){
            return Match.this.Gastmannschaft;
        } else {
            return "unentschieden";
        }
    }
}