package controller;

import model.appliance.Appliance;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ControllerOfAppliance {

    public List<Appliance> getListOfAppliances() {
        return listOfAppliances;
    }

    private List<Appliance> listOfAppliances;
    private ElectricityMeter electricityMeter = new ElectricityMeter();

    public void turnOnAppliance(Appliance appliance){
        if(!appliance.getIsOn()){
            appliance.turnOn();
            electricityMeter.increaseInstantPowerConsumption(appliance.getPowerConsumption());
        }
    }
    public void turnOffAppliance(Appliance appliance){
        if(appliance.getIsOn()){
            appliance.turnOf();
            electricityMeter.decreaseInstantPowerConsumption(appliance.getPowerConsumption());
        }
    }


}
