package controller;

import model.ElectricityMeter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectricityMeterTest {

    @Test
    public void testGetConsumedPower() throws InterruptedException {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.increaseInstantPowerConsumption(3600000);
        Thread.sleep(2000);
        Assert.assertEquals(electricityMeter.getConsumedPower(), 1.0);
    }


    @Test
    public void testIncreaseInstantPowerConsumption() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.increaseInstantPowerConsumption(50);
        Assert.assertEquals(50, electricityMeter.getInstantPowerConsumption());
    }

    @Test
    public void testDecreaseInstantPowerConsumption() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.decreaseInstantPowerConsumption(100);
        Assert.assertEquals(electricityMeter.getInstantPowerConsumption(), 0);
        electricityMeter.increaseInstantPowerConsumption(50);
        electricityMeter.decreaseInstantPowerConsumption(25);
        Assert.assertEquals(electricityMeter.getInstantPowerConsumption(), 25);

    }
}