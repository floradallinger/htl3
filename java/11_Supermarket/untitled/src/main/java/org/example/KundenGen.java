package org.example;

import java.util.Queue;
import java.util.Random;

public class KundenGen extends Thread {
    private Queue<Kunde> queue;
    private Random rand = new Random();

    public KundenGen(Queue<Kunde> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Kunde kunde;
        try{
            while(!isInterrupted()) {
                kunde = Kunde.einkaufen();
                synchronized (queue) {
                    queue.offer(kunde);
                    queue.notifyAll();
                }
                Thread.sleep(rand.nextInt(100));
            }
        } catch (Exception ignore) {}
        System.out.println("Kundengenerierung wurde beendet");
    }
}