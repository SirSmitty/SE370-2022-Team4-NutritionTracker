import java.util.*;

public class DailyFoodTracker {

    private List<FoodItem> foodList;
    private List<String> foodNames;

    public DailyFoodTracker() {

        foodList = new LinkedList<FoodItem>();
        foodNames = new LinkedList<String>();

    }

    public List<FoodItem> getFoodList() {
        return foodList;
    }

    public List<String> getFoodNameList() {
        // List<String> names = new LinkedList<String>();
        // for (int i = 0; i < foodList.size(); i++) {
        //     names.add(foodList.get(i).getName());
        // }
        // return names;
        return foodNames;

    }

    public void addFood(FoodItem food) {
        foodList.add(food);
        foodNames.add(food.getName());
    }

    public FoodItem removeFood(int foodIndex) {
        foodNames.remove(foodIndex-1);
        return foodList.remove(foodIndex - 1);
    }

}
