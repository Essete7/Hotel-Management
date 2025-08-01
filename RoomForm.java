package com.hotel;

import javax.swing.*;
import java.awt.*;
import com.hotel.Room;
import com.hotel.RoomDAO;

public class RoomForm extends JFrame {

    private JTextField roomNumberField;
    private JComboBox<String> roomTypeBox;
    private JTextField priceField;
    private JCheckBox occupiedCheck;

    public RoomForm() {
        setTitle("Add Room");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Room Number:"));
        roomNumberField = new JTextField();
        add(roomNumberField);

        add(new JLabel("Room Type:"));
        roomTypeBox = new JComboBox<>(new String[]{"Single", "Double", "Suite"});
        add(roomTypeBox);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        add(new JLabel("Is Occupied?"));
        occupiedCheck = new JCheckBox();
        add(occupiedCheck);

        JButton saveButton = new JButton("Save Room");
        JButton exitButton = new JButton("Exit");

        add(saveButton);
        add(exitButton);

        saveButton.addActionListener(e -> saveRoom());
        exitButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void saveRoom() {
        String number = roomNumberField.getText();
        String type = (String) roomTypeBox.getSelectedItem();
        double price = Double.parseDouble(priceField.getText());
        boolean isOccupied = occupiedCheck.isSelected();

        Room room = new Room(number, type, price, isOccupied);
        RoomDAO dao = new RoomDAO();

        boolean success = dao.saveRoom(room);
        if (success) {
            JOptionPane.showMessageDialog(this, "Room saved successfully.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save room.");
        }
    }
}
