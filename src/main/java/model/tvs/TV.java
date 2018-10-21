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
}
