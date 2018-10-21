package controller;

import controller.Filters.Filter;
import model.appliance.Appliance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAndFilters {

    public static void sortByComparator(List<Appliance> applianceList, Comparator<Appliance> comparator){
        Collections.sort(applianceList,comparator);
    }

    public static List<Appliance> filterAppliances(List<Appliance> applianceList, Filter filter){

        List<Appliance> filteredList = new ArrayList<Appliance>();
        for(Appliance appliance : applianceList){
            if(filter.satisfies(appliance)){
                filteredList.add(appliance);
            }
        }
        return filteredList;
    }

}
