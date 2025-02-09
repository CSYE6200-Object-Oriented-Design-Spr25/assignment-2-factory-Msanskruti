package edu.neu.csye6200;

public class ElectronicItemFactory implements FactoryInterface {
    private static final ElectronicItemFactory instance = new ElectronicItemFactory();

    private ElectronicItemFactory() {}

    public static ElectronicItemFactory getInstance() {
        return instance;
    }

    @Override
    public Item createItem(String csvData) {
        return new ElectronicItem(csvData);
    }
}