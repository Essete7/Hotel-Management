package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookingDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/hotel_db";
    private static final String USER = "hotel_user";
    private static final String PASSWORD = "hotel123";

    public static boolean saveBooking(Booking booking) {
        String sql = "INSERT INTO bookings (booking_id, room_number, customer_name, check_in_date, check_out_date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, booking.getBookingId());
            stmt.setString(2, booking.getRoomNumber());
            stmt.setString(3, booking.getCustomerName());
            stmt.setDate(4, booking.getCheckInDate());
            stmt.setDate(5, booking.getCheckOutDate());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    