package com.example.time.service;

import com.example.time.mapper.RemindMapper;
import com.example.time.pojo.Remind;
import com.example.time.pojo.RemindExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RemindServiceImpl implements RemindService {
    @Autowired
    private RemindMapper remindMapper;
    @Override
    public void deleteRemindById(long id) {
        remindMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertRemind(Remind remind) {
        remindMapper.insert(remind);
    }

    @Override
    public void updateRemindById(Remind remind) {
        remindMapper.updateByPrimaryKeySelective(remind);
    }

    @Override
    public Remind findRemindById(long id) {
        Remind remind = remindMapper.selectByPrimaryKey(id);
        return remind;
    }

    @Override
    public List<Remind> findRemindByUserId(long id) {
        RemindExample remindExample=new RemindExample();
        remindExample.createCriteria()
                .andUserIdEqualTo(id);
        List<Remind> reminds = remindMapper.selectByExample(remindExample);
        return reminds;
    }
}
