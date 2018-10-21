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
}
