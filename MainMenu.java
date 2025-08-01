package com.hotel;

import javax.swing.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Hotel Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // ✅ Manage Rooms
        JButton roomBtn = new JButton("Manage Rooms");
        roomBtn.setBounds(100, 30, 200, 30);
        add(roomBtn);
        roomBtn.addActionListener(e -> new RoomForm());

        // ✅ Manage Bookings
        JButton bookingBtn = new JButton("Manage Bookings");
        bookingBtn.setBounds(100, 70, 200, 30);
        add(bookingBtn);
        bookingBtn.addActionListener(e -> new BookingForm());

        // ✅ Check Out (FIXED)
        JButton checkOutBtn = new JButton("Check Out");
        checkOutBtn.setBounds(100, 110, 200, 30);
        add(checkOutBtn);
        checkOutBtn.addActionListener(e -> new CheckOutForm());

        // ✅ Room List
        JButton roomListBtn = new JButton("Room List");
        roomListBtn.setBounds(100, 150, 200, 30);
        add(roomListBtn);
        roomListBtn.addActionListener(e -> new RoomListForm());

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
