package com.hotel;

import java.sql.Date;
import com.hotel.BookingDAO;

public class Booking extends DatabaseEntity implements Saveable {
    private String bookingId;
    private String roomNumber;
    private String customerName;
    private Date checkInDate;
    private Date checkOutDate;

    public Booking(String bookingId, String roomNumber, String customerName, Date checkInDate, Date checkOutDate) {
        this.bookingId = bookingId;
        this.roomNumber = roomNumber;
        this.customerName = customerName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getBookingId() { return bookingId; }
    public String getRoomNumber() { return roomNumber; }
    public String getCustomerName() { return customerName; }
    public Date getCheckInDate() { return checkInDate; }
    public Date getCheckOutDate() { return checkOutDate; }

    @Override
    public boolean saveToDatabase() {
        return BookingDAO.saveBooking(this);
    }
}
