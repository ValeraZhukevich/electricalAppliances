package model.tvs;
import model.appliance.Appliance;

public class TV extends Appliance {

    private double screenDiagonal; // in inch
    private String screenResolution;
    private int instatntVolumeValue;
    private int instantProgramNumber;

    public TV(TVBuilder tvBuilder) {
        super(tvBuilder.getBrand(), tvBuilder.getModel(), tvBuilder.getSerialNumber(), tvBuilder.getPowerConsumption(), tvBuilder.getPrice());
        screenDiagonal = tvBuilder.getScreenDiagonal();
        screenResolution = tvBuilder.getScreenResolution();
        instantProgramNumber = 0;
        instatntVolumeValue = 50;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public int getInstantProgramNumber() {
        return instantProgramNumber;
    }

    public void setInstantProgramNumber(int instantProgramNumber) {
        if(instantProgramNumber >=0) {
            this.instantProgramNumber = instantProgramNumber;
        }
    }

    public int getInstatntVolumeValue() {
        return instatntVolumeValue;
    }

    public void setInstatntVolumeValue(int instatntVolumeValue) {
        if(instatntVolumeValue>=0 && instatntVolumeValue <= 100);
        this.instatntVolumeValue = instatntVolumeValue;
    }

    @Override
    public void doWork() {
        System.out.println("The Game Of Thrones is shown");
    }

    @Override
    public String toString() {
        return "TV{" +
                "brand=" + this.getBrand() + " " +
                "model=" + this.getModel() + " " +
                "screenDiagonal=" + screenDiagonal + " " +
                ", screenResolution='" + screenResolution + '\'' + " " +
                "price=" + this.getPrice()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TV)) return false;

        TV tv = (TV) o;

        if (Double.compare(tv.getScreenDiagonal(), getScreenDiagonal()) != 0) return false;
        if (!getBrand().toLowerCase().equals(tv.getBrand().toLowerCase())) return false;
        if (!getModel().toLowerCase().equals(tv.getModel().toLowerCase())) return false;
        if (!getSerialNumber().toLowerCase().equals(tv.getSerialNumber().toLowerCase())) return false;
        if (Double.compare(tv.getPowerConsumption(), getPowerConsumption()) != 0) return false;
        if (Double.compare(tv.getPrice(), getPrice()) != 0) return false;
        return getScreenResolution() != null ? getScreenResolution().equals(tv.getScreenResolution()) : tv.getScreenResolution() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getScreenDiagonal());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getScreenResolution() != null ? getScreenResolution().hashCode() : 0);
        return result;
    }
}
