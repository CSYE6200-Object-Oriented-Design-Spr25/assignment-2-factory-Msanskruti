package edu.neu.csye6200;


public class ServiceItem extends Item{
    private int service_Duration;

    public ServiceItem(String csvString){
        super(0,"",0);
        String[] parts = csvString.split(",");
        if(parts.length == 4){
            super.id = Integer.parseInt(parts[0]);
            super.name = parts[1];
            super.price = Double.parseDouble(parts[2]);
            this.service_Duration = Integer.parseInt(parts[3]);
        }
    }

    @Override
    public String toString(){
        return super.toString() + " ( Duration : " + service_Duration + " hours)";
    }
}