package runnableSushi;

public class RunnableSushi {

    public static void main(String[] args) {
        System.out.println("Runnable Sushi opens ...");

        // Create and start belt
        Belt belt = new Belt(12);
        belt.start();

        // Create and start cooks
        Producer cook1 = new Producer("S", FoodType.SUSHI, belt, 1);
        Producer cook2 = new Producer("A", FoodType.APPETIZER, belt, 2);
        cook1.start();
        cook2.start();

        // Create and start guests
        Consumer guest1 = new Consumer(ConsumerType.GUEST, "Ann", belt, 3);
        Consumer guest2 = new Consumer(ConsumerType.GUEST, "Bob", belt, 5);
        Consumer guest3 = new Consumer(ConsumerType.GUEST, "Joe", belt, 7);

        guest1.start();
        guest2.start();
        guest3.start();

        // Wait until the Runnable Sushi has to close
        try {
            Thread.sleep(5000);
        // Stop the cooks
            cook1.interrupt();
            cook2.interrupt();
        // Stop the guests
            guest1.interrupt();
            guest2.interrupt();
            guest3.interrupt();
        // Clean the belt
            cook1.join();
            cook2.join();
            guest1.join();
            guest2.join();
            guest3.join();
            Consumer cleaner1 = new Consumer(ConsumerType.CLEANER, "Cleaner1", belt, 0);
            cleaner1.start();
            while(!belt.isEmpty()) {
                Thread.sleep(5000);
            }

            cleaner1.interrupt();
            cleaner1.join();
            belt.interrupt();
            belt.join();


        // Stop the belt

        // Close Runnable Sushi
            System.out.println("Runnable Sushi has finished");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
