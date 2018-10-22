package controller.Filters;

import model.appliance.Appliance;
import model.fridge.FridgeBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AllFiltersTest {

    AllFilters allFilters = new AllFilters();

    @DataProvider
    public Object[][] data() {
        return new Object[][] { { 150, 100, 200, 500, 100, 1000, true },
                { 80, 81, 100, 150, 100, 200, false}, {250, 100, 300, 800, 200, 250, false},
                {205, 200, 202, 800, 500, 700, false}};
    }


    @Test(dataProvider = "data")
    public void testSatisfies(int power, int minPower, int maxPower, int price, int minPrice,
                              int maxPrice, boolean expectedResult) {
        PowerConsumptionFilter powerConsumptionFilter = new PowerConsumptionFilter(minPower, maxPower);
        allFilters.addFilter(powerConsumptionFilter);
        PriceFilter priceFilter = new PriceFilter(minPrice, maxPrice);
        allFilters.addFilter(priceFilter);

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
                .price(price)
                .build();
        boolean result = allFilters.satisfies(appliance);
        Assert.assertEquals(result, expectedResult);
    }
}