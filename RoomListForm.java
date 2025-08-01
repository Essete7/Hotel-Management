package com.hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class RoomListForm extends JFrame {

    private JTable roomTable;

    public RoomListForm() {
        setTitle("Room List");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        roomTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(roomTable);

        add(scrollPane, BorderLayout.CENTER);

        loadRoomsFromDatabase();

        setVisible(true);
    }

    private void loadRoomsFromDatabase() {
        // Database connection info (adjust if needed)
        String url = "jdbc:postgresql://localhost:5432/hotel_db";
        String user = "hotel_user";
        String password = "hotel123";  // put your actual password here

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT room_number, room_type, price, is_occupied FROM rooms";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Get metadata for column names
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            // Prepare table model
            DefaultTableModel model = new DefaultTableModel();

            // Add columns
            Vector<String> columns = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(meta.getColumnName(i));
            }
            model.setColumnIdentifiers(columns);

            // Add rows
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                model.addRow(row);
            }

            roomTable.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load rooms: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

