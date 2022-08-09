package com.example.joininghands.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.joininghands.db.domain.Mood;
import com.example.joininghands.service.MoodService;
import com.example.joininghands.db.mapper.MoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Good Boy
* @description 针对表【mood(心情)】的数据库操作Service实现
* @createDate 2022-08-08 16:17:56
*/
@Service
public class MoodServiceImpl extends ServiceImpl<MoodMapper, Mood>
    implements MoodService{
    @Autowired
    private MoodMapper moodMapper;
}




