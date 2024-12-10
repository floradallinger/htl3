package runnableSushi;

import java.util.List;

public class Producer extends Thread {

    private String name;
    private FoodType foodType;
    private Belt belt;
    private int pos;
    private List<Food> producedFood;

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
    }

    /**
     * Returns a string representation of all produced food
     * @return a string representation of all produced food
     */
    public String getProducedFood() {
        StringBuilder sb = new StringBuilder();
        for (Food food : producedFood) {
            sb.append(food.toString());
        }
        return sb.toString();
    }

    @Override
    public void run(){

    }
}
