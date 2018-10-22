package model.tvs;

public class TVwithSmart extends TV implements SmartTV {
    public TVwithSmart(TVBuilder tvBuilder) {
        super(tvBuilder);
    }

    @Override
    public void doWork() {
        super.doWork();
        smartTV();
    }

    public void smartTV() {
        System.out.println("do it smart");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TVwithSmart)) return false;

        TVwithSmart tv = (TVwithSmart) o;

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
