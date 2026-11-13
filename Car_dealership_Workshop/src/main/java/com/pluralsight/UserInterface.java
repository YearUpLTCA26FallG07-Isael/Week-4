package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public void display() {
        init();

        boolean running = true;

        while (running) {
            System.out.println("""
==================================================
                 CAR DEALERSHIP
==================================================

    [1] Find Vehicles by Price
    [2] Find Vehicles by Make/Model
    [3] Find Vehicles by Year
    [4] Find Vehicles by Color
    [5] Find Vehicles by Mileage
    [6] Find Vehicles by Type
    [7] View All Vehicles
    [8] Add Vehicle
    [9] Remove Vehicle
    [X] Exit

==================================================
""");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "X":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(
                    vehicle.getId() + " | " +
                            vehicle.getVin() + " | " +
                            vehicle.getMake() + " | " +
                            vehicle.getModel() + " | " +
                            vehicle.getVehicleType() + " | " +
                            vehicle.getColor() + " | " +
                            vehicle.getOdometer() + " | " +
                            vehicle.getPrice()
            );
        }
    }

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processGetByPriceRequest() {
    }

    private void processGetByMakeModelRequest() {
    }

    private void processGetByYearRequest() {
    }

    private void processGetByColorRequest() {
    }

    private void processGetByMileageRequest() {
    }

    private void processGetByTypeRequest() {
    }

    private void processAddVehicleRequest() {
    }

    private void processRemoveVehicleRequest() {
    }
}
