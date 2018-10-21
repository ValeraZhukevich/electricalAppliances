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
}
