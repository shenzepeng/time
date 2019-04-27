package com.example.time.service;

import com.example.time.pojo.Remind;

import java.util.List;

public interface RemindService {
    void deleteRemindById(long id);
    void insertRemind(Remind remind);
    void updateRemindById(Remind remind);
    Remind findRemindById(long id);
    List<Remind> findRemindByUserId(long id);
}
