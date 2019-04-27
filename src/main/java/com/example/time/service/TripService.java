package com.example.time.service;

import com.example.time.pojo.Trip;

import java.util.List;

public interface TripService {
    void insertTrip(Trip trip);
    void deleteTripById(long id);
    void updateTripById(Trip trip);
    Trip findTripById(long id);
    List<Trip> findTripByUserId(long userId);
    List<Trip> findTripByStatus(String status);
    List<Trip> findTripByTime(String time);
}
