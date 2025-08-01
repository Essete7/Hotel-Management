package com.hotel;

import java.sql.Date;

public class BookingDAOTest {
    public static void main(String[] args) {
        Booking booking = new Booking("B101", "101", "Alice", Date.valueOf("2025-07-10"), Date.valueOf("2025-07-12"));
        boolean result = BookingDAO.saveBooking(booking);

        if (result) {
            System.out.println("Booking saved successfully.");
        } else {
            System.out.println("Failed to save booking.");
        }
    }
}
