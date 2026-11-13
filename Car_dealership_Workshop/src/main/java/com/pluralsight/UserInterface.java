package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public void display() {
        init();

        boolean running = true;

        while (running) {
            Console.displayMenu();

            String choice = Console.promptForString("Enter your choice: ");

            switch (choice.toUpperCase()) {
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
                    Console.displayMessage("Invalid choice.");
            }
        }
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        Console.displayVehicles(vehicles);
    }

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
        Console.pressEnterToContinue();
    }

    private void processGetByPriceRequest() {
        BigDecimal min = Console.promptForBigDecimal("Enter minimum price: ");
        BigDecimal max = Console.promptForBigDecimal("Enter maximum price: ");

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);

        displayVehicles(vehicles);
        Console.pressEnterToContinue();
    }

    private void processGetByMakeModelRequest() {
        String make = Console.promptForString("Enter vehicle make: ");
        String model = Console.promptForString("Enter vehicle model: ");

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);

        displayVehicles(vehicles);
        Console.pressEnterToContinue();
    }

    private void processGetByYearRequest() {
        int min = Console.promptForInt("Enter minimum year: ");
        int max = Console.promptForInt("Enter maximum year: ");

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);

        displayVehicles(vehicles);
        Console.pressEnterToContinue();
    }

    private void processGetByColorRequest() {
        String color = Console.promptForString("Enter vehicle color: ");;

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
        Console.pressEnterToContinue();
    }

    private void processGetByMileageRequest() {
        int min = Console.promptForInt("Enter minimum mileage: ");
        int max = Console.promptForInt("Enter maximum mileage: ");

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);

        displayVehicles(vehicles);
        Console.pressEnterToContinue();
    }

    private void processGetByTypeRequest() {
        String type = Console.promptForString("Enter vehicle type: ");

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(type);

        displayVehicles(vehicles);
        Console.pressEnterToContinue();
    }

    private void processAddVehicleRequest() {
        int id = Console.promptForInt("Enter vehicle ID: ");
        int year = Console.promptForInt("Enter vehicle year: ");
        String make = Console.promptForString("Enter vehicle make: ");
        String model = Console.promptForString("Enter vehicle model: ");
        String vehicleType = Console.promptForString("Enter vehicle type: ");
        String color = Console.promptForString("Enter vehicle color: ");
        int odometer = Console.promptForInt("Enter vehicle mileage: ");
        BigDecimal price = Console.promptForBigDecimal("Enter vehicle price: ");

        Vehicle vehicle = new Vehicle(
                id, year, make, model, vehicleType,
                color, odometer, price
        );

        dealership.addVehicle(vehicle);

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        displayVehicles(dealership.getAllVehicles());

        Console.displayMessage("Vehicle added successfully!");
        Console.pressEnterToContinue();
    }

    private void processRemoveVehicleRequest() {
        int id = Console.promptForInt("Enter vehicle ID to remove: ");

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getId() == id) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);

            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);

            Console.displayMessage("Vehicle removed successfully!");
        } else {
            Console.displayMessage("Vehicle not found.");
        }

        Console.pressEnterToContinue();
    }
}
