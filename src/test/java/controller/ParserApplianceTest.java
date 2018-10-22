package controller;

import model.appliance.Appliance;
import model.fridge.Fridge;
import model.fridge.FridgeBuilder;
import model.fridge.FridgeWithNoFrost;
import model.microwaves.Microwave;
import model.microwaves.MicrowaveBuilder;
import model.microwaves.MicrowavesWithGrill;
import model.tvs.TVBuilder;
import model.tvs.TVwithSmart;
import model.washer.WasherBuilder;
import model.washer.WasherWithDelicateMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ParserApplianceTest {

    ParserAppliance parserAppliance = new ParserAppliance();
    String path = "C:\\Users\\Valera\\IdeaProjects\\electricalAppliances\\src\\test\\data";



    @Test
    public void testGetFileNames(){

        List<String> list =  parserAppliance.getFileNames(path);
        Assert.assertEquals(list.size(), 4);

        String[] filesName = {"fridges.csv", "microwaves.csv", "TVs.csv", "washers.csv"};
        for(int i = 0; i < filesName.length; i++){
            if(!list.contains(filesName[i])){
                Assert.fail();
            }
        }
    }

    @Test
    public void testMakePath2File(){

        //given
        String path1 = "D:\\moves";
        String fileName = "Forest Gamp.mov";
        String expectedResult = "D:\\moves\\Forest Gamp.mov";

        //when
        String result = parserAppliance.makePath2File(path1, fileName);

        //then
        Assert.assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testReadFridgeCSV(){

        //given
        List<Appliance> list = parserAppliance.readFridgeCSV("C:\\Users\\Valera\\IdeaProjects\\electricalAppliances\\src\\test\\data\\fridges.csv");

        Appliance fridge1 = new FridgeBuilder()
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

        Assert.assertTrue(list.get(0).equals(fridge1));

        Appliance fridge2 = new FridgeBuilder()
                .brand("Liebherr")
                .model("CNbs 3915")
                .serialNumber("65825kt")
                .powerConsumption(40)
                .minFridgeTemperature(0)
                .maxFridgeTemperature(10)
                .minFreezeTemperature(-25)
                .maxFreezeTemperature(0)
                .volume(379)
                .noFrost(true)
                .price(1780).build();
        Assert.assertTrue(list.get(1).equals(fridge2));

    }

    @Test
    public void testReadDirectory(){
        List<Appliance> list = parserAppliance.readDirectory(path);
        List<Appliance> expectedList = new ArrayList<Appliance>();

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
        expectedList.add(fridge);

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
        expectedList.add(tv);

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
        expectedList.add(washer);

        Appliance microwave = new MicrowaveBuilder()
                .brand("Horizont")
                .model("20MW700-1479BKB")
                .serialNumber("25654qw3")
                .powerConsumption(1050)
                .volume(20)
                .price(168)
                .build();
        expectedList.add(microwave);

        Assert.assertTrue(list.containsAll(expectedList));

        Assert.assertEquals(list.size(), 8);
        int tvSmartInstance = 0;
        int microwaveInstance = 0;
        int microwaveWithGrillInstance = 0;
        int fridgeNoFrostInstance = 0;
        int fridgeInstance = 0;
        int washerWithDelicateMode = 0;
        for(Appliance a : list){
            if(a instanceof TVwithSmart) {tvSmartInstance++;}
            if(a instanceof Microwave) {microwaveInstance++;}
            if(a instanceof MicrowavesWithGrill) {microwaveWithGrillInstance++;}
            if(a instanceof FridgeWithNoFrost) {fridgeNoFrostInstance++;}
            if(a instanceof Fridge){fridgeInstance++;}
            if(a instanceof WasherWithDelicateMode) {washerWithDelicateMode++;}
        }

        Assert.assertEquals(list.size(),8);
        Assert.assertEquals(tvSmartInstance,2);
        Assert.assertEquals(microwaveInstance,2);
        Assert.assertEquals(microwaveWithGrillInstance,1);
        Assert.assertEquals(fridgeInstance,2);
        Assert.assertEquals(fridgeNoFrostInstance,1);
        Assert.assertEquals(washerWithDelicateMode,2);
    }
}