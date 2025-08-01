package com.hotel;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class BookingForm extends JFrame {
    private JTextField bookingIdField, roomNumberField, customerNameField, checkInDateField, checkOutDateField;

    public BookingForm() {
        setTitle("Booking Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));
        setLocationRelativeTo(null);

        // Labels and fields
        add(new JLabel("Booking ID:"));
        bookingIdField = new JTextField();
        add(bookingIdField);

        add(new JLabel("Room Number:"));
        roomNumberField = new JTextField();
        add(roomNumberField);

        add(new JLabel("Customer Name:"));
        customerNameField = new JTextField();
        add(customerNameField);

        add(new JLabel("Check-In Date (YYYY-MM-DD):"));
        checkInDateField = new JTextField();
        add(checkInDateField);

        add(new JLabel("Check-Out Date (YYYY-MM-DD):"));
        checkOutDateField = new JTextField();
        add(checkOutDateField);

        // Save Button
        JButton saveButton = new JButton("Save Booking");
        add(saveButton);
        saveButton.addActionListener(e -> saveBooking());

        // Exit Button
        JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void saveBooking() {
        try {
            String bookingId = bookingIdField.getText();
            String roomNumber = roomNumberField.getText();
            String customerName = customerNameField.getText();
            Date checkInDate = Date.valueOf(checkInDateField.getText());
            Date checkOutDate = Date.valueOf(checkOutDateField.getText());

            Booking booking = new Booking(bookingId, roomNumber, customerName, checkInDate, checkOutDate);
            boolean success = booking.saveToDatabase();

            if (success) {
                JOptionPane.showMessageDialog(this, "Booking saved successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save booking.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
        }
    }
}
