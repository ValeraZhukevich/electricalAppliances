package controller;

import controller.Comparators.PowerConsumptionComparator;
import controller.Comparators.PriceComparator;
import controller.Filters.Filter;
import controller.Filters.PowerConsumptionFilter;
import controller.Filters.PriceFilter;
import model.appliance.Appliance;
import model.fridge.FridgeBuilder;
import model.microwaves.MicrowaveBuilder;
import model.tvs.TVBuilder;
import model.washer.WasherBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static controller.SortAndFilters.filterAppliances;
import static org.testng.Assert.*;

public class SortAndFiltersTest {

    List<Appliance> applianceList;
    PriceFilter priceFilter;
    PowerConsumptionFilter powerConsumptionFilter;


    @BeforeTest
    public void init(){
        applianceList = new ArrayList<>();
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
        applianceList.add(fridge);

        Appliance tv = new TVBuilder()
                .brand("Sony")
                .model("KDL-32WD752")
                .serialNumber("58648L")
                .powerConsumption(57)
                .screenDiagonal(32)
                .screenResolution("Full HD")
                .smartTV(true)
                .price(980)
                .build();
        applianceList.add(tv);

        Appliance washer = new WasherBuilder()
                .brand("LG")
                .model("F2J6WS0W")
                .serialNumber("1236589")
                .powerConsumption(800)
                .maxSpinSpeed(1200)
                .maxTemperature(95)
                .maxLoad(6)
                .delicate(true)
                .price(840)
                .build();
        applianceList.add(washer);

        Appliance microwave = new MicrowaveBuilder()
                .brand("Horizont")
                .model("20MW700-1479BKB")
                .serialNumber("25654qw3")
                .powerConsumption(1050)
                .volume(20)
                .price(168)
                .build();
        applianceList.add(microwave);
    }

    @Test
    public void testSortByComparator() {
        PowerConsumptionComparator powerConsumptionComparator = new PowerConsumptionComparator();
        PriceComparator priceComparator = new PriceComparator();
        SortAndFilters.sortByComparator(applianceList, powerConsumptionComparator);
        for(int i = 0; i < applianceList.size() - 1; i++){
            Assert.assertFalse(applianceList.get(i).getPowerConsumption() > applianceList.get(i+1).getPowerConsumption());
        }
        SortAndFilters.sortByComparator(applianceList, priceComparator);
        for(int i = 0; i < applianceList.size() - 1; i++){
            Assert.assertFalse(applianceList.get(i).getPrice() > applianceList.get(i+1).getPrice());
        }
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][] { { 810, 840, "1236589", 1000, 1200, "25654qw3"},
                { 900, 1000, "58648L", 40, 50, "25659ds2"} };
    }

    @Test(dataProvider = "data")
    public void testFilterAppliances(int minPrice, int maxPrice, String expectedSerialNumber1, int minPower, int maxPower,
                                      String expectedSerialNumber2) {

        powerConsumptionFilter = new PowerConsumptionFilter(minPower, maxPower);
        priceFilter = new PriceFilter(minPrice, maxPrice);

        List<Appliance> filteredListByPrice = SortAndFilters.filterAppliances(applianceList, priceFilter);
//        System.out.println(filteredListByPrice.size());
        List<Appliance> filteredListByPowerConsumption = SortAndFilters.filterAppliances(applianceList, powerConsumptionFilter);
//        System.out.println(filteredListByPowerConsumption.size());
        Assert.assertEquals(filteredListByPrice.size(),1);
        Assert.assertTrue(filteredListByPrice.get(0).getSerialNumber().equals(expectedSerialNumber1));

        Assert.assertEquals(filteredListByPowerConsumption.size(),1);
        Assert.assertTrue(filteredListByPowerConsumption.get(0).getSerialNumber().equals(expectedSerialNumber2));
    }
}