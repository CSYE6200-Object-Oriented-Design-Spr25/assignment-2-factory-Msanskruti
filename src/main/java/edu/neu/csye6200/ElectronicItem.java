package edu.neu.csye6200;

public class ElectronicItem extends Item{
    private int warranty_Period;

    public ElectronicItem(String csvString){
        super(0,"",0);
        String[] parts = csvString.split(",");
        if(parts.length == 4){
            super.id = (int) Integer.parseInt(parts[0]);
            super.name = parts[1];
            super.price = Double.parseDouble(parts[2]);
            this.warranty_Period = Integer.parseInt(parts[3]);
        }
    }

    @Override
    public String toString(){
        return super.toString() + "  (Warranty : " + warranty_Period + " months)";
    }
}