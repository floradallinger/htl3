package runnableSushi;

import java.util.List;

public class CustomerBehaviour implements ConsumerPattern{
    @Override
    public List<Food> consume(List<Food> foodList, String name, Belt belt, int pos) {
        try{
            while(!Thread.interrupted()){
                Thread.sleep((long)(Math.random()*5000));
                synchronized(belt){
                    if(belt.isFreeAtPosition(pos)){
                        belt.wait();
                        System.out.println("Customer is waiting for food");
                    } else{
                        Food takenFood = belt.remove(pos);
                        foodList.add(takenFood);
                        System.out.println(name + " takes " + takenFood + " at position " + pos);
                    }
                }
            }
        } catch (InterruptedException ignore) {
        }
        return foodList;
    }
}
