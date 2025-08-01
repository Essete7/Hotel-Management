package com.hotel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Room extends DatabaseEntity implements Saveable {
    private String roomNumber;
    private String roomType;
    private double price;
    private boolean isOccupied;

    public Room(String roomNumber, String roomType, double price, boolean isOccupied) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isOccupied = isOccupied;
    }

    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPrice() { return price; }
    public boolean isOccupied() { return isOccupied; }

    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public void setPrice(double price) { this.price = price; }
    public void setOccupied(boolean occupied) { isOccupied = occupied; }

    @Override
    public boolean saveToDatabase() {
        boolean success = RoomDAO.saveRoom(this);
        if (success) {
            saveToFile(); // Also save to file
        }
        return success;
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rooms.txt", true))) {
            writer.write(roomNumber + "," + roomType + "," + price + "," + isOccupied);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
