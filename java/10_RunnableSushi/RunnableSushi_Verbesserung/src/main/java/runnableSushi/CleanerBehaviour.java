package runnableSushi;

import java.util.List;

public class CleanerBehaviour implements ConsumerPattern{
    @Override
    public List<Food> consume(List<Food> foodList, String name, Belt belt, int pos) {
        Food f = null;
        try {
            while(!Thread.interrupted()){
                synchronized(belt){
                    if(!belt.isEmpty()){
                        if(belt.isFreeAtPosition(pos)){
                            belt.wait();
                        } else {
                            foodList.add(belt.remove(pos));
                        }

                    } else {
                        break;
                    }
                }
            }
        } catch (InterruptedException ignore) {

        }
        return foodList;
    }
}
