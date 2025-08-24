package com.AkashShelke.POJOs.responcePoJO.restfullBooker;


// POJO created json2 POJO by pasting the jason data "https://www.jsonschema2pojo.org/" or plugin jSOn2POGO

import com.AkashShelke.POJOs.reqPoJO.restfullBuker.Booking;

public class BookingResponse {

    private Integer bookingid;
    private Booking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
