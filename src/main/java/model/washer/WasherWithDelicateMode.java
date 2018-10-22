package model.washer;

public class WasherWithDelicateMode extends Washer implements DelicateWash {
    public WasherWithDelicateMode(WasherBuilder washerBuilder) {
        super(washerBuilder);
    }

    @Override
    public void doWork() {
        super.doWork();
        delicateWash();
    }

    public void delicateWash() {
        System.out.println("and can do it delicate");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WasherWithDelicateMode)) return false;

        WasherWithDelicateMode washer = (WasherWithDelicateMode) o;

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
