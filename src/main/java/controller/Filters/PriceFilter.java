package controller.Filters;

import model.appliance.Appliance;

public class PriceFilter implements Filter {

    private double minPrice;
    private double maxPrice;

    public PriceFilter(double minPrice, double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public boolean satisfies(Appliance appliance) {
        if(appliance.getPrice() >= minPrice && appliance.getPrice() <= maxPrice){
            return true;
        }
        return false;
    }


}
