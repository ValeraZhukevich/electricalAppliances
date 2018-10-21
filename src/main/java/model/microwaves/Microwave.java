package model.microwaves;

import model.appliance.Appliance;

public class Microwave extends Appliance {

    private int volume;


    public Microwave(MicrowaveBuilder microwaveBuilder) {
        super(microwaveBuilder.getBrand(), microwaveBuilder.getModel(), microwaveBuilder.getSerialNumber(),
                microwaveBuilder.getPowerConsumption(), microwaveBuilder.getPrice());
        this.volume = microwaveBuilder.getVolume();
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public void doWork() {
        System.out.println("Food warms up");
    }

    @Override
    public String toString() {
        return "Microwave{" +
                "brand=" + this.getBrand() + " " +
                "model=" + this.getModel() + " " +
                "volume=" + volume + " " +
                "price=" + this.getPrice()+ " " +
                '}';
    }
}
