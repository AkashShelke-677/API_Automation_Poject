package com.AkashShelke.POJOs.responcePoJO;

import com.API_Testing_Sample.PayLoad_Managment.Class.MannualWay.ReqPOJO.BookingClass;

public class BookingResponce {

    private Integer bookingid;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingClass getBooking() {
        return booking;
    }

    public void setBooking(BookingClass booking) {
        this.booking = booking;
    }

    private BookingClass booking;
}
