package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

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
            Console.displayMessage("Error reading file: " + e.getMessage());
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("inventory.csv"))) {

            writer.println(
                    dealership.getName() + "|" +
                            dealership.getAddress() + "|" +
                            dealership.getPhone()
            );

            ArrayList<Vehicle> vehicles = dealership.getAllVehicles();

            for (Vehicle vehicle : vehicles) {
                writer.println(
                        vehicle.getId() + "|" +
                                vehicle.getVin() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdometer() + "|" +
                                vehicle.getPrice()
                );
            }

        } catch (IOException e) {
            Console.displayMessage("Error saving dealership: " + e.getMessage());
        }
    }
}
