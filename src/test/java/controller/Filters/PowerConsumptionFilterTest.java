package controller.Filters;

import model.appliance.Appliance;
import model.fridge.FridgeBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PowerConsumptionFilterTest {

    PowerConsumptionFilter filter;

    @DataProvider
    public Object[][] data() {
        return new Object[][] { { 100, 100, 200, true }, { 80, 81, 100, false}, {150, 100, 200, true},
                {205, 200, 202, false}};
    }


    @Test(dataProvider = "data")
    public void testSatisfies(int power,int minPower, int maxPower, boolean expectedResult) {
        filter = new PowerConsumptionFilter(minPower, maxPower);
        Appliance appliance = new FridgeBuilder()
                .brand("Atlant")
                .model("ХМ 6025-031")
                .serialNumber("25659ds2")
                .powerConsumption(power)
                .minFridgeTemperature(0)
                .maxFridgeTemperature(10)
                .minFreezeTemperature(-25)
                .maxFreezeTemperature(0)
                .volume(384)
                .price(700)
                .build();
        boolean result = filter.satisfies(appliance);
        Assert.assertEquals(result,expectedResult);
    }
}