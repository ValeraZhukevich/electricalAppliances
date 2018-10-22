package controller;

import controller.Filters.Filter;
import model.ElectricityMeter;
import model.appliance.Appliance;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;


public class ControllerOfAppliance {

    private static final org.apache.log4j.Logger log = Logger.getLogger(ControllerOfAppliance.class);

    private List<Appliance> listOfAppliances;
    private ElectricityMeter electricityMeter = new ElectricityMeter();

    public void readListOfAppliancesFromFiles(String path){
        ParserAppliance parserAppliance = new ParserAppliance();
        listOfAppliances = parserAppliance.readDirectory(path);
    }

    public List<Appliance> getListOfAppliances() {
        return listOfAppliances;
    }

    public int getCurrentPowerConsumption(){
       return electricityMeter.getInstantPowerConsumption();
    }

    public void turnOnAppliance(Appliance appliance){
        if(!appliance.getIsOn()){
            appliance.turnOn();
            electricityMeter.increaseInstantPowerConsumption(appliance.getPowerConsumption());
            log.info(appliance.toString() + " was turn on");
        }
    }

    public List<Appliance> getFilteredListOfAppliances(Filter filter){
        List<Appliance> filteredList = SortAndFilters.filterAppliances(listOfAppliances, filter);
        return filteredList;
    }

    public void sortListOfAppliances(Comparator<Appliance> comparator){
        SortAndFilters.sortByComparator(listOfAppliances, comparator);
    }

    public void turnOffAppliance(Appliance appliance){
        if(appliance.getIsOn()){
            appliance.turnOf();
            electricityMeter.decreaseInstantPowerConsumption(appliance.getPowerConsumption());
            log.info(appliance.toString() + " was turn off");
        }
    }


}
