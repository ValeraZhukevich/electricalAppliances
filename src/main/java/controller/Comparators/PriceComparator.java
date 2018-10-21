package controller.Comparators;

import model.appliance.Appliance;

import java.util.Comparator;

public class PriceComparator implements Comparator<Appliance> {
    public int compare(Appliance appliance1, Appliance appliance2) {
        return Double.compare(appliance1.getPrice(), appliance2.getPrice());
    }
}
