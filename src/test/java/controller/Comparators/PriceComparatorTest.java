package controller.Comparators;

import model.appliance.Appliance;
import model.fridge.FridgeBuilder;
import model.tvs.TVBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PriceComparatorTest {

    PriceComparator comparator = new PriceComparator();

    @DataProvider
    public Object[][] data() {
        return new Object[][] { { 100, 100, 0 }, { 50, 20, 1}, {200, 300, -1} };
    }

    @Test(dataProvider = "data")
    public void testCompare(int price1, int price2, int expectedResult) {
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
                .price(price1)
                .build();

        Appliance tv = new TVBuilder()
                .brand("Sony")
                .model("KDL-32WD752")
                .serialNumber("58648L")
                .powerConsumption(57)
                .screenDiagonal(32)
                .screenResolution("Full HD")
                .smartTV(true)
                .price(price2)
                .build();
        int result = comparator.compare(fridge,tv);

        Assert.assertEquals(result, expectedResult);
    }
}