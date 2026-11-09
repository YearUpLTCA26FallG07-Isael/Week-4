package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean Occupied;
    private boolean Dirty;


    public Room(int numberOfBeds , double price){
        this.numberOfBeds = numberOfBeds;
        this.price = price;
    }


    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return Occupied;
    }

    public boolean isDirty() {
        return Dirty;
    }

    public boolean isAvailable() {
        return (!Occupied)&(!Dirty);
    }
    public boolean checkIn(){
        return (Occupied)&(Dirty);
    }
    public boolean checkOut(){
        return (cleanRoom())&(!Occupied);

    }
    public boolean cleanRoom(){
        return (!Dirty);
    }
}
