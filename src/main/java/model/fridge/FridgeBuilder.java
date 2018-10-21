package model.fridge;

import model.appliance.AppBuilder;
import model.appliance.BasicBuilder;

public class FridgeBuilder implements AppBuilder<FridgeBuilder> {

    private BasicBuilder basicBuilder;
    private double minFridgeTemperature;
    private double maxFridgeTemperature;
    private double minFreezeTemperature;
    private double maxFreezeTemperature;
    private double volume; // in liter
    private boolean noFrost;

    public FridgeBuilder(){
        basicBuilder = new BasicBuilder();
    }

    public FridgeBuilder maxFridgeTemperature(double maxFridgeTemperature){
        this.maxFridgeTemperature = maxFridgeTemperature;
        return this;
    }

    public FridgeBuilder minFridgeTemperature(double minFridgeTemperature){
        this.minFridgeTemperature = minFridgeTemperature;
        return this;
    }

    public FridgeBuilder noFrost(boolean noFrost){
        this.noFrost = noFrost;
        return this;
    }

    public FridgeBuilder maxFreezeTemperature(double maxFreezeTemperature){
        this.maxFreezeTemperature = maxFreezeTemperature;
        return this;
    }

    public FridgeBuilder minFreezeTemperature(double minFreezeTemperature){
        this.minFreezeTemperature = minFreezeTemperature;
        return this;
    }

    public FridgeBuilder volume(double volume){
        this.volume = volume;
        return this;
    }

    public FridgeBuilder brand(String brand){
        basicBuilder.brand(brand);
        return this;
    }

    public FridgeBuilder model(String model){
        basicBuilder.model(model);
        return this;
    }

    public FridgeBuilder serialNumber(String serialNumber){
        basicBuilder.serialNumber(serialNumber);
        return this;
    }

    public FridgeBuilder powerConsumption(int powerConsumption){
        basicBuilder.powerConsumption(powerConsumption);
        return this;
    }

    public FridgeBuilder price(double price){
        basicBuilder.price(price);
        return this;
    }

    public double getMinFridgeTemperature() {
        return minFridgeTemperature;
    }

    public double getMaxFridgeTemperature() {
        return maxFridgeTemperature;
    }

    public double getMinFreezeTemperature() {
        return minFreezeTemperature;
    }

    public double getMaxFreezeTemperature() {
        return maxFreezeTemperature;
    }

    public double getVolume() {
        return volume;
    }


    public BasicBuilder getBasicBuilder() {
        return basicBuilder;
    }

    public String getBrand() {
        return basicBuilder.getBrand();
    }

    public String getSerialNumber() {
        return basicBuilder.getSerialNumber();
    }

    public int getPowerConsumption() {
        return basicBuilder.getPowerConsumption();
    }

    public double getPrice() {
        return basicBuilder.getPrice();
    }

    public String getModel() {
        return basicBuilder.getModel();
    }


    public Fridge build(){
        if(!noFrost){
            return new Fridge(this);
        }
        else{
            return new FridgeWithNoFrost(this);
        }
    }
}
