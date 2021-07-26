package com.test.demo.speed.mybatistest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.demo.speed.mybatistest.entity.AuthenticationAccessLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper extends BaseMapper<AuthenticationAccessLog> {
    void updateBatch(List<AuthenticationAccessLog> list);

}
