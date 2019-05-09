package com.example.time.service;

import com.example.time.mapper.TripMapper;
import com.example.time.pojo.Trip;
import com.example.time.pojo.TripExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripMapper tripMapper;
    @Override
    public void insertTrip(Trip trip) {
        tripMapper.insert(trip);
    }

    @Override
    public void deleteTripById(long id) {
        tripMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateTripById(Trip trip) {
        tripMapper.updateByPrimaryKeySelective(trip);
    }

    @Override
    public Trip findTripById(long id) {
        Trip trip = tripMapper.selectByPrimaryKey(id);
        return trip;
    }

    @Override
    public List<Trip> findTripByUserId(long userId) {
        TripExample tripExample=new TripExample();
        tripExample.createCriteria()
                .andUserIdEqualTo(userId);
        List<Trip> trips = tripMapper.selectByExample(tripExample);
        return trips;
    }

    @Override
    public List<Trip> findTripByStatus(String status,long id) {
        TripExample tripExample=new TripExample();
        tripExample.createCriteria()
                .andStatusEqualTo(status)
                .andUserIdEqualTo(id);
        List<Trip> trips = tripMapper.selectByExample(tripExample);
        return trips;
    }

    @Override
    public List<Trip> findTripByTime(String time,long id) {
        TripExample tripExample=new TripExample();
        tripExample.createCriteria()
                .andTimeEqualTo(time)
                .andUserIdEqualTo(id);
        List<Trip> trips = tripMapper.selectByExample(tripExample);
        return trips;
    }
}
