package com.example.time.controller;

import com.example.time.pojo.Remind;
import com.example.time.pojo.RemindExample;
import com.example.time.service.RemindService;
import com.example.time.uitls.SzpJsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemindController {
    @Autowired
    private RemindService remindService;
    @ApiOperation("通过id删除Remind")
    @DeleteMapping("/deleteRemindById.action")
    public SzpJsonResult deleteRemindById(Long id){
        remindService.deleteRemindById(id);
        return SzpJsonResult.ok();
    }
    @ApiOperation("添加remind")
    @PostMapping("/insertRemind.action")
    public SzpJsonResult insertRemind(@RequestBody Remind remind){
        if (remind.getTitle()==null){
            return SzpJsonResult.errorMsg("请检查上传信息是否完整");
        }else {
            remindService.insertRemind(remind);
            return SzpJsonResult.ok();
        }

    }
    @ApiOperation("更新Remind，按主键id，更新值不为null的字段")
    @PutMapping("/updateRemindById.action")
    public SzpJsonResult updateRemindById(@RequestBody Remind remind){
        remindService.updateRemindById(remind);
        Remind remindById = remindService.findRemindById(remind.getId());
        return SzpJsonResult.ok(remindById);
    }
    @ApiOperation("通过主键id找到Remind")
    @GetMapping("/findRemindById.action")
    public SzpJsonResult findRemindById(Long id){
        Remind remindById = remindService.findRemindById(id);
        return SzpJsonResult.ok(remindById);
    }
    @ApiOperation("通过UserID找到Remind")
    @GetMapping("/findRemindByUserId.action")
    public SzpJsonResult findRemindByUserId(Long userId){
        List<Remind> remindByUserId = remindService.findRemindByUserId(userId);
        return SzpJsonResult.ok(remindByUserId);
    }
}
