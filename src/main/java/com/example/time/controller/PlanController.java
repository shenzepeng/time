package com.example.time.controller;

import com.example.time.pojo.Plan;
import com.example.time.service.PlanService;
import com.example.time.uitls.SzpJsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PlanController {
    @Autowired
    private PlanService planService;
    @ApiOperation("添加plan")
    @PostMapping("/insertPlan.action")
    public SzpJsonResult insertPlan(@RequestBody Plan plan){
        if (plan.getTitle()!=null&&plan.getUserId()!=null) {
            planService.insertPlan(plan);
            return SzpJsonResult.ok();
        }else {
            return SzpJsonResult.errorMsg("请填写完整信息");
        }
    }
    @ApiOperation("通过id删除plan")
    @DeleteMapping("/deletePlanById.action")
    public SzpJsonResult deletePlanById(Long id){
        planService.deletePlanById(id);
        return SzpJsonResult.ok();
    }

    @ApiOperation("更新plan，按主键id，更新值不为null的字段")
    @PutMapping("/updatePlanById.action")
    public SzpJsonResult updatePlanById(@RequestBody Plan plan){
        planService.updatePlanById(plan);
        Plan planById = planService.findPlanById(plan.getId());
        return SzpJsonResult.ok(planById);
    }

    @ApiOperation("通过id寻找plan")
    @GetMapping("/findPlanById.action")
    public SzpJsonResult findPlanById(Long id){
        Plan planById = planService.findPlanById(id);
        return SzpJsonResult.ok(planById);
    }

    @ApiOperation("通过UserId寻找plan")
    @GetMapping("/findPlanByUserId.action")
    public SzpJsonResult findPlanByUserId(Long id){
        List<Plan> planByUserId = planService.findPlanByUserId(id);
        return SzpJsonResult.ok(planByUserId);
    }

    @ApiOperation("通过title寻找plan")
    @GetMapping("/findPlanByTitle.action")
    public SzpJsonResult findPlanByTitle(String title,Long userId){
        List<Plan> planByTitle = planService.findPlanByTitle(title,userId);
        return SzpJsonResult.ok(planByTitle);
    }

    @ApiOperation("通过time寻找plan")
    @GetMapping("/findPlanByTime.action")
    public SzpJsonResult findPlanByTime(String time,Long userId){
        List<Plan> planByTime = planService.findPlanByTime(time,userId);
        return SzpJsonResult.ok(planByTime);
    }

    @ApiOperation("通过status寻找plan")
    @GetMapping("/findPlanByStatus.action")
    public SzpJsonResult findPlanByStatus(String status,Long userId){
        List<Plan> planByStatus = planService.findPlanByStatus(status,userId);
        return SzpJsonResult.ok(planByStatus);
    }
}
