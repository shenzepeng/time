package com.example.time.controller;

import com.example.time.mapper.TripMapper;
import com.example.time.pojo.Trip;
import com.example.time.service.TripService;
import com.example.time.uitls.SzpJsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {
    @Autowired
    private TripService tripService;
    @ApiOperation("添加trip")
    @PostMapping("/insertTrip.action")
    public SzpJsonResult insertTrip(@RequestBody Trip trip){
        if (trip.getUserId()!=null&&trip.getTime()!=null) {
            tripService.insertTrip(trip);
            return SzpJsonResult.ok();
        }else {
            return SzpJsonResult.errorMsg("请检查输入信息");
        }
    }
    @ApiOperation("通过id删除Trip")
    @DeleteMapping("/deleteTripById.action")
    public SzpJsonResult deleteTripById(@RequestBody Long id){
        tripService.deleteTripById(id);
        return SzpJsonResult.ok();
    }
    @ApiOperation("更新trip，按主键id，更新值不为null的字段")
    @PutMapping("/updateTripById.action")
    public SzpJsonResult updateTripById(@RequestBody Trip trip){
        tripService.updateTripById(trip);
        return SzpJsonResult.ok();
    }
    @ApiOperation("通过id更新Trip")
    @GetMapping("/findTripById.action")
    public SzpJsonResult findTripById(Long id){
        Trip tripById = tripService.findTripById(id);
        return SzpJsonResult.ok(tripById);
    }
    @ApiOperation("通过UserId找到Trip")
    @GetMapping("/findTripByUserId.action")
    public SzpJsonResult findTripByUserId(Long userId){
        List<Trip> tripByUserId = tripService.findTripByUserId(userId);
        return SzpJsonResult.ok(tripByUserId);
    }
    @ApiOperation("通过status找到Trip")
    @GetMapping("/findTripByStatus.action")
    public SzpJsonResult findTripByStatus(String status,Long id){
        List<Trip> tripByStatus = tripService.findTripByStatus(status,id);
        return SzpJsonResult.ok(tripByStatus);
    }
    @ApiOperation("通过time找到Trip")
    @GetMapping("/findTripByTime.action")
    public SzpJsonResult findTripByTime(String time,Long id){
        List<Trip> tripByTime = tripService.findTripByTime(time,id);
        return SzpJsonResult.ok(tripByTime);
    }
}
