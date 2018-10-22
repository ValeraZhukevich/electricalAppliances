package model.microwaves;

public class MicrowavesWithGrill extends Microwave implements Grill {

    public MicrowavesWithGrill(MicrowaveBuilder microwaveBuilder) {
        super(microwaveBuilder);
    }

    public void grill() {
        System.out.println("and can make food grilled");
    }

    @Override
    public void doWork() {
        super.doWork();
        grill();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MicrowavesWithGrill)) return false;

        MicrowavesWithGrill microwave = (MicrowavesWithGrill) o;

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
