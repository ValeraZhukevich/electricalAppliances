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
}
