package model.washer;

import model.appliance.Appliance;

public class Washer extends Appliance {

    private int maxTemperature;
    private static final int MIN_TEMPERATURE = 20;
    private int currentTemperature;
    private double maxLoad;
    private int maxSpinSpeed;
    private int currentSpinSpeed;

    public Washer(WasherBuilder washerBuilder) {
        super(washerBuilder.getBrand(), washerBuilder.getModel(),
                washerBuilder.getSerialNumber(),
                washerBuilder.getPowerConsumption(),
                washerBuilder.getPrice());
        maxTemperature = washerBuilder.getMaxTemperature();
        maxSpinSpeed = washerBuilder.getMaxSpinSpeed();
        maxLoad = washerBuilder.getMaxLoad();
        currentTemperature = MIN_TEMPERATURE;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public int getMaxSpinSpeed() {
        return maxSpinSpeed;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public int getCurrentSpinSpeed() {
        return currentSpinSpeed;
    }

    public void setCurrentTemperature(int currentTemperature) {
        if(currentTemperature >= MIN_TEMPERATURE && currentTemperature <= maxTemperature){
            this.currentTemperature = currentTemperature;
        }
    }

    public void setCurrentSpinSpeed(int currentSpinSpeed) {
        if(currentSpinSpeed >=0 && currentSpinSpeed <=maxSpinSpeed){
            this.currentSpinSpeed = currentSpinSpeed;
        }
    }

    @Override
    public void doWork(){
        System.out.println("Turning dirty clothes into clean at " + currentSpinSpeed + "spin speed, temperature is "
                + currentTemperature);
    }

    @Override
    public String toString() {
        return "Washer{" +
                "brand=" + this.getBrand() + " " +
                "model=" + this.getModel() + " " +
                ", maxLoad=" + maxLoad + " " +
                ", maxSpinSpeed=" + maxSpinSpeed + " " +
                ", currentSpinSpeed=" + currentSpinSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Washer)) return false;

        Washer washer = (Washer) o;

        if (getMaxTemperature() != washer.getMaxTemperature()) return false;
        if (Double.compare(washer.getMaxLoad(), getMaxLoad()) != 0) return false;
        if (!getBrand().toLowerCase().equals(washer.getBrand().toLowerCase())) return false;
        if (!getModel().toLowerCase().equals(washer.getModel().toLowerCase())) return false;
        if (!getSerialNumber().toLowerCase().equals(washer.getSerialNumber().toLowerCase())) return false;
        if (Double.compare(washer.getPowerConsumption(), getPowerConsumption()) != 0) return false;
        if (Double.compare(washer.getPrice(), getPrice()) != 0) return false;
        return getMaxSpinSpeed() == washer.getMaxSpinSpeed();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getMaxTemperature();
        temp = Double.doubleToLongBits(getMaxLoad());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getMaxSpinSpeed();
        return result;
    }
}
