package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
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
    }

    public static String promptForString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static int promptForInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public static BigDecimal promptForBigDecimal(String message) {
        while (true) {
            try {
                System.out.print(message);
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Try again.");
            }
        }
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.println("""
==================================================
                  VEHICLE LIST
==================================================
""");

        System.out.printf(
                "%-8s | %-6s | %-12s | %-12s | %-12s | %-10s | %-10s | %-10s%n",
                "ID", "Year", "Make", "Model", "Type", "Color", "Mileage", "Price"
        );

        System.out.println("------------------------------------------------------------------------------------------------");

        for (Vehicle vehicle : vehicles) {
            System.out.printf(
                    "%-8d | %-6d | %-12s | %-12s | %-12s | %-10s | %-10d | $%-10s%n",
                    vehicle.getId(),
                    vehicle.getVin(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice()
            );
        }
    }
    public static void pressEnterToContinue() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
