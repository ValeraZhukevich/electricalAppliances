package controller.Filters;

import model.appliance.Appliance;
import java.util.ArrayList;
import java.util.List;

public class AllFilters implements Filter {

    private List<Filter> filters;

    public AllFilters(){
        filters = new ArrayList<Filter>();
    }

    public void addFilter(Filter f){
        filters.add(f);
    }

    public boolean satisfies(Appliance appliance) {
        for(Filter f : filters){
            if(!f.satisfies(appliance)){
                return false;
            }
        }
        return true;
    }
}
