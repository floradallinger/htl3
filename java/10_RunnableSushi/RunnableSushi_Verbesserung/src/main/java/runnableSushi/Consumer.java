package runnableSushi;

import java.util.ArrayList;
import java.util.List;

public class Consumer extends Thread{

    private String name;
    private ConsumerType consumerType;
    private Belt belt;
    private int pos;
    private List<Food> foodList;
    private ConsumerPattern consumerBehav;

    /**
     * Constructor
     * @param consumerType the type of consumer
     * @param name the name of the consumer
     * @param belt the belt from which the consumer consumes food
     * @param pos the position on the belt from which the consumer consumes food
     */
    public Consumer(ConsumerType consumerType, String name, Belt belt, int pos) {
        this.consumerType = consumerType;
        this.name = name;
        this.belt = belt;
        this.pos = pos;
        foodList = new ArrayList<Food>();
        switch (consumerType) {
            case GUEST:
                consumerBehav = new CustomerBehaviour();
                break;
            case CLEANER:
                consumerBehav = new CleanerBehaviour();
                break;
        }
    }

    /**
     * Returns a string representation of all consumed food
     * @return a string representation of all consumed food
     */
    public String getConsumedFood() {
        StringBuilder sb = new StringBuilder();
        for (Food food : foodList) {
            sb.append(food.toString());
        }
        return sb.toString();
    }

    @Override
    public void run() {
        System.out.println("Consumer " + name + " started consuming at position " + pos);

        foodList = consumerBehav.consume(foodList, name, belt, pos);

    }
}
