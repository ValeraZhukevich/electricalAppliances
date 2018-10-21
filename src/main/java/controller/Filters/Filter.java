package controller.Filters;

import model.appliance.Appliance;

public interface Filter {
    public boolean satisfies(Appliance appliance);
}
