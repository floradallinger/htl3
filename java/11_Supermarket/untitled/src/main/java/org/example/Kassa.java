package org.example;

import java.util.Queue;

public class Kassa extends Thread{
    public String name;
    public double saldo;
    public final Queue<Kunde> queue;

    public Kassa(Queue<Kunde> queue, String name) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Kassa " + name + " started");
        try{
            while(!isInterrupted()){
                synchronized (queue){
                    if(queue.isEmpty()){
                        queue.wait();
                        System.out.println("Waiting for customers...");
                    } else {
                        Kunde kunde = queue.poll();
                        saldo += kunde.getEinkaufswert();
                        System.out.println("Kassa " + name + "helped " + kunde.toString());
                    }
                }
                Thread.sleep(500);
            }
        }catch (InterruptedException ignore){
            while(!queue.isEmpty()){
                synchronized (queue){
                    Kunde kunde = queue.poll();
                    saldo += kunde.getEinkaufswert();
                    System.out.println("Kassa " + name + "helped " + kunde.toString());
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignore1) {}
            }
        }
        System.out.println("Kassa " + name + " finished with " + saldo);

    }

}
