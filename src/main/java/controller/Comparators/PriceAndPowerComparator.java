package controller.Comparators;

import model.appliance.Appliance;

import java.util.Comparator;

public class PriceAndPowerComparator implements Comparator<Appliance> {
    public int compare(Appliance appliance1, Appliance appliance2) {
        if(appliance1.getPrice() < appliance2.getPrice()){
            return -1;
        }
        else if(appliance1.getPrice() > appliance2.getPrice()){
            return 1;
        }
        else{
            return Double.compare(appliance1.getPowerConsumption(),appliance2.getPowerConsumption());
        }
    }
}
