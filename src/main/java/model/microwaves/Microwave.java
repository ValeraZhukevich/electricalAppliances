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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Microwave)) return false;

        Microwave microwave = (Microwave) o;

        if (!getBrand().toLowerCase().equals(microwave.getBrand().toLowerCase())) return false;
        if (!getModel().toLowerCase().equals(microwave.getModel().toLowerCase())) return false;
        if (!getSerialNumber().toLowerCase().equals(microwave.getSerialNumber().toLowerCase())) return false;
        if (Double.compare(microwave.getPowerConsumption(), getPowerConsumption()) != 0) return false;
        if (Double.compare(microwave.getPrice(), getPrice()) != 0) return false;
        return getVolume() == microwave.getVolume();
    }

    @Override
    public int hashCode() {
        return getVolume();
    }
}
