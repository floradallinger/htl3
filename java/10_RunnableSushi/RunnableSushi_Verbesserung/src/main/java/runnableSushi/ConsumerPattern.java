package runnableSushi;

import java.util.List;

public interface ConsumerPattern {
    public List<Food> consume(List<Food> foodList, String name, Belt belt, int pos);
}
