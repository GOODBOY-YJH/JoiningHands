package com.example.joininghands.db.mapper;

import com.example.joininghands.db.domain.Mood;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Good Boy
* @description 针对表【mood(心情)】的数据库操作Mapper
* @createDate 2022-08-08 16:17:56
* @Entity com.example.joininghands.db.domain.Mood
*/
@Mapper
public interface MoodMapper extends BaseMapper<Mood> {

}




