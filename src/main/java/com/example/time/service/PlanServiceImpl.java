package com.example.time.service;

import com.example.time.mapper.PlanMapper;
import com.example.time.pojo.Plan;
import com.example.time.pojo.PlanExample;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanMapper planMapper;
    @Override
    public void insertPlan(Plan plan) {
        planMapper.insert(plan);
    }

    @Override
    public void deletePlanById(long id) {
        planMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updatePlanById(Plan plan) {
        planMapper.updateByPrimaryKeySelective(plan);
    }

    @Override
    public Plan findPlanById(long id) {
        Plan plan = planMapper.selectByPrimaryKey(id);
        return plan;
    }

    @Override
    public List<Plan> findPlanByUserId(long id) {
        PlanExample planExample=new PlanExample();
        planExample.createCriteria()
                .andUserIdEqualTo(id);
        List<Plan> plans = planMapper.selectByExample(planExample);
        return plans;
    }

    @Override
    public List<Plan> findPlanByTitle(String title) {
        PlanExample planExample=new PlanExample();
        planExample.createCriteria()
                .andTitleLike(title);
        List<Plan> plans = planMapper.selectByExample(planExample);
        return plans;
    }

    @Override
    public List<Plan> findPlanByTime(String time) {
        PlanExample planExample=new PlanExample();
        planExample.createCriteria()
                .andTimeEqualTo(time);
        List<Plan> plans = planMapper.selectByExample(planExample);
        return plans;
    }

    @Override
    public List<Plan> findPlanByStatus(String status) {
        PlanExample planExample=new PlanExample();
        planExample.createCriteria()
                .andStatusEqualTo(status);
        List<Plan> plans = planMapper.selectByExample(planExample);
        return plans;
    }
}
