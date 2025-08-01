package com.hotel;

import com.hotel.Room;
import com.hotel.RoomDAO;
import com.hotel.Saveable;

public class RoomDAOTest {
    public static void main(String[] args) {
        Saveable room = new Room("201", "Deluxe", 120.0, false);
        boolean result = room.saveToDatabase();

        if (result) {
            System.out.println("Room saved successfully (via interface).");
        } else {
            System.out.println("Failed to save room.");
        }
    }
}
