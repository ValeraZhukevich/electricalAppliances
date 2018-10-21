package model.microwaves;

import model.appliance.AppBuilder;
import model.appliance.BasicBuilder;

public class MicrowaveBuilder implements AppBuilder<MicrowaveBuilder> {

    private BasicBuilder basicBuilder;
    private int volume;
    private boolean grill;

    public MicrowaveBuilder() {
        basicBuilder = new BasicBuilder();
    }

    public MicrowaveBuilder brand(String brand){
        basicBuilder.brand(brand);
        return this;
    }

    public MicrowaveBuilder grill(boolean state){
        this.grill = state;
        return this;
    }

    public MicrowaveBuilder model(String model) {
        basicBuilder.model(model);
        return this;
    }

    public MicrowaveBuilder serialNumber(String serialNumber){
        basicBuilder.serialNumber(serialNumber);
        return this;
    }

    public MicrowaveBuilder powerConsumption(int powerConsumption){
        basicBuilder.powerConsumption(powerConsumption);
        return this;
    }

    public  MicrowaveBuilder price(double price){
        basicBuilder.price(price);
        return this;
    }

    public MicrowaveBuilder volume(int volume){
        this.volume = volume;
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

    public int getVolume() {
        return volume;
    }

    public String getModel(){
        return  basicBuilder.getModel();
    }

    public BasicBuilder getBasicBuilder() {
        return basicBuilder;
    }
    public Microwave build(){
        if(!grill){
            return new Microwave(this);
        }
        else{
            return new MicrowavesWithGrill(this);
        }

    }

}
