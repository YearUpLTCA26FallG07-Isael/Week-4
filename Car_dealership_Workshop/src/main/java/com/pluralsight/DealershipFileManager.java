package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class DealershipFileManager {
    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {

            String line = reader.readLine();
            String[] dealershipInfo = line.split("\\|");

            dealership = new Dealership(dealershipInfo[0], dealershipInfo[1], dealershipInfo[2]);

            while ((line = reader.readLine()) != null) {String[] data = line.split("\\|");

                int id = Integer.parseInt(data[0]);
                int vin = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String vehicleType = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                BigDecimal price = new BigDecimal(data[7]);

                Vehicle vehicle = new Vehicle(
                        id, vin, make, model,
                        vehicleType, color, odometer, price
                );

                dealership.addVehicle(vehicle);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
    }
}
