package com.AkashShelke.Tests.restfullBooker.sample;

// To check framework is working or not this sample file will run
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSampleIntegration {

    //Create Bokking Create Token
    //Verify the Get Booking
    //Updatethe Booking
    //Delete the booking


    @Test(groups = "qa", priority = 1)
    @Owner("Akash")
    @Description("TC#1 -Step 1 Verify that the booking can be created ")
    public void testCreateBooking() {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 2)
    @Owner("Akash")
    @Description("TC#1 -Step 2 Verify that the booking By ID ")
    public  void testVerifyBookingID(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 3)
    @Owner("Akash")
    @Description("TC#1 -Step 3 Verify Update  booking by ID ")
    public  void testUpdateBookingByID() {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 4)
    @Owner("Akash")
    @Description("TC#1 -Step 3 Verify Delete booking by ID ")
    public  void testDeleteBookingByID() {
        Assert.assertTrue(true);
    }

}