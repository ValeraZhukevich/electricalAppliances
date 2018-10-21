package model.appliance;

public class BasicBuilder implements AppBuilder<BasicBuilder> {

    private String brand;
    private String serialNumber;
    private int powerConsumption;
    private double price;
    private String model;

    public BasicBuilder brand(String brand){
        this.brand = brand;
        return this;
    }

    public BasicBuilder model(String model){
        this.model = model;
        return this;
    }

    public BasicBuilder serialNumber(String serialNumber){
        this.serialNumber = serialNumber;
        return this;
    }

    public BasicBuilder powerConsumption(int powerConsumption){
        this.powerConsumption = powerConsumption;
        return this;
    }

    public BasicBuilder price(double price){
        this.price = price;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}
