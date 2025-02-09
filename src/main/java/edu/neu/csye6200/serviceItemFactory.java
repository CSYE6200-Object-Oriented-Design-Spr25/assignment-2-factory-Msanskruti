package edu.neu.csye6200;

public class serviceItemFactory implements FactoryInterface {
    private static final serviceItemFactory instance = new serviceItemFactory();

    private serviceItemFactory() {}

    public static serviceItemFactory getInstance() {
        return instance;
    }

    @Override
    public Item createItem(String csvData) {
        return new ServiceItem(csvData);
    }
}