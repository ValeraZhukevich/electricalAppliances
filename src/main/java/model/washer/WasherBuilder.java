package model.washer;

import model.appliance.AppBuilder;
import model.appliance.BasicBuilder;

public class WasherBuilder implements AppBuilder<WasherBuilder> {

    private BasicBuilder basicBuilder;
    private int maxSpinSpeed;
    private double maxLoad;
    private int maxTemperature;
    private boolean delicate;

    public WasherBuilder() {
        basicBuilder = new BasicBuilder();
    }

    public WasherBuilder brand(String brand){
        basicBuilder.brand(brand);
        return this;
    }

    public WasherBuilder delicate(boolean state){
        this.delicate = state;
        return this;
    }

    public WasherBuilder model(String model) {
        basicBuilder.model(model);
        return this;
    }

    public WasherBuilder serialNumber(String serialNumber){
        basicBuilder.serialNumber(serialNumber);
        return this;
    }

    public WasherBuilder powerConsumption(int powerConsumption){
        basicBuilder.powerConsumption(powerConsumption);
        return this;
    }

    public  WasherBuilder price(double price){
        basicBuilder.price(price);
        return this;
    }

    public WasherBuilder maxSpinSpeed(int maxSpinSpeed){
        this.maxSpinSpeed = maxSpinSpeed;
        return this;
    }

    public WasherBuilder maxLoad(double maxLoad){
        this.maxLoad = maxLoad;
        return this;
    }

    public WasherBuilder maxTemperature(int maxTemperature){
        this.maxTemperature = maxTemperature;
        return this;
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

    public int getMaxSpinSpeed() {
        return maxSpinSpeed;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public BasicBuilder getBasicBuilder() {
        return basicBuilder;
    }

    public Washer build(){
        if(!delicate){
            return  new Washer(this);
        }
        else{
            return new WasherWithDelicateMode(this);
        }
    }

    public String getModel() {
        return basicBuilder.getModel();
    }
}
