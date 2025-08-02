package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RoomDAO {
    public static boolean checkoutRoom(String roomNumber) {
        String sql = "UPDATE rooms SET is_occupied = false WHERE room_number = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, roomNumber);
            int updated = stmt.executeUpdate();
            return updated > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    private static final String URL = "jdbc:postgresql://localhost:5432/hotel_db";
    private static final String USER = "hotel_user";
    private static final String PASSWORD = "hotel123";

    public static boolean saveRoom(Room room) {
        String sql = "INSERT INTO rooms (room_number, room_type, price, is_occupied) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, room.getRoomNumber());
            stmt.setString(2, room.getRoomType());
            stmt.setDouble(3, room.getPrice());
            stmt.setBoolean(4, room.isOccupied());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
