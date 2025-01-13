package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Kunde> queue = new LinkedList<Kunde>();

        KundenGen kundenGen = new KundenGen(queue);
        kundenGen.start();
        Kassa kassa = new Kassa(queue, "Kassa1");
        Kassa kassa2 = new Kassa(queue, "Kassa2");
        kassa.start();
        kassa2.start();

        try {
            Thread.sleep(5000);
            kundenGen.interrupt();
            kassa.interrupt();
            kassa2.interrupt();

            kundenGen.join();
            kassa.join();
            kassa2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}