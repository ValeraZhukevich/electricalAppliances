package controller;

import model.appliance.Appliance;
import model.fridge.FridgeBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ControllerOfApplianceTest {

    ControllerOfAppliance controllerOfAppliance = new ControllerOfAppliance();
    String path = "C:\\Users\\Valera\\IdeaProjects\\electricalAppliances\\src\\test\\data";

    @Test
    public void testTurnOnAppliance() {
        Appliance fridge = new FridgeBuilder()
                .brand("Atlant")
                .model("ХМ 6025-031")
                .serialNumber("25659ds2")
                .powerConsumption(48)
                .minFridgeTemperature(0)
                .maxFridgeTemperature(10)
                .minFreezeTemperature(-25)
                .maxFreezeTemperature(0)
                .volume(384)
                .price(850)
                .build();
        controllerOfAppliance.turnOnAppliance(fridge);
        Assert.assertTrue(fridge.getIsOn());
        Assert.assertTrue(controllerOfAppliance.getCurrentPowerConsumption() == 48);
    }


    @Test
    public void testTurnOffAppliance() {
        Appliance fridge = new FridgeBuilder()
                .brand("Atlant")
                .model("ХМ 6025-031")
                .serialNumber("25659ds2")
                .powerConsumption(48)
                .minFridgeTemperature(0)
                .maxFridgeTemperature(10)
                .minFreezeTemperature(-25)
                .maxFreezeTemperature(0)
                .volume(384)
                .price(850)
                .build();
        controllerOfAppliance.turnOffAppliance(fridge);
        Assert.assertTrue(!fridge.getIsOn());
        Assert.assertTrue(controllerOfAppliance.getCurrentPowerConsumption() == 0);
    }

    @Test
    public void testGetListOfAppliances1() {
        controllerOfAppliance.readListOfAppliancesFromFiles(path);
        List<Appliance>  listOfAppliances = controllerOfAppliance.getListOfAppliances();
        Assert.assertEquals(listOfAppliances.size(), 8);
    }
}