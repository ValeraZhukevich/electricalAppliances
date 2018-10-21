package model.fridge;

import model.appliance.Appliance;

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
}
