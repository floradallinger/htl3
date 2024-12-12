package runnableSushi;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread {

    private String name;
    private FoodType foodType;
    private final Belt belt;
    private int pos;
    private List<Food> producedFood;

    private int lastFoodIndex = 1;

    /**
     * Constructor
     * @param name name of the producer
     * @param foodType type of food produced
     * @param belt belt to place the food on
     * @param pos position on the belt to place the food
     */
    public Producer (String name, FoodType foodType, Belt belt, int pos) {
        this.name = name;
        this.foodType = foodType;
        this.belt = belt;
        this.pos = pos;
        this.producedFood = new ArrayList<Food>();
    }

    /**
     * Returns a string representation of all produced food
     * @return a string representation of all produced food
     */
    public String getProducedFood() {
        StringBuilder sb = new StringBuilder();
        for (Food food : producedFood) {
            sb.append(food.toString() + "| ");
        }
        return sb.toString();
    }

    @Override
    public void run(){

        System.out.println("Producer " + name + " starts producing at position " + pos);
        try {
            while (!isInterrupted()) {
                String id = String.format("%s-%d", this.name, lastFoodIndex++);
                Food f = new Food(id, foodType);

                synchronized (belt) {
                    if (!belt.isFreeAtPosition(pos)) {
                        belt.wait();
                        System.out.println("Producer " + name + " waits for free at position " + pos);
                    } else {
                        System.out.println(name + " placed " + id + " at position " + pos);
                        belt.add(f, pos);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException ignore) {}

        System.out.println("Producer " + name + "produced: " + getProducedFood());
    }
}
