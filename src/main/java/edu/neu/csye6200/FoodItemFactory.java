package edu.neu.csye6200;

public class FoodItemFactory implements FactoryInterface {
    @Override
    public Item createItem(String csvData) {
        return new FoodItem(csvData);
    }
}