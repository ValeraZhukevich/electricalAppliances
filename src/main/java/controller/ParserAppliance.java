package controller;

import model.appliance.Appliance;
import model.appliance.BasicBuilder;
import model.fridge.FridgeBuilder;
import model.microwaves.MicrowaveBuilder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import model.tvs.TVBuilder;
import model.washer.WasherBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ParserAppliance {

    public List<Appliance> readDirectory(String path){
        List<Appliance> appliances = new ArrayList<Appliance>();
        List<String> fileNames = getFileNames(path);
        for (String fileName : fileNames){
            if(fileName.toLowerCase().contains("fridge")){
                String fullPath = makePath2File(path,fileName);
                appliances.addAll(readFridgeCSV(fullPath));
            }
            else if(fileName.toLowerCase().contains("microwaves")){
                String fullPath = makePath2File(path,fileName);
                appliances.addAll(readMicrowaveCSV(fullPath));
            }
            else if(fileName.toLowerCase().contains("tvs")){
                String fullPath = makePath2File(path,fileName);
                appliances.addAll(readTVCSV(fullPath));
            }
            else if(fileName.toLowerCase().contains("washer")){
                String fullPath = makePath2File(path,fileName);
                appliances.addAll(readWasherCSV(fullPath));
            }
        }
        return appliances;
    }

    public String makePath2File(String path, String fileName){
        return new String(path + "\\" + fileName);
    }

    public List<String> getFileNames(String path){
        List<String> fileNames = new ArrayList<String>();
        File folder = new File(path);
        File[] files = folder.listFiles();

        for(File file : files){
            if(file.isFile()){
                fileNames.add(file.getName());
            }
        }
        return fileNames;
    }

    public List<Appliance> readFridgeCSV(String path){
        List<Appliance> fridges = new ArrayList<Appliance>();
        try {
            Reader reader = new FileReader(path);
            String[] headerMapping = {"brand", "model", "serial number", "power consumption",
                    "min model.fridge temperature", "max model.fridge temperature", "min freeze temperature",
                    "max freeze temperature", "volume", "no frost", "price"};
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withTrim()
                    .withHeader(headerMapping)
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
            );
            for(CSVRecord record : parser){

                double minFridgeTemperature, maxFridgeTemperature, minFreezeTemperature, maxFreezeTemperature, volume;

                FridgeBuilder fridgeBuilder = new FridgeBuilder();
                readBasicParameters(record, fridgeBuilder.getBasicBuilder());

                if(record.get("min model.fridge temperature") != null){
                    minFridgeTemperature = Double.parseDouble(record.get("min model.fridge temperature"));
                    fridgeBuilder.minFridgeTemperature(minFridgeTemperature);
                }
                if(record.get("max model.fridge temperature") != null){
                    maxFridgeTemperature = Double.parseDouble(record.get("max model.fridge temperature"));
                    fridgeBuilder.maxFridgeTemperature(maxFridgeTemperature);
                }
                if(record.get("min freeze temperature") != null){
                    minFreezeTemperature = Double.parseDouble(record.get("min freeze temperature"));
                    fridgeBuilder.minFreezeTemperature(minFreezeTemperature);
                }
                if(record.get("max freeze temperature") != null){
                    maxFreezeTemperature = Double.parseDouble(record.get("max freeze temperature"));
                    fridgeBuilder.maxFreezeTemperature(maxFreezeTemperature);
                }
                if(record.get("volume") != null){
                    volume = Double.parseDouble(record.get("volume"));
                    fridgeBuilder.volume(volume);
                }
                if(record.get("no frost") != null && !record.get("no frost").equals("")){
                    fridgeBuilder.noFrost(true);
                }

                Appliance fridge = fridgeBuilder.build();
                fridges.add(fridge);
            }
            reader.close();
            parser.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fridges;
    }

    private List<Appliance> readWasherCSV(String path){
        List<Appliance> washers = new ArrayList<Appliance>();
        try {
            Reader reader = new FileReader(path);
            String[] headerMapping = {"brand", "model", "serial number", "power consumption",
                    "max spin speed", "max temperature", "max load","delicate mode", "price"};
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withTrim()
                    .withHeader(headerMapping)
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
            );
            for(CSVRecord record : parser){

                double maxLoad;
                int maxSpinSpeed, maxTemperature;

                WasherBuilder washerBuilder = new WasherBuilder();
                readBasicParameters(record, washerBuilder.getBasicBuilder());

                if(record.get("max spin speed") != null){
                    maxSpinSpeed = Integer.parseInt(record.get("max spin speed"));
                    washerBuilder.maxSpinSpeed(maxSpinSpeed);
                }
                if(record.get("max temperature") != null){
                    maxTemperature = Integer.parseInt(record.get("max temperature"));
                    washerBuilder.maxTemperature(maxTemperature);
                }
                if(record.get("delicate mode") != null && !record.get("delicate mode").equals("")){
                    washerBuilder.delicate(true);
                }
                if(record.get("max load") != null){
                    maxLoad = Double.parseDouble(record.get("max load"));
                    washerBuilder.maxLoad(maxLoad);
                }

                Appliance washer = washerBuilder.build();
                washers.add(washer);
            }
            reader.close();
            parser.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return washers;
    }

    private List<Appliance> readMicrowaveCSV(String path){
        List<Appliance> microwaves = new ArrayList<Appliance>();
        try {
            Reader reader = new FileReader(path);
            String[] headerMapping = {"brand", "model", "serial number", "power consumption",
                    "volume", "grill", "price"};
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withTrim()
                    .withHeader(headerMapping)
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
            );
            for(CSVRecord record : parser){

                int volume;

                MicrowaveBuilder microwaveBuilder = new MicrowaveBuilder();
                readBasicParameters(record, microwaveBuilder.getBasicBuilder());

                if(record.get("volume") != null){
                    volume = Integer.parseInt(record.get("volume"));
                    microwaveBuilder.volume(volume);
                }
                if(record.get("grill") != null && !record.get("grill").equals("")){
                    microwaveBuilder.grill(true);
                }

                Appliance microwave = microwaveBuilder.build();
                microwaves.add(microwave);
            }
            reader.close();
            parser.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return microwaves;
    }

    private List<Appliance> readTVCSV(String path){
        List<Appliance> tVs = new ArrayList<Appliance>();
        try {
            Reader reader = new FileReader(path);
            String[] headerMapping = {"brand", "model", "serial number", "power consumption",
                    "screen diagonal", "screen resolution","smart model.tv", "price"};
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withTrim()
                    .withHeader(headerMapping)
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
            );
            for(CSVRecord record : parser){

                double screenDiagonal;
                String screenResolution;

                TVBuilder tvBuilder = new TVBuilder();
                readBasicParameters(record, tvBuilder.getBasicBuilder());

                if(record.get("screen diagonal") != null){
                    screenDiagonal = Double.parseDouble(record.get("screen diagonal"));
                    tvBuilder.screenDiagonal(screenDiagonal);
                }
                if(record.get("smart model.tv") != null && !record.get("smart model.tv").equals("")){
                    tvBuilder.smartTV(true);
                }
                if(record.get("screen resolution") != null){
                    screenResolution = record.get("screen resolution");
                    tvBuilder.screenResolution(screenResolution);
                }

                Appliance tv = tvBuilder.build();
                tVs.add(tv);
            }
            reader.close();
            parser.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tVs;
    }

    private void readBasicParameters(CSVRecord record, BasicBuilder builder){

        String brand, model, serialNumber;
        double price;
        int powerConsumption;

        if(record.get("brand") != null){
            brand = record.get("brand");
            builder.brand(brand);
        }
        if(record.get("model") != null){
            model = record.get("model");
            builder.model(model);
        }
        if(record.get("serial number") != null){
            serialNumber = record.get("serial number");
            builder.serialNumber(serialNumber);
        }
        if(record.get("price") != null){
            price = Double.parseDouble(record.get("price"));
            builder.price(price);
        }
        if(record.get("power consumption") != null){
            powerConsumption = Integer.parseInt(record.get("power consumption"));
            builder.powerConsumption(powerConsumption);
        }
    }

}
