package model.appliance;

public abstract class Appliance {

    private String brand;
    private String model;
    private String serialNumber;
    private int powerConsumption; // the value in  watt
    private boolean isOn;
    private double price;

    public Appliance(String brand, String model, String serialNumber, int powerConsumption, double price){
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.powerConsumption = powerConsumption;
        this.price = price;
        this.model = model;
    }

    public void turnOn(){
        if(!isOn){
            isOn = true;
            doWork();
        }
    }
    public void turnOf(){
        if(isOn){
            isOn = false;
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }


    public boolean getIsOn(){
        return isOn;
    }
    public int getPowerConsumption(){
        return powerConsumption;
    }
    public abstract void doWork(); //?????????????????????????
}
