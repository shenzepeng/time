package com.example.time.service;

import com.example.time.pojo.Plan;

import java.util.List;

public interface PlanService {
    void insertPlan(Plan plan);
    void deletePlanById(long id);
    void updatePlanById(Plan plan);
    Plan findPlanById(long id);
    List<Plan> findPlanByUserId(long id);
    List<Plan> findPlanByTitle(String title,long id);
    List<Plan> findPlanByTime(String time,long id);
    List<Plan> findPlanByStatus(String status,long id);
}
