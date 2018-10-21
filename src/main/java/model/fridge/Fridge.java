package model.fridge;

import model.appliance.Appliance;

import java.util.Objects;

public class Fridge extends Appliance {

    private double currentFridgeTemperature;
    private double minFridgeTemperature;
    private double maxFridgeTemperature;
    private double currentFreezeTemperature;
    private double minFreezeTemperature;
    private double maxFreezeTemperature;
    private double volume; // in liter

    public Fridge(FridgeBuilder fridgeBuilder) {
        super(fridgeBuilder.getBrand(), fridgeBuilder.getModel(), fridgeBuilder.getSerialNumber(),
                fridgeBuilder.getPowerConsumption(), fridgeBuilder.getPrice());
        this.maxFridgeTemperature = fridgeBuilder.getMaxFridgeTemperature();
        this.minFridgeTemperature = fridgeBuilder.getMinFridgeTemperature();
        this.maxFreezeTemperature = fridgeBuilder.getMaxFreezeTemperature();
        this.minFreezeTemperature = fridgeBuilder.getMinFreezeTemperature();
        this.volume = fridgeBuilder.getVolume();
        this.currentFreezeTemperature = maxFreezeTemperature;
        this.currentFridgeTemperature = maxFridgeTemperature;
    }

    public double getMinFridgeTemperature() {
        return minFridgeTemperature;
    }

    public double getMaxFridgeTemperature() {
        return maxFridgeTemperature;
    }

    public double getMaxFreezeTemperature() {
        return maxFreezeTemperature;
    }

    public double getMinFreezeTemperature(){
        return minFreezeTemperature;
    }

    public double getVolume() {
        return volume;
    }

    public double getCurrentFridgeTemperature() {
        return currentFridgeTemperature;
    }

    public double getCurrentFreezeTemperature() {
        return currentFreezeTemperature;
    }

    public void setCurrentFridgeTemperature(double currentFridgeTemperature) {
        if(currentFridgeTemperature >= minFridgeTemperature && currentFridgeTemperature <= maxFridgeTemperature){
            this.currentFridgeTemperature = currentFridgeTemperature;
        }
    }

    public void setCurrentFreezeTemperature(double currentFreezeTemperature) {
        if(currentFreezeTemperature >= minFreezeTemperature && currentFreezeTemperature <= maxFreezeTemperature)
        this.currentFreezeTemperature = currentFreezeTemperature;
    }
    @Override
    public void doWork() {
        System.out.println("Meat, vegetables and beer will not deteriorate");
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "brand=" + this.getBrand() + " " +
                "model=" + this.getModel() + " " +
                "volume=" + volume + " " +
                "price=" + this.getPrice()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fridge)) return false;

        Fridge fridge = (Fridge) o;

        if (!getBrand().toLowerCase().equals(fridge.getBrand().toLowerCase())) return false;
        if (!getModel().toLowerCase().equals(fridge.getModel().toLowerCase())) return false;
        if (Double.compare(fridge.getPowerConsumption(), getPowerConsumption()) != 0) return false;
        if (Double.compare(fridge.getPrice(), getPrice()) != 0) return false;
        if (Double.compare(fridge.getMinFridgeTemperature(), getMinFridgeTemperature()) != 0) return false;
        if (Double.compare(fridge.getMaxFridgeTemperature(), getMaxFridgeTemperature()) != 0) return false;
        if (Double.compare(fridge.getMinFreezeTemperature(), getMinFreezeTemperature()) != 0) return false;
        if (Double.compare(fridge.getMaxFreezeTemperature(), getMaxFreezeTemperature()) != 0) return false;
        return Double.compare(fridge.getVolume(), getVolume()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getMinFridgeTemperature());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMaxFridgeTemperature());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMinFreezeTemperature());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMaxFreezeTemperature());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getVolume());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
