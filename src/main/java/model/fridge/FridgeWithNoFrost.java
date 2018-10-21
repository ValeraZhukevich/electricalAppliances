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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FridgeWithNoFrost)) return false;

        FridgeWithNoFrost fridge = (FridgeWithNoFrost) o;

        if (!getBrand().toLowerCase().equals(fridge.getBrand().toLowerCase())) return false;
        if (!getModel().toLowerCase().equals(fridge.getModel().toLowerCase())) return false;
        if (!getSerialNumber().toLowerCase().equals(fridge.getSerialNumber().toLowerCase())) return false;
        if (Double.compare(fridge.getPowerConsumption(), getPowerConsumption()) != 0) return false;
        if (Double.compare(fridge.getPrice(), getPrice()) != 0) return false;
        if (Double.compare(fridge.getMinFridgeTemperature(), getMinFridgeTemperature()) != 0) return false;
        if (Double.compare(fridge.getMaxFridgeTemperature(), getMaxFridgeTemperature()) != 0) return false;
        if (Double.compare(fridge.getMinFreezeTemperature(), getMinFreezeTemperature()) != 0) return false;
        if (Double.compare(fridge.getMaxFreezeTemperature(), getMaxFreezeTemperature()) != 0) return false;
        return Double.compare(fridge.getVolume(), getVolume()) == 0;
    }
}
