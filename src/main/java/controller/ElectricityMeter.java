package controller;

import java.util.Timer;
import java.util.TimerTask;

public class ElectricityMeter {

    private int instantPowerConsumption; // value in Watt
    private double consumedPower; // value in kWh
    private Timer timer;
    private TimerTask taskPerSecond;


    public ElectricityMeter() {
        this.timer = new Timer();
        instantPowerConsumption = 0;
        consumedPower = 0;
        srartWorking();

    }
    public double getConsumedPower() {
        return consumedPower;
    }

    public int getInstantPowerConsumption(){
        return instantPowerConsumption;
    }



    private void srartWorking(){
        taskPerSecond = new TimerTask() {
            @Override
            public void run() {
                measurePerSecond();
            }
        };

        timer.schedule(taskPerSecond, 1000, 1000);

    }

    private void measurePerSecond(){
        consumedPower += (double)instantPowerConsumption / 3600000;
    }

    public void increaseInstantPowerConsumption(int value){
        instantPowerConsumption += value;
    }

    public void decreaseInstantPowerConsumption(int value){
        if(value > instantPowerConsumption){
            instantPowerConsumption = 0;
        }
        else{
            instantPowerConsumption -= value;
        }

    }
}