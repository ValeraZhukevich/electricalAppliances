package model.tvs;

import model.appliance.AppBuilder;
import model.appliance.BasicBuilder;

public class TVBuilder implements AppBuilder<TVBuilder> {

    private BasicBuilder basicBuilder;
    private double screenDiagonal;
    private String screenResolution;
    private boolean smartTV;

    public TVBuilder() {

        basicBuilder = new BasicBuilder();
    }

    public TVBuilder brand(String brand){
        basicBuilder.brand(brand);
        return this;
    }

    public TVBuilder smartTV(boolean state){
        this.smartTV = state;
        return this;
    }

    public TVBuilder model(String model) {
        basicBuilder.model(model);
        return this;
    }

    public TVBuilder serialNumber(String serialNumber){
        basicBuilder.serialNumber(serialNumber);
        return this;
    }

    public TVBuilder powerConsumption(int powerConsumption){
        basicBuilder.powerConsumption(powerConsumption);
        return this;
    }

    public  TVBuilder price(double price){
        basicBuilder.price(price);
        return this;
    }

    public TVBuilder screenDiagonal(double screenDiagonal){
        this.screenDiagonal = screenDiagonal;
        return this;
    }

    public TVBuilder screenResolution(String screenResolution){
        this.screenResolution = screenResolution;
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

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public TV build(){
        if(!smartTV){
            return new TV(this);
        }
        else{
            return new TVwithSmart(this);
        }

    }

    public BasicBuilder getBasicBuilder() {
        return basicBuilder;
    }

    public String getModel() {
        return basicBuilder.getModel();
    }
}
