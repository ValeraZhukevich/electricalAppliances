package model.appliance;

public interface AppBuilder<T> {

    public T brand(String brand);

    public T model(String model);

    public T serialNumber(String serialNumber);

    public T powerConsumption(int powerConsumption);

    public T price(double price);


}
