package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Ocean View", 2, 3);

        System.out.println("Hotel: " + hotel.getName());

        // Book all suites
        System.out.println("Suite booked: " + hotel.bookSuite());
        System.out.println("Suite booked: " + hotel.bookSuite());
        System.out.println("Suite booked: " + hotel.bookSuite());

        // Book all basic rooms
        System.out.println("Basic room booked: " + hotel.bookBasicRoom());
        System.out.println("Basic room booked: " + hotel.bookBasicRoom());
        System.out.println("Basic room booked: " + hotel.bookBasicRoom());
        System.out.println("Basic room booked: " + hotel.bookBasicRoom());

        System.out.println("Booked suites: " + hotel.getBookedSuites());
        System.out.println("Booked basic rooms: " + hotel.getBookedBasicRooms());

    }
}