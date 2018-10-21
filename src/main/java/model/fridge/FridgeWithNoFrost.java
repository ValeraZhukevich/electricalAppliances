package model.fridge;

public class FridgeWithNoFrost extends Fridge implements  NoFrost{
    public FridgeWithNoFrost(FridgeBuilder fridgeBuilder) {
        super(fridgeBuilder);
    }

    @Override
    public void doWork() {
        super.doWork();
        workWithoutFrost();
    }

    public void workWithoutFrost() {
        System.out.println("That's all without ice");
    }
}
