/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.lld.bms;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BMSTest {
    public static void main(String[] args) {

    }
}

class CinemaHall {
    String id;
    String name;
    Address address;

    List<Screen> screens;
}

class Address {
    String street;
    String city;
    String state;
    String country;
    int zipCode;
}

class Screen {
    String id;
    List<Seat> seats;
    List<Show> shows;
    String cimeaHallId;
}

class Seat {
    int id;
    char ch;
    SeatType type;
    SeatStatus status;
    double cost;
}

enum SeatType {
    NORMAL, PREMIUM, RECLINEAR
}

enum SeatStatus {
    BOOKED, AVAILIABLE
}

class Movie {
    int id;
    String name;
    String description;
    String lang;
    Genre genre;
}

enum Genre {
    HORROR, ACTION, THRILLER
}

class Show {
    int id;
    Movie movie;
    Date StartTime;
    Date endTime;
    String screenId;
    List<ShowSeat> showSeats;
}

class ShowSeat extends Seat {
    int showId;
}

class Booking {
    int id;
    List<ShowSeat> seats;
    Show show;
    Customer user;
    double amount;
    BookingStatus status;
    Date bookingDate;
}

enum BookingStatus {
    BOOKED, CANCELLED
}

class Payment {
    String paymentId;
    String bookingId;
    Date paymentDate;
    PaymentMode mode;
    PaymentStatus status;
    double totalAmount;
}

enum PaymentStatus {
    FAILED, DECLINED, SUCCESS
}

enum PaymentMode {
    UPI, CARD
}

class Account {
    String accountId;
    String userName;
    String passWord;
    AccountStatus status;

    public void regsiterAccount() {
    }
}

enum AccountStatus {
    ACTIVE, INAVTIVE, BLOCKED
}

class Person {
    String id;
    String name;
    String email;
    String phoneNo;
}

class Guest extends Person {
    public void registerAccount() {
    }
}

class Customer extends Person {
    Account account;

    boolean makeBooking(Booking booking) {
        return true;
    }

    public List<Booking> getBookings() {
        return Collections.emptyList();
    }
}

class Admin extends Customer {
    boolean addMovie(Movie movie) {
        return true;
    }

    boolean addShow(Show show) {
        return true;
    }

    boolean blockUser(Customer customer) {
        return true;
    }
}


