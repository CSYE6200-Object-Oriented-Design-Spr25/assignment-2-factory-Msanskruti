package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store extends AbstractStore {

    private List<Item> items;

    public Store() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void sortID() {
        Collections.sort(items, (item1, item2) -> Integer.compare(item1.getId(), item2.getId()));
    }

    public void sortName() {
        Collections.sort(items, (item1, item2) -> item1.getName().compareTo(item2.getName()));
    }

    public void sortPrice() {
        Collections.sort(items, (item1, item2) -> Double.compare(item1.getPrice(), item2.getPrice()));
    }

    @Override
    public void demo() {
        // Read CSV files
        List<String> foodItems = FileUtil.readCSV("./src/main/java/edu/neu/csye6200/FoodItemCSV.txt");
        List<String> electronicItems = FileUtil.readCSV("./src/main/java/edu/neu/csye6200/ElectronicItemCSV.txt");
        List<String> serviceItems = FileUtil.readCSV("./src/main/java/edu/neu/csye6200/ServiceItemCSV.txt");

        // Initialize factories
        FactoryInterface foodItemFactory = new FoodItemFactory(); // Direct instantiation
        FactoryInterface electronicItemFactory = ElectronicItemFactory.getInstance(); // Singleton
        FactoryInterface ServiceItemFactory = serviceItemFactory.getInstance(); // Singleton

        // Add food items
        System.out.println("=============FOOD ITEMS=============");
        for (String csvData : foodItems) {
            Item foodItem = foodItemFactory.createItem(csvData);
            addItem(foodItem);
            System.out.println(foodItem);
        }

        // Add electronic items
        System.out.println("\n=============ELECTRONIC ITEMS=============");
        for (String csvData : electronicItems) {
            Item electronicItem = electronicItemFactory.createItem(csvData);
            addItem(electronicItem);
            System.out.println(electronicItem);
        }

        // Add service items
        System.out.println("\n=============SERVICE ITEMS=============");
        for (String csvData : serviceItems) {
            Item serviceItem = ServiceItemFactory.createItem(csvData);
            addItem(serviceItem);
            System.out.println(serviceItem);
        }

        // Sort and display items by ID
        sortID();
        System.out.println("\nSorted by ID:");
        items.forEach(System.out::println);

        // Sort and display items by Name
        sortName();
        System.out.println("\nSorted by Name:");
        items.forEach(System.out::println);

        // Sort and display items by Price
        sortPrice();
        System.out.println("\nSorted by Price:");
        items.forEach(System.out::println);
    }
}