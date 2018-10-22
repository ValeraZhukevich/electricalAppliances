package controller.Comparators;

import model.appliance.Appliance;
import model.fridge.FridgeBuilder;
import model.tvs.TVBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PowerConsumptionComparatorTest {

    PowerConsumptionComparator comparator = new PowerConsumptionComparator();

    @DataProvider
    public Object[][] data() {
        return new Object[][] { { 100, 100, 0 }, { 50, 20, 1}, {200, 300, -1} };
    }


    @Test(dataProvider = "data")
    public void testCompare(int power1, int power2, int expectedResult) {
        Appliance fridge = new FridgeBuilder()
                .brand("Atlant")
                .model("ХМ 6025-031")
                .serialNumber("25659ds2")
                .powerConsumption(power1)
                .minFridgeTemperature(0)
                .maxFridgeTemperature(10)
                .minFreezeTemperature(-25)
                .maxFreezeTemperature(0)
                .volume(384)
                .price(850)
                .build();

        Appliance tv = new TVBuilder()
                .brand("Sony")
                .model("KDL-32WD752")
                .serialNumber("58648L")
                .powerConsumption(power2)
                .screenDiagonal(32)
                .screenResolution("Full HD")
                .smartTV(true)
                .price(980)
                .build();

        int result = comparator.compare(fridge,tv);
        Assert.assertEquals(result,expectedResult);

    }
}