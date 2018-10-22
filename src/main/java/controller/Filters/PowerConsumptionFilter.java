package controller.Filters;

import model.appliance.Appliance;

public class PowerConsumptionFilter implements Filter {

    private int maxPowerConsumption;
    private int minPowerConsumption;

    public PowerConsumptionFilter(int minPowerConsumption, int maxPowerConsumption) {
        this.maxPowerConsumption = maxPowerConsumption;
        this.minPowerConsumption = minPowerConsumption;
    }

    public boolean satisfies(Appliance appliance) {
        if(appliance.getPowerConsumption() >= minPowerConsumption && appliance.getPowerConsumption() <= maxPowerConsumption){
            return true;
        }
        return false;
    }
}
