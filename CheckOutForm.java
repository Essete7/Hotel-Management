package com.hotel;

import javax.swing.*;
import java.awt.*;

public class CheckOutForm extends JFrame {

    public CheckOutForm() {
        setTitle("Check Out Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2, 10, 10));

        JLabel roomLabel = new JLabel("Room Number:");
        JTextField roomField = new JTextField();

        JButton checkoutButton = new JButton("Check Out");
        JButton exitButton = new JButton("Exit");

        add(roomLabel);
        add(roomField);
        add(checkoutButton);
        add(exitButton);

        checkoutButton.addActionListener(e -> {
            String roomNumber = roomField.getText();
            boolean success = RoomDAO.checkoutRoom(roomNumber);
            if (success) {
                JOptionPane.showMessageDialog(this, "Room checked out successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to check out room.");
            }
        });

        exitButton.addActionListener(e -> dispose());

        setVisible(true);
    }
}
